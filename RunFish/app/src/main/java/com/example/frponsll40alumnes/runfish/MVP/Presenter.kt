package com.example.frponsll40alumnes.runfish.MVP

import android.widget.TextView
import com.example.frponsll40alumnes.runfish.FishType
import com.example.frponsll40alumnes.runfish.activityFragments.MainActivity
import com.example.frponsll40alumnes.runfish.GameEngine
import com.example.frponsll40alumnes.runfish.R
import com.example.frponsll40alumnes.runfish.abilities.Ability
import com.example.frponsll40alumnes.runfish.activityFragments.HomeActivity
import com.example.frponsll40alumnes.runfish.activityFragments.statsFragment
//import kotlinx.android.synthetic.main.fragment_main.view.*


class Presenter(var viewActivity: HomeActivity) : Contract.Presenter{


    //var viewActivity: MainActivity = MainActivity()
    var model: Model = Model(this)
    var gameEngine: GameEngine? = null          //o tambe es pot crear aqui es igual
    //gameEngine.startGame()

    override fun uploadStats(): MutableList<Int> {
        return model.uploadStats()
    }

    override fun uploadMusicBar(): Int {
        return model.uploadMusicBar()
    }

    override fun uploadSoundBar(): Int {
        return model.uploadSoundBar()
    }

    override fun uploadVibrationSwitch(): Boolean {
        return model.uploadVibrationSwitch()
    }

    /*
        Functions to update CommonFish Shop & Fish Fragments
     */
    override fun uploadBarsCommonFish(): MutableList<Int> {
        return model.uploadBarsCommonFish()
    }

    override fun uploadPriceCommonFish(): Int {
        return model.uploadPriceCommonFish()
    }

    override fun uploadAbilityCommonFish(): Ability {
        return model.uploadAbilityCommonFish()
    }

    override fun uploadBarsClownFish(): MutableList<Int> {
        return model.uploadBarsClownFish()
    }

    override fun uploadAbilityClownFish(): Ability {
        return model.uploadAbilityClownFish()
    }

    override fun uploadPriceClownFish(): Int {
        return model.uploadPriceClownFish()
    }

    override fun uploadBarsBlowFish(): MutableList<Int> {
        return model.uploadBarsBlowFish()
    }
    override fun uploadAbilityBlowFish(): Ability {
        return model.uploadAbilityBlowFish()
    }

    override fun uploadBarsSwordFish(): MutableList<Int> {
        return model.uploadBarsSwordFish()
    }
    override fun uploadAbilitySwordFish(): Ability {
        return model.uploadAbilitySwordFish()
    }

    override fun uploadBarsShark(): MutableList<Int> {
        return model.uploadBarsShark()
    }
    override fun uploadAbilityShark(): Ability {
        return model.uploadAbilityShark()
    }

    override fun uploadFishOwned() : MutableList<Boolean> {
        return model.uploadFishOwned()
    }

    override fun uploadPriceBlowFish(): Int {
        return model.uploadPriceBlowFish()
    }

    override fun uploadPriceSwordFish(): Int {
        return model.uploadPriceSwordFish()
    }

    override fun uploadPriceShark(): Int {
        return model.uploadPriceShark()
    }

    override fun uploadUsers(): Int {
        return model.uploadUsers()
    }

    override fun uploadPlayerPlankton(): Int{
        return model.uploadPlayerPlankton()
    }

    fun buyFish(fishType: FishType) {
        return model.buyFish(fishType)
    }

    fun uploadLevels() : Int{
        return model.uploadLevels()
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