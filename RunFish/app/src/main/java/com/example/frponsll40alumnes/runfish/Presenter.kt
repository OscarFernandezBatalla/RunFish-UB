package com.example.frponsll40alumnes.runfish

import com.example.frponsll40alumnes.runfish.activityFragments.MainActivity
import kotlinx.android.synthetic.main.fragment_game.*

class Presenter(){

    var viewActivity: MainActivity = MainActivity()
    var model: Repository = Repository()

    var gameEngine: GameEngine? = null
    //gameEngine.startGame()

    fun updateHp(){
        viewActivity.life_bar.progress = 10
    }

    fun engageGame(){
        gameEngine = GameEngine(Player(FishType.ANEMONE),context = viewActivity)
    }


}