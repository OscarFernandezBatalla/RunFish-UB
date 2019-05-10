package com.example.frponsll40alumnes.runfish.MVP

import com.example.frponsll40alumnes.runfish.FishType

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


    private var music : Int = 50        //percentatge
    private var sound : Int = 50        //percentatge
    private var vibration : Boolean = true
    private var languageCat : Boolean = true
    private var lifeBar : Int = 100     //percentatge
    private var capacityBar : Int = 0   //percentatge
    private var abilityUsed : Boolean = false
    private var levelSelected : Int? = null
    private var planktonCollected : Int = 0


    //private var levelsUnlocked : Int = 1      futura implementació









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


}