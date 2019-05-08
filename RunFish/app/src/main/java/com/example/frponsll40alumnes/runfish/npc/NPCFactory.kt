package com.example.frponsll40alumnes.runfish.npc

import android.content.Context

class NPCFactory {
    fun createNPC(type : NPCType, context: Context, value : Int = 25, vertical : Boolean = true, leftToRight : Boolean = false) : NPC? = when (type){
        NPCType.BOMB -> Bomb(context, value)
        NPCType.ENEMYSHARK -> EnemyShark(context, value, vertical, leftToRight)
        NPCType.PLANKTON -> Plankton(context, value)
    }

}