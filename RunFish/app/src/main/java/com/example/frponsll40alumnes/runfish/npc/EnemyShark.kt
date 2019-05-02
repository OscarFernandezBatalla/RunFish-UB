package com.example.frponsll40alumnes.runfish.npc

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import com.example.frponsll40alumnes.runfish.Movable

class EnemyShark(var image : Bitmap) : NPC(value = 50),
    Movable {
    override var speed: Float
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}

    override fun move() {
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
        // val randomNum = ThreadLocalRandom.current().nextInt(1, 5)
/*

        if (x > screenWidth - image.width || x < image.width) {
            xVelocity = xVelocity * -1
        }
        if (y > screenHeight - image.height || y < image.height) {
            yVelocity = yVelocity * -1
        }

        x += (xVelocity)
        y += (yVelocity)
*/


        y+= (yVelocity)


    }

    override fun changePosition() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}