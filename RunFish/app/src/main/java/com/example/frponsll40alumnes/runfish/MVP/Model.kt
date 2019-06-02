package com.example.frponsll40alumnes.runfish.MVP

import android.content.ContentValues.TAG
import android.support.annotation.Nullable
import android.util.Log
import com.example.frponsll40alumnes.runfish.FishType
import com.example.frponsll40alumnes.runfish.abilities.Ability
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.*
import org.w3c.dom.Document


@Suppress("UNREACHABLE_CODE")
class Model (var presenter: Presenter) : Contract.Model {
    var db: FirebaseFirestore= FirebaseFirestore.getInstance()
    var user = FirebaseAuth.getInstance().currentUser!!.uid
    var modelLevel: ModelLevel = ModelLevel()
    var collectionUserContext: CollectionReference = db.collection("usuarios").document("$user").collection("userContext")
    var documentStats: DocumentReference = collectionUserContext.document("stats")
    var documentFish: DocumentReference = collectionUserContext.document("fish")
    var documentFriends: DocumentReference = collectionUserContext.document("friends")
    var documentLevels: DocumentReference = collectionUserContext.document("levels")
    var documentOptions: DocumentReference = collectionUserContext.document("options")
    var documentPlancton: DocumentReference = collectionUserContext.document("plancton")
    var documentUsername: DocumentReference = collectionUserContext.document("username")
    var documentIdList: DocumentReference = db.collection("userID").document("userList")
    private var friends: MutableList<String> = mutableListOf()
    private var usernameList: MutableList<String> = mutableListOf()
    private var userIdList: MutableList<String> = mutableListOf()
    private var currentFish : String? = null
    private var freeMode : Boolean = false

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

    var usernameIdMap: HashMap<String, String> = hashMapOf()
    var usernameIdMapLock : Boolean = false;

    var usernameIdCloudMap : HashMap<String, HashMap<String,String>> = hashMapOf(
        "usernameIdMap" to usernameIdMap)

    var friendsMap: HashMap<String, MutableList<String>> = hashMapOf(
        "friends" to friends
    )

    private var levelsUnlocked : Int = 1
    var levelsMap: HashMap<String, Int> = hashMapOf(
        "levelsUnlocked" to levelsUnlocked
    )

    private var music : Int = 50
    private var sound : Boolean = true
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

    private var levelSelected : Int = 1
    private var actualPlankton: Int = 0

    var planctonMap: HashMap<String, Int> = hashMapOf(
        "actualPlankton" to actualPlankton
    )

    /*FISH*/

    /*Common fish*/
    var commonFishLife : Int = 40
    var commonFishCapacity : Int = 20
    var commonFishSpeed : Int = 20
    var commonFishPrice : Int = 0
    var commonFishAbility : Ability = Ability.SHIELD
    var commonFishOwned : Boolean = true


    /*Clownfish*/
    var clownFishLife : Int = 60
    var clownFishCapacity : Int = 30
    var clownFishSpeed : Int = 40
    var clownFishPrice : Int = 100
    var clownFishAbility : Ability = Ability.HEALTH
    var clownFishOwned : Boolean = false

    /*Blow fish*/
    var blowFishLife : Int = 60
    var blowFishCapacity : Int = 60
    var blowFishSpeed : Int = 30
    var blowFishPrice : Int = 350
    var blowFishAbility : Ability = Ability.DAMAGE_REDUCTION
    var blowFishOwned : Boolean = false

    /*Sword fish*/
    var swordFishLife : Int = 80
    var swordFishCapacity : Int = 50
    var swordFishSpeed : Int = 50
    var swordFishPrice : Int = 1000
    var swordFishAbility : Ability = Ability.SPEED
    var swordFishOwned : Boolean = false

    /*Shark*/
    var sharkLife : Int = 200
    var sharkCapacity : Int = 90
    var sharkSpeed : Int = 70
    var sharkPrice : Int = 5000
    var sharkAbility : Ability = Ability.BITE
    var sharkOwned : Boolean = false

    var fishMap: HashMap<String, Boolean> = hashMapOf(
    "commonFishOwned" to commonFishOwned,
    "clownFishOwned" to clownFishOwned,
    "blowFishOwned" to blowFishOwned,
    "swordFishOwned" to swordFishOwned,
    "sharkOwned" to sharkOwned
    )

    fun getAtriutes(fish : FishType) : MutableList<Int> {

        var llista = mutableListOf<Int>()
        var life = 0
        var capacity = 0

        when (fish) {
            FishType.ANEMONE -> {
                life = clownFishLife
                capacity = clownFishCapacity
            }
            FishType.BLOWFISH ->{
                life = blowFishLife
                capacity = blowFishCapacity
            }
            FishType.SWORDFISH ->{
                life = swordFishLife
                capacity = swordFishCapacity
            }
            FishType.SHARK ->{
                life = sharkLife
                capacity = sharkCapacity
            }
            FishType.COMMONFISH ->{
                life = commonFishLife
                capacity = commonFishCapacity
            }
        }
        llista.add(life)
        llista.add(capacity)

        return llista

    }

    private fun setTotalFishStat(){
        statTotalFish = 0
        for ((_, value) in fishMap) {
            if(value){
                statTotalFish += 1
            }
        }
    }

    private fun increaseTotalFishStat(){
        statTotalFish += 1
    }


    init{
        getAllUsernameListFromCloud() // Agafem tots els usuaris i els posem a dins la llista d'ID

        android.os.Handler().postDelayed({
            if(!searchUserIdInUserIdList(user)){
                setUsernameToCloud()
                setTotalFishStat()
                setStatsToCloud()
                setOptionsToCloud()
                setPlanctonToCloud()
                setLevelsToCloud()
                setFishToCloud()
                setFriendsToCloud()
            }
            else{
                getAllFromCloud()
            }
        }, 5000)
    }

    fun getAllFromCloud() {
        getUsernameFromCloud()
        getStatsFromCloud()
        getOptionsFromCloud()
        getPlanctonFromCloud()
        getLevelsFromCloud()
        getFishFromCloud()
        getFriendsFromCloud()
        getAllUsernameListFromCloud()
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

    override fun uploadSoundSwitch(): Boolean {
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
                this.increaseTotalFishStat()
                this.setStatsToCloud()
                this.setPlanctonToCloud()
                this.setFishToCloud()
                return "Great! Now you own an Anemone!"
            }else{
                return "You'll need no eat more plankton to own this fish..."
            }
            FishType.BLOWFISH -> if(!blowFishOwned && buyFishSupport(blowFishPrice)){
                blowFishOwned = true
                this.increaseTotalFishStat()
                this.setStatsToCloud()
                this.setPlanctonToCloud()
                this.setFishToCloud()
                return "Great! Now you own a Blowfish!"
            }else{
                return "You'll need no eat more plankton to own this fish..."
            }
            FishType.SWORDFISH -> if(!swordFishOwned && buyFishSupport(swordFishPrice)){
                swordFishOwned = true
                this.increaseTotalFishStat()
                this.setStatsToCloud()
                this.setPlanctonToCloud()
                this.setFishToCloud()
                return "Great! Now you own a Swordfish!"
            }else{
                return "You'll need no eat more plankton to own this fish..."
            }
            FishType.SHARK -> if(!sharkOwned && buyFishSupport(sharkPrice)){
                sharkOwned = true
                this.increaseTotalFishStat()
                this.setStatsToCloud()
                this.setPlanctonToCloud()
                this.setFishToCloud()
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

    override fun setStatsToCloud(){
        statsMap["statTotalFish"] = statTotalFish
        statsMap["statPlanktonCollected"] = statPlanktonCollected
        statsMap["statNumberOfDeath"] = statNumberOfDeath
        statsMap["statMurderedFish"] = statMurderedFish
        statsMap["statMaxDistanceTraveled"] = statMaxDistanceTraveled
        documentStats.set(statsMap)
    }

    override fun setPlanctonToCloud(){
        planctonMap["actualPlankton"] = actualPlankton
        documentPlancton.set(planctonMap)
    }
    override fun setLevelsToCloud(){
        levelsMap["levelsUnlocked"] = levelsUnlocked
        db.collection("usuarios").document("$user").collection("userContext").document("levels").set(levelsMap)
    }
    override fun setFishToCloud(){
        fishMap["commonFishOwned"]=commonFishOwned
        fishMap["clownFishOwned"]=clownFishOwned
        fishMap["blowFishOwned"]=blowFishOwned
        fishMap["swordFishOwned"]=swordFishOwned
        fishMap["sharkOwned"]=sharkOwned
        documentFish.set(fishMap)
    }

    override fun getStatsFromCloud(){
       documentStats.get().addOnSuccessListener { document ->
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
       documentOptions.set(optionsMap)
    }

    override fun getOptionsFromCloud(){
        documentOptions.get().addOnSuccessListener { document ->
            if (document != null) {
                music = document.data!!.get("music").toString().toInt()
                sound = document.data!!.get("sound").toString().toBoolean()
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
        documentPlancton.get()
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
        documentLevels.get()
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
        documentFish.get()
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
        if(friendName in usernameIdMap.values){
            // Comprovar que no et pots afegir tu mateix a la teva llista d'amics
            if(usernameIdMap[friendName] != user) {
                //Comprovar també que no el tinc com amic
                if(friendName !in friends) {
                    friends.add(friendName)
                    setFriendsToCloud()
                }
            }
        }
    }

    override fun getUsernameListFromCloud(name: String): Boolean{

        for(x in userIdList){
            usernameIdMapLock = true //defined near usernameIdMap
            db.collection("usuarios").document("${x}").collection("userContext").document("username").get()
                .addOnSuccessListener { document->
                    if(document != null){
                        usernameList.add(document.data!!.get("username").toString())
                        usernameIdMapLock = false
                    }
                }
                .addOnFailureListener { exception->
                    Log.d(TAG, "get failed with ", exception)
                    usernameIdMapLock = false
                }
        }

        //CAUTION: BOOTLENECK. WAIT UNTIL THE REQUESTS ARE COMPLETED
        while(usernameIdMapLock && userIdList.size != usernameIdMap.size);

        if(name in usernameIdMap)
            return true
        return false
    }

    override fun getFriendsFromCloud() {
        documentFriends.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    var x = document.data!!.get("friends")
                    var y: ArrayList<String> = x as ArrayList<String>
                    for(i in 0 until y.size){
                        friends.add(y[i])
                    }
                } else {
                    Log.d(TAG, "No such document")
                }
            }.addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
    }

    override fun setFriendsToCloud(){
        friendsMap["friends"] = friends
        documentFriends.set(friendsMap)
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
        usernameIdMap["$user"] = username
        usernameIdCloudMap["usernameIdMap"] = usernameIdMap
        this.setUsernameIdCloudMap()
        this.setUsernameToCloud()
    }

    private fun setUsernameIdCloudMap() {
        documentIdList.set(usernameIdCloudMap)
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

    override fun setUsernameToCloud(){
        this.actualitzaUsernameMap()
        documentUsername.set(usernameMap)


    }

    override fun getUsernameFromCloud(){
        documentUsername.get()
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


    override fun getAllUsernameListFromCloud() {
        documentIdList.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val x = document.data!!.get("usernameIdMap")
                    val y: HashMap<String,String> = x as HashMap<String, String>
                    usernameIdMap = y

                } else {
                    Log.d(TAG, "No such document")
                }
            }.addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
    }

    override fun setAllUsernameListToCloud(){
        userIdMap["userId"] = userIdList
        documentIdList.set(userIdMap)
    }

    override fun searchUserIdInUserIdList(name: String): Boolean{

        if(name in usernameIdMap.keys){
            return true
        }
        return false
    }

    override fun increaseDeath() {
        statNumberOfDeath++
        this.setStatsToCloud()
    }

    override fun setLevelSelected(numLevel : Int){
        this.levelSelected = numLevel
    }
    override fun getLevelSelected() : Int{
        return this.levelSelected
    }

    override fun unlockNextLevel(actualLevel: Int) {
        if (actualLevel == levelsUnlocked && actualLevel < 10){
            this.levelsUnlocked++
            this.setLevelSelected(levelsUnlocked++)
        }
    }

    override fun freeModeON() {
        this.freeMode = true
        this.levelSelected = -1
    }

    override fun getFreeMode() : Boolean{
        return this.freeMode
    }

    override fun getLevelContext(): MutableList<Int>{
        return this.modelLevel.getLevelContext(levelSelected)
    }

    override fun setMusic(progress : Int) {
        this.music = progress
    }

    override fun getSounds(): Boolean {
        return this.sound
    }

    override fun setSounds(checked: Boolean) {
        this.sound = checked
    }

    override fun getMetersLevel(): Int {
        return this.modelLevel.getMetersLevel()
    }

    override fun addPlankton(planktonCollected: Int) {
        this.statPlanktonCollected += planktonCollected
        this.actualPlankton += planktonCollected
        this.setPlanctonToCloud()
        this.setStatsToCloud()
    }

    override fun setMetersTraveled(metersLevel: Int) {
        this.statMaxDistanceTraveled += metersLevel
        this.setStatsToCloud()
    }

    fun getLevelsUnlocked(): Int{
        return this.levelsUnlocked
    }
}
