package com.example.frponsll40alumnes.runfish.MVP

import com.example.frponsll40alumnes.runfish.abilities.Ability

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