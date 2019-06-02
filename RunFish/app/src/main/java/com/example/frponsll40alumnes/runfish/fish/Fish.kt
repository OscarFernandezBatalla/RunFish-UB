package com.example.frponsll40alumnes.runfish.fish

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import com.example.frponsll40alumnes.runfish.*
import com.example.frponsll40alumnes.runfish.abilities.AbilityStrategy
import com.example.frponsll40alumnes.runfish.abilities.Speed
import com.example.frponsll40alumnes.runfish.collision.CollisionStrategy
import com.example.frponsll40alumnes.runfish.npc.NPC
import com.example.frponsll40alumnes.runfish.npc.Plankton

abstract class Fish (
                     //var name : String,
                     var life : Int,
                     var capacity : Int,
                     var ability : AbilityStrategy,
                     val maxLife: Int,
                     val maxCapacity: Int
) : Position, Movable, Dimension, DrawableObject {

    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeight = Resources.getSystem().displayMetrics.heightPixels

    override var x: Int = screenWidth/2
    override var y: Int = screenHeight/2

    override var speed: Int = 70
    override lateinit var image: Bitmap
    override var rec: ShapeDrawable = ShapeDrawable(RectShape())

    //val ability : AbilityStrategy = Speed()

    var isDead : Boolean = false

    fun loseLife(damage : Int){

        if(this is BlowFish){
            if(this.damageReductionActivated){
                this.life = this.life - (damage*0.5).toInt()
            }
        }
        else {
            this.life -= damage
            // emit vibration
        }
        if (this.life <= 0) {
            die()
        }
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
    fun useAbility() : Int {
        return this.ability.useAbility(this)
    }
/*
    fun collision(collision : CollisionStrategy){
        collision.collision(this)//parametres? fish? position?
    }
*/
/*    open fun collision(npc : NPC){
        if(npc is Plankton){
            this.gainCapacity(npc.value)
        }
        else {
            this.loseLife(npc.value)
            // emite vibration in loseLife
        }
    }*/

    /* draw fish bitmap */
    fun draw(canvas: Canvas) {
        canvas.drawBitmap(image, x.toFloat(), y.toFloat(), null)
    }


/**
     * update properties for the game object
     */

    /* declared open so the types of fish can override it */
    open fun update(xJoy : Double, yJoy : Double, strength : Int) {

        var xV : Int = (xJoy*strength/3).toInt()
        var yV : Int = -(yJoy*speed/3).toInt()

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

        this.rectangle.set(this.x, this.y, this.x+width, this.y+height)
        //test de col·lisions (temporal):
        //rec.setBounds(this.x, this.y, this.x+width, this.y+height)
    }

    override fun changeCoordinates(x: Int, y: Int) {
        this.x = x
        this.y = y
    }


}