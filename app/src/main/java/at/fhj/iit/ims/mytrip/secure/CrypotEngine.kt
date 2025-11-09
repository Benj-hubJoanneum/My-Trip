package at.fhj.iit.ims.mytrip.secure

import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec
import java.security.SecureRandom

/**
 * Minimal AES-GCM helper with 12-byte IV and 128-bit auth tag.
 */
object CryptoEngine {
    data class Envelope(val ivB64: String, val ctB64: String) {
        fun toJson(): String = """{"v":1,"iv":"$ivB64","ct":"$ctB64"}"""
    }

    fun encryptJson(json: String, key: SecretKey): Envelope {
        val iv = ByteArray(12).also { SecureRandom().nextBytes(it) } // cryptographically strong IV
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        val gcm = GCMParameterSpec(128, iv)
        cipher.init(Cipher.ENCRYPT_MODE, key, gcm)
        val ciphertext = cipher.doFinal(json.toByteArray(Charsets.UTF_8))
        return Envelope(
            Base64.encodeToString(iv, Base64.NO_WRAP),
            Base64.encodeToString(ciphertext, Base64.NO_WRAP)
        )
    }

    fun decryptToJson(envelopeJson: String, key: SecretKey): String {
        // Tiny parser (expects {"v":1,"iv":"...","ct":"..."})
        fun extract(field: String): String {
            // Use a raw string so \s is a regex escape, not a Kotlin string escape
            val regex = Regex("""\"$field\"\s*:\s*\"([^\"]+)\"""")
            return regex.find(envelopeJson)?.groupValues?.get(1)
                ?: error("Missing field $field")
        }
        val iv = Base64.decode(extract("iv"), Base64.NO_WRAP)
        val ct = Base64.decode(extract("ct"), Base64.NO_WRAP)
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        val gcm = GCMParameterSpec(128, iv)
        cipher.init(Cipher.DECRYPT_MODE, key, gcm)
        val pt = cipher.doFinal(ct)
        return String(pt, Charsets.UTF_8)
    }
}
