package com.example.frponsll40alumnes.runfish.npc

import android.content.Context

class NPCFactory {
    fun createNPC(type : NPCType, context: Context, value : Int = 25, vertical : Boolean = true, leftToRight : Boolean = false) : NPC? = when (type){
        NPCType.BOMB -> Bomb(context, 10)
        NPCType.ENEMYSHARK -> EnemyShark(context, value, vertical, leftToRight)
        NPCType.PLANKTON -> Plankton(context, (1..5).random())
    }

}