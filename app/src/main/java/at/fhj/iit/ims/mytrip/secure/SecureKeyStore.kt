package at.fhj.iit.ims.mytrip.secure


import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import java.security.KeyStore
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey


/**
 * Creates/loads a per-account AES-GCM key stored in Android Keystore.
 * We scope the key by an alias hash derived from the user's email, but DO NOT use the email as key material.
 */
object SecureKeyStore {
    private const val ANDROID_KEYSTORE = "AndroidKeyStore"


    private fun aliasFor(email: String) = "mytrip_comm_${'$'}{email.lowercase().hashCode()}"


    fun getOrCreateKey(email: String): SecretKey {
        val ks = KeyStore.getInstance(ANDROID_KEYSTORE).apply { load(null) }
        val alias = aliasFor(email)
        if (ks.containsAlias(alias)) {
            val entry = ks.getEntry(alias, null) as KeyStore.SecretKeyEntry
            return entry.secretKey
        }
        val keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, ANDROID_KEYSTORE)
        val spec = KeyGenParameterSpec.Builder(
            alias,
            KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
        ).setBlockModes(KeyProperties.BLOCK_MODE_GCM)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
            .setRandomizedEncryptionRequired(true)
            .setUserAuthenticationRequired(false)
            .build()
        keyGenerator.init(spec)
        return keyGenerator.generateKey()
    }
}