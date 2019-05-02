package com.example.frponsll40alumnes.runfish.npc

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas

class Bomb(var image: Bitmap): NPC(value = 25) {
    override fun changePosition() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private var xVelocity = 20
    private var yVelocity = 20
    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeight = Resources.getSystem().displayMetrics.heightPixels
    

    init {

        var height = image.height
        var width = image.width

        x = screenWidth/2 //random positions
        y = -screenHeight
    }

    /**
     * Draws the object on to the canvas.
     */
    fun draw(canvas: Canvas) {
        canvas.drawBitmap(image, x.toFloat(), y.toFloat(), null)
    }

    /**
     * update properties for the game object
     */
    fun update() {

        y+= (yVelocity)


    }

}