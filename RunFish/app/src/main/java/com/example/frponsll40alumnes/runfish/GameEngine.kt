package com.example.frponsll40alumnes.runfish

import android.content.ContentValues
import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Rect
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.support.v4.content.ContextCompat.getSystemService
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import com.example.frponsll40alumnes.runfish.Difficulty.DifficultyType
import com.example.frponsll40alumnes.runfish.abilities.Ability
import com.example.frponsll40alumnes.runfish.abilities.AbilityStrategy
import com.example.frponsll40alumnes.runfish.abilities.Health
import com.example.frponsll40alumnes.runfish.fish.Fish
import com.example.frponsll40alumnes.runfish.fish.FishFactory
import com.example.frponsll40alumnes.runfish.npc.*
import java.util.*

class GameEngine(var fishType: FishType, var atributs : MutableList<Int>, var levelContext: MutableList<Int>, var context: Context/*, var numLevel: Int*/){

    var numberOfDeaths: Int = 0
    var murderedFish: Int = 0
    var distanceTraveled: Int = 0
    var vibration = false
    var freeMode : Boolean = false

    var displayMetrics = Resources.getSystem().displayMetrics
    var displayWidth = displayMetrics.widthPixels
    var displayHeight = displayMetrics.heightPixels

    var fish : Fish? = null

    //var background : Map? = null

    var fishFactory = FishFactory()
    var npcFactory = NPCFactory()

    var level = Level(levelContext, context)

    var valy : Double = 0.0
    var valx : Double = 0.0
    var strength: Int = 0

    var NPCList: MutableList<NPC?>? = mutableListOf()

    //Inicialitzem el joc, hauriem de comprobar si es SinglePlayer o Multiplayer i després crear el peix AQUI.
    fun startGame(){

        //vibration = this.uploadVibration()

        // Create player fish
        fish = fishFactory.createFish(fishType, context, atributs)

        // Get background
        //background = level.getMap()

        // Create npcs for the level
        for((key, value) in level.getNpc()){
            for(i in 0..value){
                val npc = npcFactory.createNPC(key, context, vertical = true) //vertical = Random().nextBoolean(), leftToRight = Random().nextBoolean())
                if(npc != null){
                    NPCList!!.add(npc)
                }
            }
        }

        var posx: Int
        var posy: Int

        // Spawn created npcs
        if (!freeMode){
            for(x in NPCList!!){


                if (x is EnemyShark) {
                    if (x.vertical) {
                        posx = (0..(displayWidth - x.width)).random()     //pot começar a 0?
                        posy = (2500..30000).random() * (-1)//this.level.getMeters()*60).random() * (-1)       //ajustar el 40
                    } else {
                        if (x.leftToRight) {
                            posx = (-2000..0).random()     //si no va fer-ho amb -1 i invertir random
                            posy =
                                (0..displayHeight).random()//(displayHeight..this.level.getMeters()*25).random()      //si no va fer-ho amb -1 i invertir random
                        } else {
                            posx = (0..2000).random()     //si no va fer-ho amb -1 i invertir random
                            posy =
                                (0..displayHeight).random()//(displayHeight..this.level.getMeters()*25).random()     //si no va fer-ho amb -1 i invertir random
                        }
                    }
                } else {
                    posx = (0..(displayWidth - x!!.width)).random()     //pot começar a 0?
                    posy =
                        (displayHeight..25000).random() * (-1)//this.level.getMeters()*60).random() * (-1)       //ajustar el 40
                }
                x.changeCoordinates(posx, posy)
            }
        }


        //freemode
        else{
            val NPCListFreeMode : MutableList<NPC?> = mutableListOf(
                npcFactory.createNPC(NPCType.ENEMYSHARK, context, vertical = false, leftToRight = false),   //sharkR
                npcFactory.createNPC(NPCType.ENEMYSHARK, context, vertical = true, leftToRight = true),     //sharkL
                npcFactory.createNPC(NPCType.ENEMYSHARK, context, vertical = true),                         //sharkV
                npcFactory.createNPC(NPCType.PLANKTON, context),                                            //plankton
                npcFactory.createNPC(NPCType.BOMB, context))                                                 //bomb


            android.os.Handler().postDelayed({
                val nextNPC = NPCListFreeMode.random()
                if (nextNPC is EnemyShark) {
                    if (nextNPC.vertical) {
                        posx = (0..(displayWidth - nextNPC.width)).random()     //pot começar a 0?
                        posy = displayHeight * -1//(2500..30000).random() * (-1)//this.level.getMeters()*60).random() * (-1)       //ajustar el 40
                    } else {
                        if (nextNPC.leftToRight) {
                            posx = -nextNPC.width     //si no va fer-ho amb -1 i invertir random
                            posy = (0..displayHeight).random()//(displayHeight..this.level.getMeters()*25).random()      //si no va fer-ho amb -1 i invertir random
                        } else {
                            posx = nextNPC.width     //si no va fer-ho amb -1 i invertir random
                            posy = (0..displayHeight).random()//(displayHeight..this.level.getMeters()*25).random()     //si no va fer-ho amb -1 i invertir random
                        }
                    }
                }
                else {
                    posx = (0..(displayWidth - nextNPC!!.width)).random()     //pot começar a 0?
                    posy = -nextNPC.height//displayHeight..25000).random() * (-1)//this.level.getMeters()*60).random() * (-1)       //ajustar el 40
                }
                nextNPC.changeCoordinates(posx, posy)
            }, 2000)
        }
    }


    //Mètode que obté la informació del joystick
    fun getJoystickInf(xJoy: Double, yJoy: Double, strength: Int){
        valx = xJoy
        valy = yJoy
        this.strength = strength
    }

    fun collision(npc: NPC): Boolean{
        val npcRect = npc.rectangle
        val playerRect = fish!!.rectangle

        return playerRect.intersect(npcRect)
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
                x.collision(fish)
                //fish!!.collision(x!!) // per mirar si té el shield activat

                /* aixo hauria d'estar dintre de fish.collision()*/
                if(x is Plankton){
                    fish!!.gainCapacity(x.value)
                }
                else{
                    fish!!.loseLife(x.value)
                    if(vibration){
                        vibrate()
                    }
                }
            }
        }
        // Update scrolling of background
        //background!!.update()
        level.update()
    }

    private fun vibrate() {
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (vibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {   // necessari ja que que amb apis antigues no va
                vibrator.vibrate(VibrationEffect.createOneShot(250, VibrationEffect.DEFAULT_AMPLITUDE))
            }
        }
    }


    fun updateVibration(activated : Boolean){
        this.vibration = activated
    }

    fun getNPC(): MutableList<NPC?>? {
        return NPCList!!
    }

    /*fun getMap(): Map? {
        return background!!
    }*/

    fun getFishGE(): Fish? {
        return fish!!
    }

    fun useAbilityGE() : Int {
        return fish!!.useAbility()
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

    /* Get an array of npcs positioned inside a rectangular area */
    fun getNPCsInArea(x_start : Int, x_end : Int, y_start : Int, y_end : Int) : MutableList<NPC?> {
        /* the are to scan in is delimited by the parameters */
        var NPCsInArea: MutableList<NPC?> = mutableListOf()

        for(npc in NPCList!!){
            if(npc!!.y in y_start..y_end && npc.x in x_start..x_end){
                NPCsInArea.add(npc)
            }
        }
        return NPCsInArea
    }

    fun getMeters() : Int{
        return this.level.getMeter()
    }

    fun freeModeOn() {
        this.freeMode = true
    }
}