package com.example.frponsll40alumnes.runfish.fish

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import com.example.frponsll40alumnes.runfish.*
import com.example.frponsll40alumnes.runfish.abilities.AbilityStrategy
import com.example.frponsll40alumnes.runfish.collision.CollisionStrategy
import com.example.frponsll40alumnes.runfish.npc.NPC
import com.example.frponsll40alumnes.runfish.npc.Plankton

abstract class Fish (
                     var name : String,
                     var life : Int,
                     var capacity : Int,
                     var ability : String,
                     var price : Int,
                     val maxLife: Int,
                     val maxCapacity: Int
) : Position, Movable, Dimension, DrawableObject {

    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeight = Resources.getSystem().displayMetrics.heightPixels

    override var x: Int = screenWidth/2
    override var y: Int = screenHeight/2
    override var width: Int = 60
    override var height: Int = 30
    override var speed: Int = 70
    override lateinit var image: Bitmap

    var isDead : Boolean = false

    fun loseLife(damage : Int){
        this.life -= damage
        if(this.life <= 0){
            die();
        }
        // emit vibration
    }

    /* Increments, if possible, the current cargo the fish carries */
    fun gainCapacity(cargo : Int){
        if((this.capacity + cargo) >= this.maxCapacity){
            this.capacity = maxCapacity
        }
        else{
            this.capacity += cargo
        }
    }

    fun loseCapacity(cargo : Int){
        if((this.capacity - cargo) <= 0){
            this.capacity = 0
        } else {
            this.capacity -= cargo
        }
    }

    /* Signals the fish is dead */
    fun die(){
        this.isDead = true
    }

    /* Use the fish special ability */
    fun useAbility(ability : AbilityStrategy){
        return ability.useAbility(this)
    }
/*
    fun collision(collision : CollisionStrategy){
        collision.collision(this)//parametres? fish? position?
    }
*/
    open fun collision(npc : NPC){
        if(npc is Plankton){
            this.gainCapacity(npc.value)
        }
        else {
            this.loseLife(npc.value)
            // emite vibration in loseLife
        }
    }

    /* draw fish bitmap */
    fun draw(canvas: Canvas) {
        canvas.drawBitmap(image, x.toFloat(), y.toFloat(), null)
    }


/**
     * update properties for the game object
     */

    /* declared open so the types of fish can override it */
    open fun update(xJoy : Double, yJoy : Double, strength : Int) {
        var aux : Int = if (strength>speed){
            speed
        }
        else{
            strength
        }

        var xV : Int = (xJoy*aux/3).toInt()
        var yV : Int = -(yJoy*aux/3).toInt()

        if (x > screenWidth - image.width){
            xV = -1
        }

        if(x < 2) {
            xV = +1
        }

        if (y > screenHeight - image.height){
            yV = -1
        }

        if(y<2) {
            yV = +1
        }

        x += xV
        y += yV
    }

    override fun changeCoordinates(x: Int, y: Int) {
        this.x = x
        this.y = y
    }


}