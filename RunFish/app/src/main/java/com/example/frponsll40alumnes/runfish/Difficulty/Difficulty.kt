package com.example.frponsll40alumnes.runfish.Difficulty

interface Difficulty {

    val sharks_min : Int
    val sharks_max : Int

    val bombs_min : Int
    val bombs_max : Int

    val plankton_min : Int
    val plankton_max : Int

    fun getNSharks() : Int{
        return (sharks_min..sharks_max).random()
    }
    fun getNBombs() : Int{
        return (bombs_min..bombs_max).random()
    }
    fun getNPlankton() : Int{
        return (plankton_min..plankton_max).random()
    }

}