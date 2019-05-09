package com.example.frponsll40alumnes.runfish

import android.widget.TextView
import com.example.frponsll40alumnes.runfish.activityFragments.MainActivity
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_main.*
import android.R
import android.support.v4.app.FragmentManager


class Presenter(var viewActivity: MainActivity){

    //var viewActivity: MainActivity = MainActivity()
    var model: Repository? = null
    var gameEngine: GameEngine? = null          //o tambe es pot crear aqui es igual
    //gameEngine.startGame()


    fun h(){

        viewActivity.textFish = "patata"

    }


    init {
        model = Repository()
        h()
    }







/*
    override fun updateHp(){
        viewActivity.life_bar.progress = 10
    }

    override fun engageGame(){
        gameEngine = GameEngine(Player(FishType.ANEMONE),context = viewActivity)
    }
*/

}