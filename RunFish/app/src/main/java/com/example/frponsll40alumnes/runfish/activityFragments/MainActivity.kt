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
import com.example.frponsll40alumnes.runfish.Contract
import com.example.frponsll40alumnes.runfish.GameView
import com.example.frponsll40alumnes.runfish.Presenter
import com.example.frponsll40alumnes.runfish.R

//import android.R



var ReturnDirection : LevelDirection =
    LevelDirection.SINGLEPLAYER

enum class LevelDirection {
    SINGLEPLAYER, MULTIPLAYER
}

class MainActivity : AppCompatActivity() {


    /*TOTES les variables de tots els frag: Biblia*/
    var textFish : String = "Select a fish"



    //aixo despres de les declaracions
    var presenter : Presenter = Presenter(this)





    lateinit var binding: ActivityMainBinding
    //lateinit var gameView : GameView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Amaga la barra de notificacions.
        //requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)



        /*
        gameView = GameView(this)
        setContentView(gameView)
*/

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)






    }


}
