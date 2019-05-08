package com.example.frponsll40alumnes.runfish.npc

import android.content.Context

class NPCFactory {
    fun createNPC(type : NPCType, context: Context, value : Int = 25) : NPC? = when (type){
        NPCType.BOMB -> Bomb(context, value)
        NPCType.ENEMYSHARK -> EnemyShark(context, value)
        NPCType.PLANKTON -> Plankton(context, value)
    }

}