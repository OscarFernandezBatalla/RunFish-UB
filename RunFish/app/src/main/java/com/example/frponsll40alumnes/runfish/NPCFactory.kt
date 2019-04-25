package com.example.frponsll40alumnes.runfish

class NPCFactory {

    fun createNPC(type : NPCType) : NPC? = when (type){
        NPCType.BOMB -> Bomb()
        NPCType.ENEMYSHARK -> EnemyShark()
        NPCType.PLANKTON -> Plankton()
        //else -> null      ????
    }

}