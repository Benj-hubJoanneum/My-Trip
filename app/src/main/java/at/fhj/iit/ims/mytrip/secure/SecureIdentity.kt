package at.fhj.iit.ims.mytrip.secure


import android.app.Activity
import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions


/**
 * Handles obtaining the Google account. You must call startSignIn() from an Activity at least once,
 * then getSignedInAccount() can return the cached account with email/displayName.
 */
object SecureIdentity {
    private lateinit var gso: GoogleSignInOptions


    fun client(context: Context): GoogleSignInClient {
        if (!::gso.isInitialized) {
            gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        }
        return GoogleSignIn.getClient(context, gso)
    }


    fun getSignedInAccount(context: Context): GoogleSignInAccount? =
        GoogleSignIn.getLastSignedInAccount(context)


    fun requireEmail(context: Context): String {
        val acc = getSignedInAccount(context)
            ?: error("No Google account signed in. Call SecureIdentity.startSignIn(...) first.")
        return acc.email ?: error("Account has no email.")
    }


    /**
     * Kick off the sign-in UI. Call in Activity and override onActivityResult if needed.
     */
    fun startSignIn(activity: Activity, requestCode: Int) {
        val signInIntent = client(activity).signInIntent
        activity.startActivityForResult(signInIntent, requestCode)
    }
}