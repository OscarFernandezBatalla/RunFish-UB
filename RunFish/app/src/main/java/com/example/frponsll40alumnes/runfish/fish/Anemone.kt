package com.example.frponsll40alumnes.runfish.fish

import android.graphics.Bitmap
import android.graphics.Canvas

class Anemone(image : Bitmap,
              name: String = "Anemone",
              life: Int = 20,
              capacity: Int = 20,
              ability: String = "health",
              price: Int = 1000) :
    Fish(image, name, life, capacity, ability, price) {





    var xVelocity : Int = 30
/*
init {
    x = 0
    y = 0
    height = image.height
    width = image.width
}
*/

    override fun changePosition() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }




}