package com.example.frponsll40alumnes.runfish.activityFragments

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.frponsll40alumnes.runfish.MVP.Presenter
import com.example.frponsll40alumnes.runfish.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    lateinit var song : MediaPlayer
    var presenter : Presenter = Presenter(this)
    lateinit var signOut : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        song = MediaPlayer.create(this, R.raw.run_boy_run)
        setContentView(R.layout.activity_home)
        signOut = findViewById(R.id.sign_out_button)
        signOut.visibility = View.GONE
        setupUI()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
    }

    private fun setupUI() {
        sign_out_button.setOnClickListener {
            signOut()
        }
    }

    private fun signOut() {
        startActivity(MainActivity.getLaunchIntent(this))
        FirebaseAuth.getInstance().signOut()
    }

    fun getMusic() : MediaPlayer{
        return song
    }


    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, HomeActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }
}
