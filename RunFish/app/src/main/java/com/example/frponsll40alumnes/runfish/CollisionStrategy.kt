package com.example.frponsll40alumnes.runfish

import com.example.frponsll40alumnes.runfish.fish.Fish

interface CollisionStrategy : Position{

    //override implementation in each one of the npcs
    fun collision(playerFish : Fish?){

        this.x = 10000000;

    }

}