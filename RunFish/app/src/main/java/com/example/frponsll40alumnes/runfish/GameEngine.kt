package com.example.frponsll40alumnes.runfish

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.support.v4.content.ContextCompat.getSystemService
import android.widget.ProgressBar
import com.example.frponsll40alumnes.runfish.Difficulty.DifficultyType
import com.example.frponsll40alumnes.runfish.abilities.Ability
import com.example.frponsll40alumnes.runfish.abilities.AbilityStrategy
import com.example.frponsll40alumnes.runfish.abilities.Health
import com.example.frponsll40alumnes.runfish.fish.Fish
import com.example.frponsll40alumnes.runfish.fish.FishFactory
import com.example.frponsll40alumnes.runfish.npc.*

class GameEngine(var player1: Player, var player2: Player? = null, var context: Context){

    var numberOfDeaths: Int = 0
    var murderedFish: Int = 0
    var distanceTraveled: Int = 0
    var vibration = false

    var displayMetrics = Resources.getSystem().displayMetrics
    var displayWidth = displayMetrics.widthPixels
    var displayHeight = displayMetrics.heightPixels

    var fish : Fish? = null

    var background : Map? = null

    var fishFactory = FishFactory()
    var npcFactory = NPCFactory()

    var level = Level(0, DifficultyType.VERY_HARD, 85)

    var valy : Double = 0.0
    var valx : Double = 0.0
    var strength: Int = 0

    var NPCList: MutableList<NPC?>? = mutableListOf()

    //Inicialitzem el joc, hauriem de comprobar si es SinglePlayer o Multiplayer i després crear el peix AQUI.
    fun startGame(){

        //vibration = this.uploadVibration()

        // Create player fish
        fish = fishFactory.createFish(player1.fishType, context)

        // Create background
        background = Map(context)

        // Create npcs for the level
        for((key, value) in level.npcs){
            for(i in 0..value){
                var npc = npcFactory.createNPC(key, context)
                if(npc != null){
                    NPCList!!.add(npc)
                }
            }
        }

        // Spawn created npcs
        for(x in NPCList!!){
            // Handpicked values that fit the demo
            var posx = (10..(displayWidth - 200)).random()
            var posy = (displayHeight..(level.meters * 53)).random() * (-1)
            x!!.changeCoordinates(posx, posy)
        }
    }


    //Mètode que obté la informació del joystick
    fun getJoystickInf(xJoy: Double, yJoy: Double, strength: Int){
        valx = xJoy
        valy = yJoy
        this.strength = strength
    }

    fun collision(npc: NPC): Boolean{
        if (fish!!.x < npc.x + npc.width &&
            fish!!.x + fish!!.width > npc.x &&
            fish!!.y < npc.y + npc.height &&
            fish!!.height + fish!!.y > npc.y) {
            return true
            // ¡colision detectada!
        }
        return false
    }


    //Mètode que fa un update de cada objecte
    fun updateView(){
        // Update positions for player's fish
        fish!!.update(valx, valy, strength)

        // Update positions for npcs
        for(x in NPCList!!){
            x!!.update()
        }

        // Check if npcs had a collision
        for(x in NPCList!!){
            if(collision(x!!)){
                x!!.collision(fish)
                if(x is Plankton){
                    fish!!.gainCapacity(x.value)
                }
                else{
                    fish!!.loseLife(x.value)
                    //falta comprovar vibracio de options

                    val vibrator = context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                    if (vibrator.hasVibrator() && this.vibration) { // aqui comprovar
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {   // perque amb apis antigues no va
                            vibrator.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.DEFAULT_AMPLITUDE))
                        }
                    }
                }
            }
        }

        // Update scrolling of background
        background!!.update()

    }

    /*fun drawView(canvas : Canvas){
        // Draw background

        background!!.draw(canvas)

        // Draw npcs
        for(x in NPCList){
            x.draw(canvas)
        }

        // Draw player
        fish!!.draw(canvas)
    }*/

    fun updateVibration(activated : Boolean){
        this.vibration = activated
    }


    fun getNPC(): MutableList<NPC?>? {
        return NPCList!!
    }

    fun getMap(): Map? {
        return background!!
    }

    fun getFishGE(): Fish? {
        return fish!!
    }

    fun useAbilityGE(){
        fish!!.useAbility(Health())
    }

    fun getLife(): Int {
        return fish!!.life
    }

    fun getCapacity(): Int {
        return fish!!.capacity
    }

    fun lifeBar(): Int{
        return fish!!.life*100 / fish!!.maxLife
    }

    fun capacityBar(): Int{
        return fish!!.capacity*100 / fish!!.maxCapacity
    }

    fun increaseDeath() {
        this.numberOfDeaths++
    }

    fun getPlanktonCollected(): Int {
        return this.fish!!.capacity
    }
}