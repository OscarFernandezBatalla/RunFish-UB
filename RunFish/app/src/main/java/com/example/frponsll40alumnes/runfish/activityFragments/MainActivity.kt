package com.example.frponsll40alumnes.runfish.activityFragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.databinding.DataBindingUtil
import android.view.Window
import android.view.WindowManager
import com.example.frponsll40alumnes.runfish.R
import com.example.frponsll40alumnes.runfish.databinding.ActivityMainBinding

var ReturnDirection : LevelDirection =
    LevelDirection.SINGLEPLAYER

enum class LevelDirection {
    SINGLEPLAYER, MULTIPLAYER
}

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        //Amaga la barra de notificacions.
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)






    }


}
