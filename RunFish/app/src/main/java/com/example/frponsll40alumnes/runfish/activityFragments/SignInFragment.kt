package com.example.frponsll40alumnes.runfish.activityFragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.fragment_sign_in.*

class SignInFragment : Fragment() {

    var RETURN_CODE_SIGN_IN : Int = 1;

    private lateinit var auth : FirebaseAuth;
    private lateinit var googleSignInClient : GoogleSignInClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_comeback.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_signInFragment_to_mainFragment))
        button_sign_in.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_signInFragment_to_mainFragment))
    }

    /*  ///////////////////////////////////////////////////////////////////////////////////
        FIREBASE SIGNIN DOC: https://firebase.google.com/docs/auth/android/google-signin
     ////////////////////////////////////////////////////////////////////////////////////// */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configure Google Sign In
        /*
        R.string.default_web_client_id is the server's clients id
         */
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        // DEBE SER UNA ACTIVITY
        //googleSignInClient = GoogleSignIn.getClient(this, gso)

        //Initialize Firebase
        auth = FirebaseAuth.getInstance();
    }

    override fun onStart() {
        super.onStart()

        //Check if the user has already signed in
        val currentUser = auth.currentUser
        //updateUI(currentUser);
        /* if(currentuser != null){
                // dont show sign in button
           } else {
                //show sign in button
           }
         */
    }

    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RETURN_CODE_SIGN_IN)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RETURN_CODE_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                //Log.w(TAG, "Google sign in failed", e)
                // ...
            }
        }
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        //Log.d(TAG, "firebaseAuthWithGoogle:" + acct.id!!)

        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        auth.signInWithCredential(credential)
                // SIGN IN DEBE SER UNA ACTIVITY, NO UN FRAGMENT
                /*
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        //Log.d(TAG, "signInWithCredential:success")
                        val user = auth.currentUser
                        //updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        //Log.w(TAG, "signInWithCredential:failure", task.exception)
                        //Snackbar.make(main_layout, "Authentication Failed.", Snackbar.LENGTH_SHORT).show()
                        //updateUI(null)
                    }

                    // ...
                }
                */
    }

}
