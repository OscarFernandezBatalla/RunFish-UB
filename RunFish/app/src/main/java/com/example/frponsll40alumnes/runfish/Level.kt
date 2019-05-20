package com.example.frponsll40alumnes.runfish

import android.content.Context
import com.example.frponsll40alumnes.runfish.Difficulty.DifficultyFactory
import com.example.frponsll40alumnes.runfish.Difficulty.DifficultyType
import com.example.frponsll40alumnes.runfish.npc.NPCType

open class Level (var numLevel : Int, val context : Context)
{

    private var meters: Int = 0
    private var map : Map? = null
    private var npcs = HashMap<NPCType, Int>()
    private val difficultyFactory = DifficultyFactory()
    private var difficultyLevel : DifficultyType? = null



    init{
        setMap()
        val difficulty = difficultyFactory.createDifficulty(difficultyLevel!!)
        npcs[NPCType.PLANKTON] = difficulty!!.getNPlankton()
        npcs[NPCType.BOMB] = difficulty.getNBombs()
        npcs[NPCType.ENEMYSHARK] = difficulty.getNSharks()

    }

    private fun setMap(){
        when(numLevel){
            0 -> {
                this.meters = 50
                map = Map (context, this.meters)
                difficultyLevel = DifficultyType.TUTORIAL
            }
            1 -> {
                this.meters = 50
                map = Map (context, this.meters)
                difficultyLevel = DifficultyType.VERY_EASY
            }
            2 -> {
                this.meters = 100
                map = Map (context, this.meters)
                difficultyLevel = DifficultyType.VERY_EASY
            }
            3 -> {
                this.meters = 50
                map = Map (context, this.meters)
                difficultyLevel = DifficultyType.EASY
            }
            4 -> {
                this.meters = 100
                map = Map (context, this.meters)
                difficultyLevel = DifficultyType.EASY
            }
            5 -> {
                this.meters = 50
                map = Map (context, this.meters)
                difficultyLevel = DifficultyType.NORMAL
            }
            6 -> {
                this.meters = 100
                map = Map (context, this.meters)
                difficultyLevel = DifficultyType.NORMAL
            }
            7 -> {
                this.meters = 50
                map = Map (context, this.meters)
                difficultyLevel = DifficultyType.HARD
            }
            8 -> {
                this.meters = 100
                map = Map (context, this.meters)
                difficultyLevel = DifficultyType.HARD
            }
            9 -> {
                this.meters = 50
                map = Map (context, this.meters)
                difficultyLevel = DifficultyType.VERY_HARD
            }
            10 -> {
                this.meters = 100
                map = Map (context, this.meters)
                difficultyLevel = DifficultyType.VERY_HARD
            }
        }
    }

    fun getMap(): Map? {
        return this.map
    }

    fun getNpc(): HashMap<NPCType, Int> {
        return this.npcs
    }

    fun getMeters(): Int{
        return this.map!!.getMeter()
    }
}

