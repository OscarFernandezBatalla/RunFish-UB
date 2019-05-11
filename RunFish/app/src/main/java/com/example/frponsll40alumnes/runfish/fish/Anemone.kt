package com.example.frponsll40alumnes.runfish.fish

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import com.example.frponsll40alumnes.runfish.R

class Anemone(context: Context) :
    Fish(name = "Anemone", life = 20, capacity =  20, ability = "health", price =  1000) {

    init{
        this.image = BitmapFactory.decodeResource(context.resources, R.drawable.anemone)
    }
}