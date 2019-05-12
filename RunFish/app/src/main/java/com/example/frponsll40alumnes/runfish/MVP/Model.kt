package com.example.frponsll40alumnes.runfish.MVP

import android.content.ContentValues.TAG
import android.util.Log
import com.example.frponsll40alumnes.runfish.FishType
import com.example.frponsll40alumnes.runfish.abilities.Ability
import com.example.frponsll40alumnes.runfish.abilities.Shield
import com.example.frponsll40alumnes.runfish.fish.BlowFish
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.DocumentReference



class Model (var presenter: Presenter) : Contract.Model {


    var db: FirebaseFirestore= FirebaseFirestore.getInstance()

    var user = FirebaseAuth.getInstance().currentUser!!.uid


    private var friends : List<String> = mutableListOf()


    /*stats*/

    private var statTotalFish : Int = 0
    private var statPlanktonCollected : Int = 0
    private var statNumberOfDeath : Int = 0               //canviar, era exemple de fun
    private var statMurderedFish : Int = 0
    private var statMaxDistanceTraveled : Int = 0


    var statsMap : HashMap<String, Int> = hashMapOf(
        "statTotalFish" to statTotalFish,
        "statPlanktonCollected" to statPlanktonCollected,
        "statNumberOfDeath" to statNumberOfDeath,
        "statMurderedFish" to statMurderedFish,
        "statMaxDistanceTraveled" to statMaxDistanceTraveled)


    var friendsMap: HashMap<String, List<String>> = hashMapOf(
        "friends" to friends
    )


    private var levelsUnlocked : Int = 1
    var levelsMap: HashMap<String, Int> = hashMapOf(
        "levelsUnlocked" to levelsUnlocked
    )

    private var music : Int = 50        //percentatge
    private var sound : Int = 50        //percentatge
    private var vibration : Boolean = true
    private var languageCat : Boolean = true

    var optionsMap: HashMap<String, Any> = hashMapOf(
        "music" to music,
        "sound" to sound,
        "vibration" to vibration,
        "languageCat" to languageCat)


    private var lifeBar : Int = 100     //percentatge
    private var capacityBar : Int = 0   //percentatge
    private var abilityUsed : Boolean = false
    private var levelSelected : Int? = null
    private var planktonCollected : Int = 0

    private var actualPlankton: Int = 20000

    var planctonMap: HashMap<String, Int> = hashMapOf(
        "actualPlankton" to actualPlankton
    )

    /*FISH*/

    /*Common fish*/
    var commonFishLife : Int = 20
    var commonFishCapacity : Int = 20
    var commonFishSpeed : Int = 20
    var commonFishPrice : Int = 20
    var commonFishAbility : Ability = Ability.SHIELD
    var commonFishOwned : Boolean = true


    /*Clownfish*/
    var clownFishLife : Int = 30
    var clownFishCapacity : Int = 30
    var clownFishSpeed : Int = 30
    var clownFishPrice : Int = 30
    var clownFishAbility : Ability = Ability.HEALTH
    var clownFishOwned : Boolean = true


    /*Blow fish*/
    var blowFishLife : Int = 40
    var blowFishCapacity : Int = 40
    var blowFishSpeed : Int = 40
    var blowFishPrice : Int = 40
    var blowFishAbility : Ability = Ability.STRENGTH
    var blowFishOwned : Boolean = false

    /*Sword fish*/
    var swordFishLife : Int = 50
    var swordFishCapacity : Int = 50
    var swordFishSpeed : Int = 50
    var swordFishPrice : Int = 50
    var swordFishAbility : Ability = Ability.CAMOUFLAGE
    var swordFishOwned : Boolean = true

    /*Shark*/
    var sharkLife : Int = 60
    var sharkCapacity : Int = 60
    var sharkSpeed : Int = 60
    var sharkPrice : Int = 60
    var sharkAbility : Ability = Ability.BITE
    var sharkOwned : Boolean = false

    var fishMap: HashMap<String, Boolean> = hashMapOf(
    "commonFishOwned" to commonFishOwned,
    "clownFishOwned" to clownFishOwned,
    "blowFishOwned" to blowFishOwned,
    "swordFishOwned" to swordFishOwned,
    "sharkOwned" to sharkOwned
    )


    init{
        //checkUserFromCloud()
        setStatsToCloud()
        setOptionsToCloud()
        setPlanctonToCloud()
        setLevelsToCloud()
        setFishToCloud()
        //setFriendsToCloud()

        getStatsFromCloud()
        getOptionsFromCloud()
        getPlanctonFromCloud()
        getLevelsFromCloud()
        getFishFromCloud()
        //getFriendsFromCloud()
    }


    override fun uploadStats():  MutableList<Int> {
        return mutableListOf(
            statTotalFish,
            statPlanktonCollected,
            statNumberOfDeath,
            statMurderedFish,
            statMaxDistanceTraveled
        )
    }

    override fun uploadMusicBar(): Int {
        return music
    }

    override fun uploadSoundBar(): Int {
        return sound
    }

    override fun uploadVibrationSwitch(): Boolean {
        return vibration
    }


    override fun uploadBarsCommonFish(): MutableList<Int> {
        return mutableListOf(
            commonFishLife,
            commonFishCapacity,
            commonFishSpeed
        )
    }
    override fun uploadBarsClownFish(): MutableList<Int> {
        return mutableListOf(
            clownFishLife,
            clownFishCapacity,
            clownFishSpeed
        )
    }
    override fun uploadBarsBlowFish(): MutableList<Int> {
        return mutableListOf(
            blowFishLife,
            blowFishCapacity,
            blowFishSpeed
        )
    }
    override fun uploadBarsSwordFish(): MutableList<Int> {
        return mutableListOf(
            swordFishLife,
            swordFishCapacity,
            swordFishSpeed
        )
    }
    override fun uploadBarsShark(): MutableList<Int> {
        return mutableListOf(
            sharkLife,
            sharkCapacity,
            sharkSpeed
        )
    }

    override fun uploadPriceCommonFish(): Int {
        return commonFishPrice
    }

    override fun uploadAbilityCommonFish(): Ability {
        return commonFishAbility
    }

    override fun uploadFishOwned() : MutableList<Boolean>{
        return mutableListOf(
            commonFishOwned,
            clownFishOwned,
            blowFishOwned,
            swordFishOwned,
            sharkOwned
        )
    }

    override fun uploadAbilityClownFish(): Ability {
        return clownFishAbility
    }

    override fun uploadAbilityBlowFish(): Ability {
        return blowFishAbility
    }

    override fun uploadAbilitySwordFish(): Ability {
        return swordFishAbility
    }

    override fun uploadAbilityShark(): Ability {
        return sharkAbility
    }

    override fun uploadPriceClownFish(): Int {
        return clownFishPrice
    }

    override fun uploadPriceBlowFish(): Int {
        return blowFishPrice
    }

    override fun uploadPriceSwordFish(): Int {
        return swordFishPrice
    }

    override fun uploadPriceShark(): Int {
        return sharkPrice
    }
    override fun uploadUsers(): Int {
        return friends.size

    }

    override fun uploadPlayerPlankton(): Int{
        return actualPlankton
    }


    fun buyFish(fishType: FishType) {
        when(fishType){
            FishType.ANEMONE -> if(!clownFishOwned && buyFishSupport(clownFishPrice)){
                clownFishOwned = true
                this.setPlanctonToCloud()
            }
            FishType.BLOWFISH -> if(!blowFishOwned && buyFishSupport(blowFishPrice)){
                blowFishOwned = true
                this.setPlanctonToCloud()
            }
            FishType.SWORDFISH -> if(!swordFishOwned && buyFishSupport(swordFishPrice)){
                swordFishOwned = true
                this.setPlanctonToCloud()
            }
            FishType.SHARK -> if(!sharkOwned && buyFishSupport(sharkPrice)){
                sharkOwned = true
                this.setPlanctonToCloud()
            }
        }
    }

    private fun buyFishSupport(price: Int): Boolean {
        if(actualPlankton > price){
            actualPlankton -= price
            return true
        }
        return false
    }

    fun uploadLevels() : Int{
        return levelsUnlocked
    }


    /*fun checkUserFromCloud(){
        var usari = db.collection("usuarios").document("$user")
        //if(usari == null){
        usari.collection("userContext").document("stats").set(statsMap)
        usari.collection("userContext").document("options").set(optionsMap)
        usari.collection("userContext").document("plancton").set(planctonMap)
        usari.collection("userContext").document("levels").set(levelsMap)
        usari.collection("userContext").document("levels").set(fishMap)
        //usari.collection("userContext").document("friends").set(friendsMap)
        //}
    }*/


    fun setStatsToCloud(){
        db.collection("usuarios").document("$user").collection("userContext").document("stats").set(statsMap)
    }

    fun setPlanctonToCloud(){
        planctonMap["actualPlankton"] = actualPlankton
        db.collection("usuarios").document("$user").collection("userContext").document("plancton").set(planctonMap)
    }
    fun setLevelsToCloud(){
        db.collection("usuarios").document("$user").collection("userContext").document("levels").set(levelsMap)
    }
    fun setFishToCloud(){
        db.collection("usuarios").document("$user").collection("userContext").document("fish").set(fishMap)
    }

    fun getStatsFromCloud(){
        db.collection("usuarios").document("$user").collection("userContext").document("stats").get().addOnSuccessListener { document ->
            if (document != null) {
                statTotalFish = document.data!!.get("statTotalFish").toString().toInt()
                statPlanktonCollected = document.data!!.get("statPlanktonCollected").toString().toInt()
                statNumberOfDeath = document.data!!.get("statNumberOfDeath").toString().toInt()
                statMurderedFish = document.data!!.get("statMurderedFish").toString().toInt()
                statMaxDistanceTraveled = document.data!!.get("statMaxDistanceTraveled").toString().toInt()
            } else {
                Log.d(TAG, "No such document")
            }
        }.addOnFailureListener { exception ->
            Log.d(TAG, "get failed with ", exception)
        }
    }

    fun setOptionsToCloud(){
        db.collection("usuarios").document("$user").collection("userContext").document("options").set(optionsMap)
    }

    fun getOptionsFromCloud(){
        db.collection("usuarios").document("$user").collection("userContext").document("options").get().addOnSuccessListener { document ->
            if (document != null) {
                music = document.data!!.get("music").toString().toInt()
                sound = document.data!!.get("sound").toString().toInt()
                vibration = document.data!!.get("vibration").toString().toBoolean()
                languageCat = document.data!!.get("languageCat").toString().toBoolean()
            } else {
                Log.d(TAG, "No such document")

            }
        }.addOnFailureListener { exception ->
            Log.d(TAG, "get failed with ", exception)
        }
    }

    fun getPlanctonFromCloud() {
        db.collection("usuarios").document("$user").collection("userContext").document("plancton").get()
            .addOnSuccessListener { document ->
                if (document != null) {
                     actualPlankton = document.data!!.get("actualPlankton").toString().toInt()
                } else {
                    Log.d(TAG, "No such document")

                }
            }.addOnFailureListener { exception ->
            Log.d(TAG, "get failed with ", exception)
        }
    }

    fun getLevelsFromCloud() {
        db.collection("usuarios").document("$user").collection("userContext").document("levels").get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    levelsUnlocked = document.data!!.get("levelsUnlocked").toString().toInt()
                } else {
                    Log.d(TAG, "No such document")

                }
            }.addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
    }

    fun getFishFromCloud() {
        db.collection("usuarios").document("$user").collection("userContext").document("fish").get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    commonFishOwned = document.data!!.get("commonFishOwned").toString().toBoolean()
                    clownFishOwned = document.data!!.get("clownFishOwned").toString().toBoolean()
                    blowFishOwned = document.data!!.get("blowFishOwned").toString().toBoolean()
                    swordFishOwned = document.data!!.get("swordFishOwned").toString().toBoolean()
                    sharkOwned = document.data!!.get("sharkOwned").toString().toBoolean()

                } else {
                    Log.d(TAG, "No such document")

                }
            }.addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
    }

    fun addFriend(friendName: String) {
        //if (db.collection("usuarios").document("$friendName") != null){
        friends += "friendName"
        setFriendsToCloud()
        //}
    }



    fun getFriendsFromCloud() {
        db.collection("usuarios").document("$user").collection("userContext").document("friends").get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    friends = document.data!!.get("friendList").toString().split("")
                } else {
                    Log.d(TAG, "No such document")
                }
            }.addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
    }

    fun setFriendsToCloud(){
        this.actualitzaFriendsMap()
        db.collection("usuarios").document("$user").collection("userContext").document("friends").set(friendsMap)
    }

    fun actualitzaFriendsMap(){
        friendsMap["friends"] = friends
    }



}