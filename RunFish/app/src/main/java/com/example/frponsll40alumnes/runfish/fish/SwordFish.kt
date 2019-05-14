package com.example.frponsll40alumnes.runfish.fish

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.frponsll40alumnes.runfish.R

class SwordFish(context: Context) : Fish("SwordFish", 20,0,"speed", 1000, 20, 20){
    init{
        this.image = BitmapFactory.decodeResource(context.resources, R.drawable.sword_fish)
    }
}
