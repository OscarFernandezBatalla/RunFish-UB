package com.example.frponsll40alumnes.runfish.fish

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import com.example.frponsll40alumnes.runfish.*
import com.example.frponsll40alumnes.runfish.abilities.AbilityStrategy
import com.example.frponsll40alumnes.runfish.collision.CollisionStrategy

abstract class Fish (
                    //var image : Bitmap,
                     //var context: Context,
                     var name : String,
                     var life : Int,
                     var capacity : Int,
                     var ability : String,
                     var price : Int


) : Position, Movable, Dimension, DrawableObject {


    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeight = Resources.getSystem().displayMetrics.heightPixels

    override var x: Int = screenWidth/2
    override var y: Int = screenHeight/2
    override var width: Int = 60
    override var height: Int = 30
    override var speed: Int = 70
    override lateinit var image: Bitmap


    /* STATS */
    val maxLife : Int = life
    val minLife : Int = 0

    val maxCapacity : Int = capacity
    val minCapacity : Int = 0

    /*
      TODO: A cada classe que haguem de dibuixar, haurem de fer un draw i un update? En cas que sí, com accedim al valor
      TODO: del joystick? Perque el fish es mourà a partir d'ell, amb un paràmetres a la propi mètode? Els demés si que podríem fer-ho automàtic.
     */

    fun looseLife(damage : Int){
        this.life -= damage
        if(this.life <= this.minLife){
            //die();
        }
    }

    fun gainLife(healing : Int){
        if((this.life + healing) >= this.maxLife){
            return
        }
        this.life += healing
    }

    fun gainCapacity(cargo : Int){
        if((this.capacity + cargo) >= this.maxCapacity){
            return
        }
        this.capacity += cargo
    }

    fun looseCapacity(cargo : Int){
        if((this.capacity - cargo) <= this.minCapacity){
            this.capacity = this.minCapacity
        } else {
            this.capacity -= cargo
        }
    }


    fun useAbility(ability : AbilityStrategy){
        ability.useAbility(this)
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
        } else{
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