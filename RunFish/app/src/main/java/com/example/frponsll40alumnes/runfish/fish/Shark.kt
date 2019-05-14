package com.example.frponsll40alumnes.runfish.fish

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.frponsll40alumnes.runfish.R

class Shark(context: Context) : Fish("Shark",20,0,"bite",1000,20,20){
    init{
        this.image = BitmapFactory.decodeResource(context.resources, R.drawable.shark)
    }
}

