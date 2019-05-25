package com.example.frponsll40alumnes.runfish.MVP

import android.content.ContentValues.TAG
import android.util.Log
import com.example.frponsll40alumnes.runfish.FishType
import com.example.frponsll40alumnes.runfish.abilities.Ability
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class Model (var presenter: Presenter) : Contract.Model {



    var db: FirebaseFirestore= FirebaseFirestore.getInstance()

    var user = FirebaseAuth.getInstance().currentUser!!.uid


    private var friends: MutableList<String> = mutableListOf()

    private var usernameList: MutableList<String> = mutableListOf()

    private var userIdList: MutableList<String> = mutableListOf()

    private var currentFish : String? = null

    //private var friend1 : List<Any?> = mutableListOf()

    /*stats*/

    private var statTotalFish : Int = 0
    private var statPlanktonCollected : Int = 0
    private var statNumberOfDeath : Int = 0               //canviar, era exemple de fun
    private var statMurderedFish : Int = 0
    private var statMaxDistanceTraveled : Int = 0

    //boolean if user is connected

    //For friends logic
    private var username: String = ""
    private var connected: Boolean = false


    var statsMap : HashMap<String, Int> = hashMapOf(
        "statTotalFish" to statTotalFish,
        "statPlanktonCollected" to statPlanktonCollected,
        "statNumberOfDeath" to statNumberOfDeath,
        "statMurderedFish" to statMurderedFish,
        "statMaxDistanceTraveled" to statMaxDistanceTraveled)


    var usernameUserIdMap : HashMap<String, String> = hashMapOf() //TODO: Posar idUser to username


    var friendsMap: HashMap<String, MutableList<String>> = hashMapOf(
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

    var usernameMap: HashMap<String, Any> = hashMapOf(
        "username" to username)

    var userIdMap: HashMap<String, MutableList<String>> = hashMapOf(
        "userId" to userIdList)


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
    var blowFishAbility : Ability = Ability.DAMAGE_REDUCTION
    var blowFishOwned : Boolean = false

    /*Sword fish*/
    var swordFishLife : Int = 50
    var swordFishCapacity : Int = 50
    var swordFishSpeed : Int = 50
    var swordFishPrice : Int = 50
    var swordFishAbility : Ability = Ability.SPEED
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

        //setUsernameToCloud()
        setStatsToCloud()
        setOptionsToCloud()
        setPlanctonToCloud()
        setLevelsToCloud()
        setFishToCloud()
        //setFriendsToCloud()
        //setUserIdToList()

        getUsernameFromCloud()
        getStatsFromCloud()
        getOptionsFromCloud()
        getPlanctonFromCloud()
        getLevelsFromCloud()
        getFishFromCloud()
        getFriendsFromCloud()
        getAllUsernameListFromCloud()
        //setUserIdToList()
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
    override fun uploadFriends(): Int {
        return friends.size

    }

    override fun uploadPlayerPlankton(): Int{
        return actualPlankton
    }


    override fun buyFish(fishType: FishType) : String{
        when(fishType){
            FishType.ANEMONE -> if(!clownFishOwned && buyFishSupport(clownFishPrice)){
                clownFishOwned = true
                this.setPlanctonToCloud()
                return "Great! Now you own an Anemone!"
            }else{
                return "You'll need no eat more plankton to own this fish..."
            }
            FishType.BLOWFISH -> if(!blowFishOwned && buyFishSupport(blowFishPrice)){
                blowFishOwned = true
                this.setPlanctonToCloud()
                return "Great! Now you own a Blowfish!"
            }else{
                return "You'll need no eat more plankton to own this fish..."
            }
            FishType.SWORDFISH -> if(!swordFishOwned && buyFishSupport(swordFishPrice)){
                swordFishOwned = true
                this.setPlanctonToCloud()
                return "Great! Now you own a Swordfish!"
            }else{
                return "You'll need no eat more plankton to own this fish..."
            }
            FishType.SHARK -> if(!sharkOwned && buyFishSupport(sharkPrice)){
                sharkOwned = true
                this.setPlanctonToCloud()
                return "Great! Now you own a Shark!"
            }else{
                return "You'll need no eat more plankton to own this fish..."
            }
            else -> return ""
        }
    }

    private fun buyFishSupport(price: Int): Boolean {
        if(actualPlankton > price){
            actualPlankton -= price
            return true
        }
        return false
    }

    override fun uploadLevels() : Int{
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


    override fun setStatsToCloud(){
        db.collection("usuarios").document("$user").collection("userContext").document("stats").set(statsMap)
    }

    override fun setPlanctonToCloud(){
        planctonMap["actualPlankton"] = actualPlankton
        db.collection("usuarios").document("$user").collection("userContext").document("plancton").set(planctonMap)
    }
    override fun setLevelsToCloud(){
        db.collection("usuarios").document("$user").collection("userContext").document("levels").set(levelsMap)
    }
    override fun setFishToCloud(){
        db.collection("usuarios").document("$user").collection("userContext").document("fish").set(fishMap)
    }

    override fun getStatsFromCloud(){
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

    override fun setOptionsToCloud(){
        db.collection("usuarios").document("$user").collection("userContext").document("options").set(optionsMap)
    }

    override fun getOptionsFromCloud(){
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

    override fun getPlanctonFromCloud() {
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

    override fun getLevelsFromCloud() {
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

    override fun getFishFromCloud() {
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

    override fun addFriend(friendName: String) {
        //if (db.collection("usuarios").document("$friendName") != null){
        //TODO: COMPROVAR QUE EXISTEIX L'USUARI, provar de fer un toast?
        getFriendsFromCloud()
        if(searchUsernameInUserIdList(friendName)){
            friends.add(friendName)
            setFriendsToCloud()
        }
    }
    /*TODO: PROVAR METODE*/
    fun searchUsernameInUserIdList(name: String): Boolean{
        for(x in userIdList){
            var usernameFriend: String = ""
            db.collection("usuarios").document("$x").collection("userContext").document("username").get()
                .addOnSuccessListener { document ->
                    if (document != null) {
                        usernameFriend = document.data!!.get("username").toString()

                    } else {
                        Log.d(TAG, "No such document")
                    }
                }.addOnFailureListener { exception ->
                    Log.d(TAG, "get failed with ", exception)
                }
            if(name == usernameFriend){
                return true
            }
        }
        return false
    }



    override fun getFriendsFromCloud() {
        db.collection("usuarios").document("$user").collection("userContext").document("friends").get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    var x = document.data!!.get("friends")
                    var y: ArrayList<String> = x as ArrayList<String>
                    for(i in 0 until y.size){
                        friends.add(y[i])
                        var z = friends
                        var k = z
                    }
                } else {
                    Log.d(TAG, "No such document")
                }
            }.addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
    }


    override fun setFriendsToCloud(){
        this.actualitzaFriendsMap()
        db.collection("usuarios").document("$user").collection("userContext").document("friends").set(friendsMap)
    }

    override fun actualitzaFriendsMap(){
        friendsMap["friends"] = friends
    }


    override fun setVibrationState(activated: Boolean) {
        this.vibration = activated
    }

    fun actualitzaUsernameMap(){
        usernameMap["username"] = username
    }

    override fun getFriendsList(): MutableList<String>{
        return this.friends
    }

    override fun getConnected(): Boolean{
        return this.connected
    }
    override fun setConnected(connected: Boolean){
        this.connected = connected
    }

    override fun getUsername(): String {
        return this.username
    }

    override fun setUsername(username: String) {
        this.username = username
        this.setUsernameToCloud()
    }

    override fun getCurrentFish() : FishType{
        return when(currentFish){
            "Commonfish" -> FishType.COMMONFISH
            "Anemone" -> FishType.ANEMONE
            "Blowfish" -> FishType.BLOWFISH
            "Swordfish" -> FishType.SWORDFISH
            "Shark" -> FishType.SHARK
            else -> FishType.COMMONFISH         //Com posar error?
        }
    }

    override fun setCurrentFish(fish: FishType) {
        this.currentFish = when(fish){
            FishType.COMMONFISH -> "Commonfish"
            FishType.ANEMONE -> "Anemone"
            FishType.BLOWFISH -> "Blowfish"
            FishType.SWORDFISH -> "Swordfish"
            FishType.SHARK -> "Shark"
        }
    }


    /* TODO: Fer-ho demà a PIS
        1. IMPLEMENTAR ELS AMICS
            1.1. Fer una llista per cada amic del tipus: username, connected, fishType
            1.2. Agafar cada argument des de Firebase (getFriendsFromCloud) -> S'ha de canviar el mètode. (S'ha de tenir en compte tant user (lletres y numeros random) com username (creat pel client)
            1.3. Actualitzar la vista mitjançant la nova implementació dels amics de model
        2. FER QUE LA BASE DE DADES ES MANTINGUI FIXE (no cada cop que entres es resetegi)
     */

    fun setUsernameToCloud(){
        this.actualitzaUsernameMap()
        db.collection("usuarios").document("$user").collection("userContext").document("username").set(usernameMap)

    }

    fun getUsernameFromCloud(){
        db.collection("usuarios").document("$user").collection("userContext").document("username").get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    username = document.data!!.get("username").toString()
                } else {
                    Log.d(TAG, "No such document")
                }
            }.addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }

    }


    fun getAllUsernameListFromCloud(){
        db.collection("userID").document("userList").get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    var x = document.data!!.get("userId")
                    var y: ArrayList<String> = x as ArrayList<String>
                    for(i in 0 until y.size){
                        userIdList.add(y[i])
                    }
                    var z = !searchUserIdInUserIdList("$user")
                    if(z) {
                        this.userIdList.add(user)
                        userIdMap["userId"] = userIdList
                        setAllUsernameListToCloud()
                    }
                } else {
                    Log.d(TAG, "No such document")
                }
            }.addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
    }
    fun setAllUsernameListToCloud(){
        userIdMap["userId"] = userIdList
        db.collection("userID").document("userList").set(userIdMap)

    }

    fun setUserIdToList(){
        this.userIdList.add(user)
        //userIdMap["userId"] = userIdList
        setAllUsernameListToCloud()
    }


    /*
        Mètode que et diu si un id d'usuari està a la llista d'usuaris. Per no poder ficar dos al hora, potser ho puc posar dins del MAIN METHOD...
     */
    fun searchUserIdInUserIdList(name: String): Boolean{

        if(name in userIdList){
            return true
        }
        return false
    }

}