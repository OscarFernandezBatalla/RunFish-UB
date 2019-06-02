package com.example.frponsll40alumnes.runfish

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import com.example.frponsll40alumnes.runfish.Difficulty.DifficultyFactory
import com.example.frponsll40alumnes.runfish.Difficulty.DifficultyType
import com.example.frponsll40alumnes.runfish.npc.NPCType

open class Level (var levelContext : MutableList<Int>, val context : Context)
{
    private var meters: Int = 0
    private var npcs = HashMap<NPCType, Int>()
    private val difficultyFactory = DifficultyFactory()
    private var difficultyLevel : DifficultyType? = null
    private var elements : MutableList<BackgroundElement> = mutableListOf()
    private var displayWidth = Resources.getSystem().displayMetrics.widthPixels
    private var displayHeight = Resources.getSystem().displayMetrics.heightPixels
    private var heightNavegationBar = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android"))

    init{
        setMap()
        for (i in 1..(-meters/1000)){

            val height = if (i == 1){
                -500
            }else{
                -i*1250
            }
            val leftCoral = BackgroundElement(BackgroundType.LEFT_CORAL, context)
            val rightCoral = BackgroundElement(BackgroundType.RIGHT_CORAL, context)
            val leftTurtle = BackgroundElement(BackgroundType.LEFT_TURTLE, context)
            val rightTurtle = BackgroundElement(BackgroundType.RIGHT_TURTLE, context)
            val leftFish = BackgroundElement(BackgroundType.LEFT_FISH, context)
            val rightFish = BackgroundElement(BackgroundType.RIGHT_FISH, context)

            leftCoral.setCoordenates(0, height)
            rightCoral.setCoordenates(displayWidth+heightNavegationBar-rightCoral.getImageWidth(), height+500)
            leftTurtle.setCoordenates(displayWidth+heightNavegationBar-600, height+250)
            rightTurtle.setCoordenates(400, height-400)
            leftFish.setCoordenates(leftCoral.getImageWidth()+300, height-500)
            rightFish.setCoordenates(displayWidth+heightNavegationBar-400, height+100)

            this.elements.add(leftCoral)
            this.elements.add(rightCoral)
            this.elements.add(leftTurtle)
            this.elements.add(rightTurtle)
            this.elements.add(leftFish)
            this.elements.add(rightFish)
        }

        /*val difficulty = difficultyFactory.createDifficulty(difficultyLevel!!)
        npcs[NPCType.PLANKTON] = difficulty!!.getNPlankton()
        npcs[NPCType.BOMB] = difficulty.getNBombs()
        npcs[NPCType.ENEMYSHARK] = difficulty.getNSharks()
        */
    }

    private fun setMap(){

        npcs[NPCType.PLANKTON] = this.levelContext[0]
        npcs[NPCType.BOMB] = this.levelContext[1]
        npcs[NPCType.ENEMYSHARK] = this.levelContext[2]
        meters = this.levelContext[3]
    }

    fun getNpc(): HashMap<NPCType, Int> {
        return this.npcs
    }

    fun update() {
        if(this.meters <= 0){
            meters+=5
        }
        for (i in elements){
            i.update()
        }
    }

    fun updateFreeMode() {
        //meters+=1
        //if(this.meters <= 0){
            meters+=5
        //}
        for (i in elements){
            i.update()
        }
    }

    fun draw(canvas : Canvas){
        for (i in elements){
            i.draw(canvas)
        }
    }

    fun getMeter() : Int{
        return this.meters
    }

    fun setMeters() {
        this.meters = 0
    }

}

