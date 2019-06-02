package com.example.frponsll40alumnes.runfish.MVP

import android.content.Context
import com.example.frponsll40alumnes.runfish.*
import com.example.frponsll40alumnes.runfish.abilities.Ability
import com.example.frponsll40alumnes.runfish.activityFragments.HomeActivity
import com.example.frponsll40alumnes.runfish.npc.NPC
import com.example.frponsll40alumnes.runfish.fish.Fish

class Presenter(var viewActivity: HomeActivity) : Contract.Presenter{

    var model: Model = Model(this)
    var gameEngine: GameEngine? = null

    override fun uploadStats(): MutableList<Int> {
        return model.uploadStats()
    }

    override fun uploadMusicBar(): Int {
        return model.uploadMusicBar()
    }

    override fun uploadSoundSwitch(): Boolean {
        return model.uploadSoundSwitch()
    }

    override fun uploadVibrationSwitch(): Boolean {
        return model.uploadVibrationSwitch()
    }

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
        gameEngine = GameEngine(this.getCurrentFish(),this.model.getAtriutes(this.getCurrentFish()),this.getLevelContext(),context)
        if (this.model.getLevelSelected() == -1){
            gameEngine!!.freeModeOn()
        }
        gameEngine!!.setSounds(this.model.getSounds())
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

    override fun getFish(): Fish? {
        return gameEngine!!.getFishGE()
    }

    override fun useAbility() : Int {
        return gameEngine!!.useAbilityGE()
    }

    override fun lifeBar(): Int{
        return gameEngine!!.lifeBar()
    }

    override fun capacityBar(): Int{
        return gameEngine!!.capacityBar()
    }

    override fun increaseDeath() {
        this.model.increaseDeath()
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

    override fun getFriendsList(): MutableList<String>{
        return this.model.getFriendsList()
    }

    override fun getConnected(): Boolean{
        return this.model.getConnected()
    }

    override fun setConnected(connected: Boolean){
        this.model.setConnected(connected)
    }

    override fun getUsername(): String {
        return this.model.getUsername()
    }

    override fun setUsername(username: String) {
        this.model.setUsername(username)
    }

    override fun getCurrentFish() : FishType{
        return model.getCurrentFish()
    }

    override fun setCurrentFish(fish: FishType) {
        model.setCurrentFish(fish)
    }


    override fun setStatsToCloud() {
        this.model.setStatsToCloud()
    }


    override fun getAllFromCloud() {
        this.model.getAllFromCloud()
    }

    override fun getMeters() : Int{
        return this.gameEngine!!.getMeters()
    }

    override fun setMeters(meters : Int){
        this.viewActivity.setMeters(meters)
    }

    override fun getLevel() : Level{
        return this.gameEngine!!.level
    }

    override fun setActualLevel(numLevel: Int) {
        this.model.setLevelSelected(numLevel)
    }

    override fun getActualLevel(): Int {
        return this.model.getLevelSelected()
    }

    override fun unlockNextLevel() {
        this.model.unlockNextLevel(this.model.getLevelSelected())
        this.model.setLevelsToCloud()
    }

    override fun freeModeON() {
        this.model.freeModeON()
    }

    override fun getLevelContext(): MutableList<Int> {
        return this.model.getLevelContext()
    }

    override fun getFreeMode(): Boolean {
        return this.model.getFreeMode()
    }

    override fun setMusic(progress: Int) {
        this.model.setMusic(progress)
    }

    override fun getFreeModePlankton(): Int {
        return this.gameEngine!!.getFreeModePlankton()
    }

    override fun getBonus(): Boolean {
        return this.gameEngine!!.getBonus()
    }

    override fun setSounds(checked: Boolean) {
        this.model.setSounds(checked)
    }

    override fun getMetersLevel(): Int {
        return this.model.getMetersLevel()
    }

    override fun addPlankton() {
        this.model.addPlankton(this.getPlanktonCollected())
    }
}