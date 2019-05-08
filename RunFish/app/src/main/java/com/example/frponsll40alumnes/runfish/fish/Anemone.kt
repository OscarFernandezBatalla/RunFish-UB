package com.example.frponsll40alumnes.runfish.fish

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import com.example.frponsll40alumnes.runfish.R

/*class Anemone(image : Bitmap,
              name: String = "Anemone",
              life: Int = 20,
              capacity: Int = 20,
              ability: String = "health",
              price: Int = 1000) :
    Fish(image, name, life, capacity, ability, price) {
*/
class Anemone(context: Context) :
    Fish(name = "Anemone", life = 20, capacity =  20, ability = "health", price =  1000) {



    init{
        this.image = BitmapFactory.decodeResource(context.resources, R.drawable.anemone_reduced)
    }



    var xVelocity : Int = 30
/*
init {
    x = 0
    y = 0
    height = image.height
    width = image.width
}
*/





}