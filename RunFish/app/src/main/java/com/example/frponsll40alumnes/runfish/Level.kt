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

    private var infinite : Boolean = false;

    /*private var leftCoral : Int = 0
    private var rightCoral : Int = 0
    private var leftTurtle : Int = 0
    private var rightTurtle : Int = 0
    private var leftFish : Int = 0
    private var rightFish : Int = 0*/

    init{
        setMap()
        for (i in 1..(-meters/1000)){
            val leftCoral = BackgroundElement(BackgroundType.LEFT_CORAL, context)
            val rightCoral = BackgroundElement(BackgroundType.RIGHT_CORAL, context)
            val leftTurtle = BackgroundElement(BackgroundType.LEFT_TURTLE, context)
            val rightTurtle = BackgroundElement(BackgroundType.RIGHT_TURTLE, context)
            val leftFish = BackgroundElement(BackgroundType.LEFT_FISH, context)
            val rightFish = BackgroundElement(BackgroundType.RIGHT_FISH, context)

            leftCoral.setCoordenates(0, -i*1500)
            rightCoral.setCoordenates(displayWidth+heightNavegationBar-rightCoral.getImageWidth(), -i*1000)
            leftTurtle.setCoordenates(10, -i*1500)
            rightTurtle.setCoordenates(displayWidth+heightNavegationBar-rightTurtle.getImageWidth(), -i*1500)
            leftFish.setCoordenates(leftCoral.getImageWidth(), -i*1500)
            rightFish.setCoordenates(displayWidth+heightNavegationBar-rightFish.getImageWidth(), -i*1500)

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

        /*when(numLevel){
            0 -> {
                this.meters = -5000
                difficultyLevel = DifficultyType.TUTORIAL
            }
            1 -> {
                this.meters = -5000
                difficultyLevel = DifficultyType.VERY_EASY
            }
            2 -> {
                this.meters = -10000
                difficultyLevel = DifficultyType.VERY_EASY
            }
            3 -> {
                this.meters = -5000
                difficultyLevel = DifficultyType.EASY
            }
            4 -> {
                this.meters = -10000
                difficultyLevel = DifficultyType.EASY
            }
            5 -> {
                this.meters = -5000
                difficultyLevel = DifficultyType.NORMAL
            }
            6 -> {
                this.meters = -10000
                difficultyLevel = DifficultyType.NORMAL
            }
            7 -> {
                this.meters = -5000
                difficultyLevel = DifficultyType.HARD
            }
            8 -> {
                this.meters = -10000
                difficultyLevel = DifficultyType.HARD
            }
            9 -> {
                this.meters = -5000
                difficultyLevel = DifficultyType.VERY_HARD
            }
            10 -> {
                this.meters = -10000
                difficultyLevel = DifficultyType.VERY_HARD
            }
            else->{
                this.meters = -10000    //TODO: aqui s'hauria de posar inifity, pero aleshores peta la linea 31 perque es fan moltes iteracions
                difficultyLevel = DifficultyType.VERY_HARD
            }
        }*/
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

    fun draw(canvas : Canvas){
        for (i in elements){
            i.draw(canvas)
        }
    }

    fun getMeter() : Int{
        return this.meters
    }

    fun levelFinished() : Boolean {
        if(this.infinite)
            return false;
        return (this.meters >= 0);
    }

    fun markAsInfinite(){
        this.infinite = true;
    }
}

