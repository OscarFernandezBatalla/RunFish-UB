package com.example.frponsll40alumnes.runfish

abstract class Element(var positionX : Int = 0,
                       var positionY : Int = 0,
                       var visible : Boolean = true) : Collision{
    
    override fun collision() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun setPosition(posX : Int, posY : Int){
        positionX= posX
        positionY= posY
    }

}