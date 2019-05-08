package com.example.frponsll40alumnes.runfish.npc

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import com.example.frponsll40alumnes.runfish.Movable
import com.example.frponsll40alumnes.runfish.R

class EnemyShark(context: Context, speed : Int) : NPC(speed),
    Movable {

    override var speed: Int = this.value

    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeight = Resources.getSystem().displayMetrics.heightPixels
    private val image : Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.shark_top)
    private var vertical : Boolean = true
    private var leftToRight : Boolean = true

    override var width: Int = image.width
    override var height: Int = image.height

    fun changeOrientation(vertical : Boolean){
        this.vertical = vertical
    }

    fun changeDirection(leftToRight : Boolean){
        this.leftToRight = leftToRight
    }

    /**
     * Draws the object on to the canvas.
     */
    override fun draw(canvas: Canvas) {
        canvas.drawBitmap(image, x.toFloat(), y.toFloat(), null)
    }

    /**
     * update properties for the game object
     */
    override fun update() {
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

        if (vertical){
            y+= speed
        }

        else{
            if (leftToRight){
                x-= speed
            }
            else{
                x+= speed
            }
        }
    }


}