package com.example.frponsll40alumnes.runfish.npc

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import com.example.frponsll40alumnes.runfish.R

class Bomb(context: Context, damage : Int): NPC(damage) {

    private val pes = 20
    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeight = Resources.getSystem().displayMetrics.heightPixels
    private val image : Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.mina)
    override var width: Int = image.width
    override var height: Int = image.height


    /**
     * Draws the object on to the canvas.
     */
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


        y+= (pes)


    }

}