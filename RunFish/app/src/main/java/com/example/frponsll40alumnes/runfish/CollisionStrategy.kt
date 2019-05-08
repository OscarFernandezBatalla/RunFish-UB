package com.example.frponsll40alumnes.runfish

import com.example.frponsll40alumnes.runfish.fish.Fish

interface CollisionStrategy : Position{

    fun collision(){

        this.x = 10000000;

    }

}