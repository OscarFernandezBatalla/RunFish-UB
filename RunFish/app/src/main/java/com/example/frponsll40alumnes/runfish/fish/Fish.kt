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


    private var xVelocity = 20
    private var yVelocity = 20
    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeight = Resources.getSystem().displayMetrics.heightPixels

    override var x: Int = 0
    override var y: Int = 0
    override var width: Int = 0
    override var height: Int = 0
    override var speed: Float = 0f
    override lateinit var image: Bitmap





    /*
      TODO: A cada classe que haguem de dibuixar, haurem de fer un draw i un update? En cas que sí, com accedim al valor
      TODO: del joystick? Perque el fish es mourà a partir d'ell, amb un paràmetres a la propi mètode? Els demés si que podríem fer-ho automàtic.
     */

    //fun looseLife(damage : Int){}
    //fun looseCapacity(damage : Int){}
    fun useAbility(ability : AbilityStrategy){
        ability.useAbility(this)
    }

    fun collision(collision : CollisionStrategy){
        collision.collision()//parametres? fish? position?
    }

    override fun move() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    fun draw(canvas: Canvas) {
        canvas.drawBitmap(image, x.toFloat(), y.toFloat(), null)
    }


/**
     * update properties for the game object
     */

    fun update(xJoy : Int, yJoy : Int) {

        //y-= (xVelocity)

        x += xJoy
        y += yJoy


    }


}