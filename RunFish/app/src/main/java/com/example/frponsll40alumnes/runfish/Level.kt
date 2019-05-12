package com.example.frponsll40alumnes.runfish

import com.example.frponsll40alumnes.runfish.Difficulty.DifficultyFactory
import com.example.frponsll40alumnes.runfish.Difficulty.DifficultyType
import com.example.frponsll40alumnes.runfish.npc.NPCType

open class Level (var numLevel : Int, val difficultyLevel : DifficultyType, var meters : Int)
{

    var npcs = HashMap<NPCType, Int>()
    val difficultyFactory = DifficultyFactory()
    var difficulty = difficultyFactory.createDifficulty(difficultyLevel)


    init {
        npcs.put(NPCType.PLANKTON, difficulty!!.getNPlankton())
        npcs.put(NPCType.BOMB, difficulty!!.getNBombs())
        npcs.put(NPCType.ENEMYSHARK, difficulty!!.getNSharks())
    }

    fun getMetersLevel(): Int{
        return meters
    }

}

