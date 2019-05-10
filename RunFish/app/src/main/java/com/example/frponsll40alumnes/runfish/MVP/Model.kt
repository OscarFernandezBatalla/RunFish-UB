package com.example.frponsll40alumnes.runfish.MVP

import com.example.frponsll40alumnes.runfish.FishType
import com.example.frponsll40alumnes.runfish.abilities.Ability
import com.example.frponsll40alumnes.runfish.abilities.Shield

class Model (var presenter: Presenter) {


    private var registrat : Boolean = false
    private var friends : List<String>? = null
    private var currentFish : Enum<FishType>? = null
    private var ownedFish : List<Enum<FishType>>? = null

    /*stats*/
    private var statTotalFish : Int = 1                    // Un cop s'hagi creat serà algo tipo = ownedFish!!.size, si es fa abans de sobreescriure el null de la ownedFish peta!!!
    private var statPlanktonCollected : Int = 0
    private var statNumberOfDeath : Int = 5                 //canviar, era exemple de fun
    private var statMurderedFish : Int = 0
    private var statMaxDistanceTraveled : Int = 0

    //private var levelsUnlocked : Int = 1      futura implementació


    private var music : Int = 50        //percentatge
    private var sound : Int = 50        //percentatge
    private var vibration : Boolean = true
    private var languageCat : Boolean = true
    private var lifeBar : Int = 100     //percentatge
    private var capacityBar : Int = 0   //percentatge
    private var abilityUsed : Boolean = false
    private var levelSelected : Int? = null
    private var planktonCollected : Int = 0


    /*FISH*/

    /*Common fish*/
    var commonFishLife : Int = 20
    var commonFishCapacity : Int = 20
    var commonFishSpeed : Int = 20
    var commonFishPrice : Int = 20
    var commonFishAbility : Enum<Ability> = Ability.SHIELD
    var commonFishOwned : Boolean = true

    /*Clownfish*/
    var clownFishLife : Int = 30
    var clownFishCapacity : Int = 30
    var clownFishSpeed : Int = 30
    var clownFishPrice : Int = 30
    var clownFishAbility : Enum<Ability> = Ability.HEALTH
    var clownFishOwned : Boolean = false

    /*Blow fish*/
    var blowFishLife : Int = 40
    var blowFishCapacity : Int = 40
    var blowFishSpeed : Int = 40
    var blowFishPrice : Int = 40
    var blowFishAbility : Enum<Ability> = Ability.STRENGTH
    var blowFishOwned : Boolean = false

    /*Sword fish*/
    var swordFishLife : Int = 50
    var swordFishCapacity : Int = 50
    var swordFishSpeed : Int = 50
    var swordFishPrice : Int = 50
    var swordFishAbility : Enum<Ability> = Ability.CAMOUFLAGE
    var swordFishOwned : Boolean = false

    /*Shark*/
    var sharkLife : Int = 60
    var sharkCapacity : Int = 60
    var sharkSpeed : Int = 60
    var sharkPrice : Int = 60
    var sharkAbility : Enum<Ability> = Ability.BITE
    var sharkOwned : Boolean = false













    /*PAS 4 EXEMPLE A*/
    /*EXEMPLE AUGMENTAR statNumberOfDeath AGAFANT EL VALOR DEL FRAGMENT GAME*/

    /*fun IncreaseStatNumberOfDeath(vegadesMort: Int) {
        statNumberOfDeath += vegadesMort

    }*/

    fun uploadStats():  MutableList<Int> {
        return mutableListOf(
            statTotalFish,
            statPlanktonCollected,
            statNumberOfDeath,
            statMurderedFish,
            statMaxDistanceTraveled
        )
    }

    fun uploadMusicBar(): Int {
        return music
    }

    fun uploadSoundBar(): Int {
        return sound
    }

    fun uploadVibrationSwitch(): Boolean {
        return vibration
    }


}