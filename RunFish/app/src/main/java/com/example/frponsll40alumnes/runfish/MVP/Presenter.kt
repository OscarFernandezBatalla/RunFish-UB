package com.example.frponsll40alumnes.runfish.MVP

import android.widget.TextView
import com.example.frponsll40alumnes.runfish.activityFragments.MainActivity
import com.example.frponsll40alumnes.runfish.GameEngine
import com.example.frponsll40alumnes.runfish.R
import com.example.frponsll40alumnes.runfish.abilities.Ability
import com.example.frponsll40alumnes.runfish.activityFragments.statsFragment
import kotlinx.android.synthetic.main.fragment_main.view.*


class Presenter(var viewActivity: MainActivity){


    //var viewActivity: MainActivity = MainActivity()
    var model: Model = Model(this)
    var gameEngine: GameEngine? = null          //o tambe es pot crear aqui es igual
    //gameEngine.startGame()

/*

    fun getBar(){

        viewActivity.getBar()

    }
*/



    /*PAS 3 EXEMPLE A*/
    /*EXEMPLE AUGMENTAR statNumberOfDeath AGAFANT EL VALOR DEL FRAGMENT GAME*/
    /*fun increaseStatNumberOfDeath(vegadesMort: Int) {
        model!!.IncreaseStatNumberOfDeath(vegadesMort)
    }*/


    /*PAS 2 EXEMPLE B*/
    /*EXEMPLE CARREGAR statNumberOfDeath AL FRAGMENT STATS*/


    fun uploadStats(): MutableList<Int> {
        return model.uploadStats()
    }

    fun uploadMusicBar(): Int {
        return model.uploadMusicBar()
    }

    fun uploadSoundBar(): Int {
        return model.uploadSoundBar()
    }

    fun uploadVibrationSwitch(): Boolean {
        return model.uploadVibrationSwitch()
    }


    /*
        Functions to update CommonFish Shop & Fish Fragments
     */
    fun uploadBarsCommonFish(): MutableList<Int> {
        return model.uploadBarsCommonFish()
    }

    fun uploadPriceCommonFish(): Int {
        return model.uploadPriceCommonFish()
    }

    fun uploadAbilityFish(): Enum<Ability> {
        return model.uploadAbilityFish()
    }


    fun uploadBarsClownFish(): MutableList<Int> {
        return model.uploadBarsClownFish()
    }

    fun uploadBarsBlowFish(): MutableList<Int> {
        return model.uploadBarsBlowFish()
    }

    fun uploadBarsSwordFish(): MutableList<Int> {
        return model.uploadBarsSwordFish()
    }

    fun uploadBarsShark(): MutableList<Int> {
        return model.uploadBarsShark()
    }


    fun uploadFishOwned() : MutableList<Boolean> {
        return model.uploadFishOwned()
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