package com.example.frponsll40alumnes.runfish.activityFragments

import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import com.example.frponsll40alumnes.runfish.MVP.Presenter
import com.example.frponsll40alumnes.runfish.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_home.*



class HomeActivity : AppCompatActivity() {

    private lateinit var song : MediaPlayer
    private lateinit var audioManager : AudioManager

    private var currentVolume : Int = 0
    private var maxVolume : Int = 0

    var presenter : Presenter = Presenter(this)
    lateinit var signOut : Button
    var userChecked: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        hideNav()


        song = MediaPlayer.create(this, R.raw.baby_shark)
        audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager

        song.isLooping = true
        maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)

        setContentView(R.layout.activity_home)
        signOut = findViewById(R.id.sign_out_button)
        signOut.visibility = View.GONE
        setupUI()

        presenter.setConnected(true)

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus){
            hideNav()
        }
    }

    fun hideNav(){
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
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

    fun setMeters(meters : Int){
        var text : TextView = findViewById(R.id.textView_metersMap)
        text.text = meters.toString()
    }

    fun getMaxVolume() : Int{
        return this.maxVolume
    }

    fun getCurrentVolume() : Int{
        return this.currentVolume
    }

    fun setVolume(progress : Int) {
        this.audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0)
    }
}
