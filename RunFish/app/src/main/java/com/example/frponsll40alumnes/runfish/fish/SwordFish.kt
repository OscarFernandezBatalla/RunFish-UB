package com.example.frponsll40alumnes.runfish.fish

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Rect
import com.example.frponsll40alumnes.runfish.R

class SwordFish(context: Context) : Fish("SwordFish", 20,0,"speed", 1000, 20, 20){
    init{
        this.image = BitmapFactory.decodeResource(context.resources, R.drawable.sword_fish)
    }
    override val width: Int = image.width
    override val height: Int = image.height

    override var rectangle: Rect = Rect(this.x, this.y, this.x+width, this.y+height)
}
