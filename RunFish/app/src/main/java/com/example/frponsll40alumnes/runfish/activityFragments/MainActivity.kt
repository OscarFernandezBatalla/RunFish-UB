package com.example.frponsll40alumnes.runfish.activityFragments

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.databinding.DataBindingUtil
import android.view.Window
import android.view.WindowManager
//import com.example.frponsll40alumnes.runfish.R
import com.example.frponsll40alumnes.runfish.databinding.ActivityMainBinding
import java.nio.file.Files.size
import android.R.attr.y
import android.R.attr.x
import com.example.frponsll40alumnes.runfish.GameView
//import android.R



var ReturnDirection : LevelDirection =
    LevelDirection.SINGLEPLAYER

enum class LevelDirection {
    SINGLEPLAYER, MULTIPLAYER
}

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var gameView : GameView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Amaga la barra de notificacions.
        //requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)


        //setContentView(R.layout.activity_main)

        gameView = GameView(this)
        setContentView(gameView)


        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)






    }


}
