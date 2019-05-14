package com.example.frponsll40alumnes.runfish.npc

import android.graphics.Canvas
import com.example.frponsll40alumnes.runfish.collision.CollisionStrategy
import com.example.frponsll40alumnes.runfish.Dimension
import com.example.frponsll40alumnes.runfish.Position
import com.example.frponsll40alumnes.runfish.fish.Fish

abstract class NPC(var value : Int, override var x: Int = 0, override var y: Int = 0) : Position, Dimension, CollisionStrategy {

    val pes : Int = 10
    abstract fun update()
    abstract fun draw(canvas : Canvas)


    override fun changeCoordinates(x : Int, y : Int){
        this.x = x
        this.y = y
    }

    override fun collision(playerFish: Fish?) {
        super.collision(playerFish); // move offscreen
    }

}