package com.example.frponsll40alumnes.runfish

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color

class Map (context: Context, var meters: Int){
    private var image2 : Bitmap? = null

    private var auxMeters = 0

    private var x : Int = 0
    private var y : Int = -1000     //actua com a metres!

    private var heightNavegationBar = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android"))
    //private var image : Bitmap



    /*init {
        image2 = if (meters == 50){
            BitmapFactory.decodeResource(context.resources, R.drawable.map_s)
        } else{
            BitmapFactory.decodeResource(context.resources, R.drawable.map_m)
        }

        image = Bitmap.createScaledBitmap(image2!!, Resources.getSystem().displayMetrics.widthPixels+heightNavegationBar, image2!!.height, false)
        auxMeters = image.height
        y = -(image.height - Resources.getSystem().displayMetrics.heightPixels)
    }*/




    /**
     * Draws the object on to the canvas.
    fun draw(canvas: Canvas) {
        //canvas.drawBitmap(image, x.toFloat(), y.toFloat(), null)
        //canvas.drawColor(Color.parseColor("#00fff2"))
    }

    *//**
     * update properties for the game object
     *//*
    fun update() {
        // val randomNum = ThreadLocalRandom.current().nextInt(1, 5)
*//*
        if (x > screenWidth - image.width || x < image.width) {
            xVelocity = xVelocity * -1
        }
        if (y > screenHeight - image.height || y < image.height) {
            yVelocity = yVelocity * -1
        }

        x += (xVelocity)
        y += (yVelocity)
*//*
        if(y <= 0){


            this.auxMeters -= 1

            //image.height ----- 100



            y+= (5)
        }
    }

    fun getY(): Int {
        return y
    }

    fun getMeter() : Int{
        return this.auxMeters
    }*/
}