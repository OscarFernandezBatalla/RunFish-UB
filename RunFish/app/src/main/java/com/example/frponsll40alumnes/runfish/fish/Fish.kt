package com.example.frponsll40alumnes.runfish.fish

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import com.example.frponsll40alumnes.runfish.*
import com.example.frponsll40alumnes.runfish.abilities.AbilityStrategy
import com.example.frponsll40alumnes.runfish.collision.CollisionStrategy

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


    /* STATS */
    //val maxLife : Int = life
    //val minLife : Int = 0

    //val maxCapacity : Int = capacity
    //val minCapacity : Int = 0

    fun loseLife(damage : Int){
        this.life -= damage
        if(this.life <= 0){
            die();
        }
    }

    fun gainLife(healing : Int){
        if((this.life + healing) >= this.maxLife){
            this.life = maxLife
        }else {
            this.life += healing
        }
    }

    fun gainCapacity(cargo : Int){
        if((this.capacity + cargo) >= this.maxCapacity){
            this.capacity = maxCapacity
        }
        else{
            this.capacity += cargo
        }
    }

    fun looseCapacity(cargo : Int){
        if((this.capacity - cargo) <= 0){
            this.capacity = 0
        } else {
            this.capacity -= cargo
        }
    }

    fun die(){
        this.isDead = true
    }

    fun useAbility(ability : AbilityStrategy){
        return ability.useAbility(this)
    }

    fun collision(collision : CollisionStrategy){
        collision.collision()//parametres? fish? position?
    }

    fun draw(canvas: Canvas) {
        canvas.drawBitmap(image, x.toFloat(), y.toFloat(), null)
    }


/**
     * update properties for the game object
     */

    fun update(xJoy : Double, yJoy : Double, strength : Int) {


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