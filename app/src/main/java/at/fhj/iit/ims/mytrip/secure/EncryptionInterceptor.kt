package at.fhj.iit.ims.mytrip.secure


import android.content.Context
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.MediaType
import okhttp3.RequestBody
import okio.Buffer


/**
 * OkHttp application-layer payload encryption. Wraps JSON request/response bodies in an AES-GCM envelope.
 * Adds headers so the server knows to decrypt.
 *
 * Header contract:
 * X-Enc: AESGCM1
 * X-User: <email>
 */
class EncryptionInterceptor(private val appContext: Context) : Interceptor {
    private val envelopeMediaType: MediaType = "application/mytrip+enveloped".toMediaType()


    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val email = SecureIdentity.requireEmail(appContext)
        val key = SecureKeyStore.getOrCreateKey(email)


        val req = if (original.body != null && isJson(original)) encryptRequest(original, key, email) else original
        val resp = chain.proceed(req)
        return if (resp.header("X-Enc") == "AESGCM1") decryptResponse(resp, key) else resp
    }


    private fun isJson(request: Request): Boolean =
        request.body?.contentType()?.subtype == "json"


    private fun encryptRequest(original: Request, key: javax.crypto.SecretKey, email: String): Request {
        val rawBody = original.body ?: return original
        val buf = Buffer()
        rawBody.writeTo(buf)
        val rawJson = buf.readUtf8()
        val env = CryptoEngine.encryptJson(rawJson, key)
        val wrappedBody = RequestBody.create(envelopeMediaType, env.toJson())
        return original.newBuilder()
            .header("X-Enc", "AESGCM1")
            .header("X-User", email)
            .method(original.method, wrappedBody)
            .build()
    }


    private fun decryptResponse(response: Response, key: javax.crypto.SecretKey): Response {
        val body = response.body ?: return response
        val bodyStr = body.string()
        val plaintext = CryptoEngine.decryptToJson(bodyStr, key)
        val newBody = ResponseBody.create("application/json".toMediaType(), plaintext)
        return response.newBuilder()
            .removeHeader("X-Enc")
            .body(newBody)
            .build()
    }
}