package com.example.frponsll40alumnes.runfish

import android.graphics.drawable.Drawable

abstract class Fish(
                    var name : String,
                    var life : Int,
                    var capacity : Int,
                    var ability : String,
                    var price : Int) : Movable(), Ability{

    //fun looseLife(damage : Int){}
    //fun looseCapacity(damage : Int){}



}