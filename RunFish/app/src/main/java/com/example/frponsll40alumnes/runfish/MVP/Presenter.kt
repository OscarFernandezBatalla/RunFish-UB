package com.example.frponsll40alumnes.runfish.MVP

import android.content.Context
import com.example.frponsll40alumnes.runfish.FishType
import com.example.frponsll40alumnes.runfish.GameEngine
import com.example.frponsll40alumnes.runfish.Map
import com.example.frponsll40alumnes.runfish.Player
import com.example.frponsll40alumnes.runfish.abilities.Ability
import com.example.frponsll40alumnes.runfish.activityFragments.HomeActivity
import com.example.frponsll40alumnes.runfish.npc.NPC
import com.example.frponsll40alumnes.runfish.fish.Fish

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

    override fun uploadFriends(): Int {
        return model.uploadFriends()
    }

    override fun uploadPlayerPlankton(): Int{
        return model.uploadPlayerPlankton()
    }

    override fun buyFish(fishType: FishType) : String{
        return model.buyFish(fishType)
    }

    override fun uploadLevels() : Int{
        return model.uploadLevels()
    }

    override fun addFriend(friendName: String) {
        model.addFriend(friendName)
    }

    override fun startGame(player1: Player, player2: Player?, context: Context) {
        gameEngine = GameEngine(player1,player2,context)
        gameEngine!!.updateVibration(uploadVibrationSwitch())
        this.startMusic()
        gameEngine!!.startGame()
    }

    override fun updateJoystickInf(valx: Double, valy: Double, strength: Int) {
        gameEngine!!.getJoystickInf(valx, valy, strength)
    }

    override fun updateView() {
        gameEngine!!.updateView()
    }

    override fun getNPC(): MutableList<NPC?>? {
        return gameEngine!!.getNPC()
    }

    override fun getMap(): Map? {
        return gameEngine!!.getMap()
    }

    override fun getFish(): Fish? {
        return gameEngine!!.getFishGE()
    }

    override fun getBackground(): Map {
        return gameEngine!!.background!!
    }

    override fun useAbility(){
        gameEngine!!.useAbilityGE()
    }

    override fun lifeBar(): Int{
        return gameEngine!!.lifeBar()
    }

    override fun capacityBar(): Int{
        return gameEngine!!.capacityBar()
    }

    override fun increaseDeath() {
        this.gameEngine!!.increaseDeath()
    }

    override fun getPlanktonCollected(): Int {
        return this.gameEngine!!.getPlanktonCollected()
    }


    override fun setVibrationState(activated: Boolean) {
        this.model.setVibrationState(activated)
    }

    override fun getNPCsInArea(x_start : Int, x_end : Int, y_start : Int, y_end : Int) : MutableList<NPC?> {
        return this.gameEngine!!.getNPCsInArea(x_start, x_end, y_start, y_end)
    }

    override fun startMusic(){
        this.viewActivity.getMusic().start()
    }
    override fun stopMusic(){
        this.viewActivity.getMusic().pause()
        this.viewActivity.getMusic().seekTo(0)
    }

    fun getFriendsList(): MutableList<String>{
        return this.model.getFriendsList()
    }

    fun getConnected(): Boolean{
        return this.model.getConnected()
    }

    fun setConnected(connected: Boolean){
        this.model.setConnected(connected)
    }

    fun getUsername(): String {
        return this.model.getUsername()
    }

    fun setUsername(username: String) {
        this.model.setUsername(username)
    }


    fun addUserId() {
        this.model.setUserIdToList()
    }


}