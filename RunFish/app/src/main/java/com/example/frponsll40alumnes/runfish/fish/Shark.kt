package com.example.frponsll40alumnes.runfish.fish

import android.graphics.Bitmap

class Shark(name: String = "Shark",
            life: Int = 20,
            capacity: Int = 20,
            ability: String = "bite",
            price: Int = 1000, image : Bitmap
) :
    Fish(image, name, life, capacity, ability, price) {
    override fun changePosition() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}