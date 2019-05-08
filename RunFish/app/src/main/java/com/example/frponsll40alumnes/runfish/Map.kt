package com.example.frponsll40alumnes.runfish

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas

class Map (context: Context){


    private val image : Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.fons_mari_llarg)
    private var x : Int = 0
    private var y : Int = - image.height + Resources.getSystem().displayMetrics.heightPixels





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

        if(y < 0){
            y+= (5)
        }



    }
}