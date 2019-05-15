package com.example.frponsll40alumnes.runfish.collision

import com.example.frponsll40alumnes.runfish.Position
import com.example.frponsll40alumnes.runfish.fish.Fish

interface CollisionStrategy : Position {

    //override implementation in each one of the npcs
    fun collision(playerFish : Fish?){
        this.x = 10000000; //TODO: Instead of moving offscreen, delete the npc
    }

}