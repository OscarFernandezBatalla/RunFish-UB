package com.example.frponsll40alumnes.runfish.fish

import android.graphics.Bitmap

class BlowFish(name: String = "BlowFish",
               life: Int = 20,
               capacity: Int = 20,
               ability: String = "shield",
               price: Int = 2000, image : Bitmap
) :
    Fish(image, name, life, capacity, ability, price) {
    override fun changePosition() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}