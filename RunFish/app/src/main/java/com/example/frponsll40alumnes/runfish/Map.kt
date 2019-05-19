package com.example.frponsll40alumnes.runfish

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas

class Map (context: Context){
    private val image2 : Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.fons_mari_llarg_hd_m)


    private var x : Int = 0
    private var y : Int = -(image2.height - Resources.getSystem().displayMetrics.heightPixels)


    private var image : Bitmap = Bitmap.createScaledBitmap(image2, Resources.getSystem().displayMetrics.widthPixels, image2.height, false)



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
        if(y <= 0){
            y+= (5)
        }
    }

    fun getY(): Int {
        return y
    }
}