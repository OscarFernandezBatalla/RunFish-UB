package com.example.frponsll40alumnes.runfish

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas

class BackgroundElement(type : BackgroundType, context : Context) {

    private var image : Bitmap? = null
    private var x : Int = 0
    private var y : Int = 0
    private var imageHeight = 0
    private var imageWidth = 0

    init {
        image = when(type){     //posar tambe les coordenades aqui
            BackgroundType.RIGHT_CORAL -> BitmapFactory.decodeResource(context.resources, R.drawable.coral_r)
            BackgroundType.LEFT_CORAL -> BitmapFactory.decodeResource(context.resources, R.drawable.coral_l)
            BackgroundType.RIGHT_TURTLE -> BitmapFactory.decodeResource(context.resources, R.drawable.turtle_r)
            BackgroundType.LEFT_TURTLE -> BitmapFactory.decodeResource(context.resources, R.drawable.turtle_l)
            BackgroundType.RIGHT_FISH -> BitmapFactory.decodeResource(context.resources, R.drawable.fish_r)
            BackgroundType.LEFT_FISH -> BitmapFactory.decodeResource(context.resources, R.drawable.fish_l)
            BackgroundType.INITIAL -> BitmapFactory.decodeResource(context.resources, R.drawable.initial)
        }
        this.imageHeight = image!!.height
        this.imageWidth = image!!.width
    }


    fun update(){
        y+=5
    }

    fun draw(canvas: Canvas) {
        canvas.drawBitmap(image, x.toFloat(), y.toFloat(), null)
    }

    fun setCoordenates(x : Int, y: Int){
        this.x = x
        this.y = y
    }

    fun getImageWidth() : Int{
        return this.imageWidth
    }

    fun getImageHeight() : Int{
        return this.imageHeight
    }

}