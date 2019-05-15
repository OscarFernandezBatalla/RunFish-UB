package com.example.frponsll40alumnes.runfish.MVP

import android.content.Context
import com.example.frponsll40alumnes.runfish.FishType
import com.example.frponsll40alumnes.runfish.GameEngine
import com.example.frponsll40alumnes.runfish.Map
import com.example.frponsll40alumnes.runfish.Player
import com.example.frponsll40alumnes.runfish.abilities.Ability
import com.example.frponsll40alumnes.runfish.fish.Fish
import com.example.frponsll40alumnes.runfish.npc.NPC

interface Contract {

    interface View {

        //aqui tots els metodes que ha de fer la view

        //fun initView()
        /*fun updateShopFragment()
        fun updateFishFragment()
        fun updateFriendsFragment()
        fun updateLevelsFragment()
        fun updateMultiplayerFragment()
        fun updateOptionsFragment()
        fun updateStatsFragment()*/

    }

    interface Presenter {
        fun uploadStats(): MutableList<Int>
        fun uploadMusicBar(): Int
        fun uploadSoundBar(): Int
        fun uploadVibrationSwitch(): Boolean
        fun uploadBarsCommonFish(): MutableList<Int>
        fun uploadPriceCommonFish(): Int
        fun uploadAbilityCommonFish(): Ability
        fun uploadBarsClownFish(): MutableList<Int>
        fun uploadAbilityClownFish(): Ability
        fun uploadPriceClownFish(): Int
        fun uploadBarsBlowFish(): MutableList<Int>
        fun uploadAbilityBlowFish(): Ability
        fun uploadBarsSwordFish(): MutableList<Int>
        fun uploadAbilitySwordFish(): Ability
        fun uploadBarsShark(): MutableList<Int>
        fun uploadAbilityShark(): Ability
        fun uploadFishOwned() : MutableList<Boolean>
        fun uploadPriceBlowFish(): Int
        fun uploadPriceSwordFish(): Int
        fun uploadPriceShark(): Int
        fun uploadUsers(): Int
        fun uploadPlayerPlankton(): Int
        fun buyFish(fishType: FishType)
        fun uploadLevels() : Int
        fun addFriend(friendName: String)
        fun startGame(player1: Player, player2: Player? = null, context: Context)
        fun updateJoystickInf(valx: Double, valy: Double, strength: Int)
        fun updateView()
        fun getNPC(): MutableList<NPC?>?
        fun getMap(): Map?
        fun getFish(): Fish?
        fun getBackground(): Map
        fun useAbility()
        fun lifeBar(): Int
        fun capacityBar(): Int
        fun increaseDeath()
        fun getPlanktonCollected(): Int
        fun setVibrationState(activated: Boolean)
        fun getNPCsInArea(x_start : Int, x_end : Int, y_start : Int, y_end : Int) : MutableList<NPC?>
        fun startMusic()
        fun stopMusic()
    }

    interface Model {
        fun uploadStats():  MutableList<Int>
        fun uploadMusicBar(): Int
        fun uploadSoundBar(): Int
        fun uploadVibrationSwitch(): Boolean
        fun uploadBarsCommonFish(): MutableList<Int>
        fun uploadBarsClownFish(): MutableList<Int>
        fun uploadBarsBlowFish(): MutableList<Int>
        fun uploadBarsSwordFish(): MutableList<Int>
        fun uploadBarsShark(): MutableList<Int>
        fun uploadPriceCommonFish(): Int
        fun uploadAbilityCommonFish(): Ability
        fun uploadFishOwned() : MutableList<Boolean>
        fun uploadAbilityClownFish(): Ability
        fun uploadAbilityBlowFish(): Ability
        fun uploadAbilitySwordFish(): Ability
        fun uploadAbilityShark(): Ability
        fun uploadPriceClownFish(): Int
        fun uploadPriceBlowFish(): Int
        fun uploadPriceSwordFish(): Int
        fun uploadPriceShark(): Int
        fun uploadUsers(): Int
        fun uploadPlayerPlankton(): Int
    }

}