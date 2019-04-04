package com.example.frponsll40alumnes.runfish

abstract class Element(var positionX : Int = 0,
                       var positionY : Int = 0,
                       var visible : Boolean = true){

    fun setPosition(posX : Int, posY : Int){
        positionX= posX
        positionY= posY
    }

}