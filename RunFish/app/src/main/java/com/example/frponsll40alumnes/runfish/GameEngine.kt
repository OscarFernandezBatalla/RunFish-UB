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

    var time2 : Int = 0
    var numberOfDeaths: Int = 0
    var murderedFish: Int = 0
    var distanceTraveled: Int = 0
    var vibration = false
    var freeMode : Boolean = false
    var planktonFreeMode: Int = 0

    var displayMetrics = Resources.getSystem().displayMetrics
    var displayWidth = displayMetrics.widthPixels
    var displayHeight = displayMetrics.heightPixels

    var fish : Fish? = null

    private var bonus: Boolean = false
    var mult : Int = 1
    var time: Long = 0 //TEMPS?

    //var background : Map? = null

    var fishFactory = FishFactory()
    var npcFactory = NPCFactory()

    val NPCListFreeMode : MutableList<NPC?>? = mutableListOf()

    var level = Level(levelContext, context)

    fun levelSetMeters(){
        level.setMeters()
    }

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



        var posx: Int = 0
        var posy: Int = 0

        // Spawn created npcs
        if (!freeMode){

            // Create npcs for the level
            for((key, value) in level.getNpc()){
                for(i in 0..value){
                    val npc = npcFactory.createNPC(key, context, vertical = true) //vertical = Random().nextBoolean(), leftToRight = Random().nextBoolean())
                    if(npc != null){
                        NPCList!!.add(npc)
                    }
                }
            }

            var met: Int = - this.level.getMeter()
            for(x in NPCList!!){
                if (x is EnemyShark) {
                    if (x.vertical) {
                        posx = (0..(displayWidth - x.width)).random()     //pot começar a 0?
                        posy = (displayHeight..met*3).random() * (-1)//this.level.getMeters()*60).random() * (-1)       //ajustar el 40
                    }
                } else {
                    posx = (0..(displayWidth - x!!.width)).random()     //pot começar a 0?
                    posy = (displayHeight..(met*1.5).toInt()).random() * (-1)//this.level.getMeters()*60).random() * (-1)       //ajustar el 40
                }
                x.changeCoordinates(posx, posy)
            }
        }


        //freemode
        else{
            levelSetMeters()

            NPCListFreeMode!!.add(npcFactory.createNPC(NPCType.PLANKTON, context))
            NPCListFreeMode.add(npcFactory.createNPC(NPCType.PLANKTON, context))
            NPCListFreeMode.add(npcFactory.createNPC(NPCType.PLANKTON, context))
            NPCListFreeMode.add(npcFactory.createNPC(NPCType.PLANKTON, context))
            NPCListFreeMode.add(npcFactory.createNPC(NPCType.PLANKTON, context))
            NPCListFreeMode.add(npcFactory.createNPC(NPCType.ENEMYSHARK, context, vertical = true))
            NPCListFreeMode.add(npcFactory.createNPC(NPCType.ENEMYSHARK, context, vertical = true))
            NPCListFreeMode.add(npcFactory.createNPC(NPCType.BOMB, context))
            NPCListFreeMode.add(npcFactory.createNPC(NPCType.BOMB, context))
            NPCListFreeMode.add(npcFactory.createNPC(NPCType.BOMB, context))

            for(x in NPCListFreeMode){
                reaparicioNPC(x!!)
            }
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
        time2++

        // Update positions for npcs
        if(!freeMode) {
            for (x in NPCList!!) {
                x!!.update()
            }
            // Check if npcs had a collision
            for (x in NPCList!!) {
                if (collision(x!!)) {
                    x.collision(fish)
                    //fish!!.collision(x!!) // per mirar si té el shield activat

                    /* aixo hauria d'estar dintre de fish.collision()*/
                    if (x is Plankton) {
                        fish!!.gainCapacity(x.value)
                    } else {
                        fish!!.loseLife(x.value)
                        if (vibration) {
                            vibrate()
                        }
                    }
                }
            }
        }
        else{
            for (x in NPCListFreeMode!!) {
                x!!.update()
            }
            for (x in NPCListFreeMode) {
                if (collision(x!!)) {
                    reaparicioNPC(x)
                    if (x is Plankton) {
                        if(bonus && time2 <150){
                            planktonFreeMode += ((x.value)*mult)
                        }
                        else{
                            bonus = false
                            planktonFreeMode += x.value
                            if(isPrime(planktonFreeMode)){
                                bonus = true

                                time2 = 0
                                time = 5000
                                mult = 3
                            }

                        }

                        //fish!!.gainCapacity(x.value)
                    } else {
                        fish!!.loseLife(x.value)
                        if (vibration) {
                            vibrate()
                        }
                    }
                }
                if(NPCLeftScreen(x)){
                    reaparicioNPC(x)
                }
            }



        }

        if(!freeMode) {
            // Update scrolling of background
            level.update()
        }
        else{
            level.updateFreeMode()
        }
    }

    private fun reaparicioNPC(x: NPC){
        var posx = (0..(displayWidth - x.width)).random()     //pot começar a 0?
        var posy = (1000..4000).random() * (-1)//this.level.getMeters()*60).random() * (-1)
        x.changeCoordinates(posx,posy)
    }
    private fun NPCLeftScreen(x:NPC): Boolean{
        if(x.y > displayHeight){
            return true
        }
        return false
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
        if(!freeMode){
            return NPCList!!
        }
        return NPCListFreeMode

    }

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

    fun getFreeModePlankton(): Int {
        return this.planktonFreeMode
    }


    fun isPrime(n: Int): Boolean{
       /* if(n<3)
            return n>1
        else if(n%2 == 0 || n%3 == 0)
            return false

        else if n mod 2 = 0 or n mod 3 = 0
        return false
        let i ← 5
        while i * i ≤ n
        if n mod i = 0 or n mod (i + 2) = 0
        return false
        i ← i + 6
        return true*/
        var flag = false
        for (i in 2..n / 2)
        {
            // condition to check prime number
            if (n % i == 0) {
                flag = true
                break
            }
        }

        if (!flag)
            return true

        return false
    }

    fun getBonus() : Boolean{
        return this.bonus
    }


}