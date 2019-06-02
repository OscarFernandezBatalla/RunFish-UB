package com.example.frponsll40alumnes.runfish.MVP

import android.content.Context
import com.example.frponsll40alumnes.runfish.*
import com.example.frponsll40alumnes.runfish.abilities.Ability
import com.example.frponsll40alumnes.runfish.fish.Fish
import com.example.frponsll40alumnes.runfish.npc.NPC

interface Contract {

    interface Presenter {
        fun uploadStats(): MutableList<Int>
        fun uploadMusicBar(): Int
        fun uploadSoundSwitch(): Boolean
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
        fun uploadFriends(): Int
        fun uploadPlayerPlankton(): Int
        fun buyFish(fishType: FishType) : String
        fun uploadLevels() : Int
        fun addFriend(friendName: String)
        fun startGame(player1: Player, player2: Player? = null, context: Context)
        fun updateJoystickInf(valx: Double, valy: Double, strength: Int)
        fun updateView()
        fun getNPC(): MutableList<NPC?>?
        fun getFish(): Fish?
        fun useAbility() : Int
        fun lifeBar(): Int
        fun capacityBar(): Int
        fun increaseDeath()
        fun getPlanktonCollected(): Int
        fun setVibrationState(activated: Boolean)
        fun getNPCsInArea(x_start : Int, x_end : Int, y_start : Int, y_end : Int) : MutableList<NPC?>
        fun startMusic()
        fun stopMusic()
        fun getFriendsList(): MutableList<String>
        fun getConnected(): Boolean
        fun setConnected(connected: Boolean)
        fun getUsername(): String
        fun setUsername(username: String)
        fun getCurrentFish() : FishType
        fun setCurrentFish(fish: FishType)
        fun setStatsToCloud()
        fun getAllFromCloud()
        fun getMeters() : Int
        fun setMeters(meters : Int)
        fun getLevel() : Level
        fun setActualLevel(numLevel: Int)
        fun getActualLevel(): Int
        fun unlockNextLevel()
        fun freeModeON()
        fun getLevelContext(): MutableList<Int>
        fun getFreeMode(): Boolean
        fun setMusic(progress: Int)
        fun getFreeModePlankton() : Int
        fun getBonus(): Boolean
        fun setSounds(checked: Boolean)
        fun getMetersLevel(): Int
        fun addPlankton()
    }

    interface Model {
        fun uploadStats():  MutableList<Int>
        fun uploadMusicBar(): Int
        fun uploadSoundSwitch(): Boolean
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
        fun uploadFriends(): Int
        fun uploadPlayerPlankton(): Int
        fun buyFish(fishType: FishType) : String
        fun uploadLevels() : Int
        fun setStatsToCloud()
        fun setPlanctonToCloud()
        fun setLevelsToCloud()
        fun setFishToCloud()
        fun getStatsFromCloud()
        fun setOptionsToCloud()
        fun getOptionsFromCloud()
        fun getPlanctonFromCloud()
        fun getLevelsFromCloud()
        fun getFishFromCloud()
        fun addFriend(friendName: String)
        fun getFriendsFromCloud()
        fun setFriendsToCloud()
        fun setVibrationState(activated: Boolean)
        fun getFriendsList(): MutableList<String>
        fun getConnected(): Boolean
        fun setConnected(connected: Boolean)
        fun getUsername(): String
        fun setUsername(username: String)
        fun getCurrentFish() : FishType
        fun setCurrentFish(fish: FishType)
        fun setUsernameToCloud()
        fun getUsernameFromCloud()
        fun getAllUsernameListFromCloud()
        fun setAllUsernameListToCloud()
        fun searchUserIdInUserIdList(name: String): Boolean
        fun increaseDeath()
        fun setLevelSelected(numLevel : Int)
        fun getLevelSelected() : Int
        fun unlockNextLevel(actualLevel: Int)
        fun freeModeON()
        fun getFreeMode() : Boolean
        fun getLevelContext(): MutableList<Int>
        fun setMusic(progress : Int)
        fun getUsernameListFromCloud(name: String): Boolean
        fun getSounds(): Boolean
        fun setSounds(checked: Boolean)
        fun getMetersLevel(): Int
        fun addPlankton(planktonCollected: Int)
        fun setMetersTraveled(metersLevel: Int)
    }

}