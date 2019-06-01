package com.example.frponsll40alumnes.runfish.collision

import com.example.frponsll40alumnes.runfish.GameMode
import com.example.frponsll40alumnes.runfish.Position
import com.example.frponsll40alumnes.runfish.fish.Fish

interface CollisionStrategy : Position {

    //override implementation in each one of the npcs
    fun collision(playerFish : Fish?, gameMode : GameMode){

        if(gameMode == GameMode.SINGLEPLAYER_FINITE)
            this.x = 10000000; //TODO: Instead of moving offscreen, delete the npc
        else if(gameMode == GameMode.SINGLEPLAYER_INFINITE) {
            /* Move upwards to reencounter the player */
            /* reuse the npcs */
            this.y = -3000;
        }

    }

}