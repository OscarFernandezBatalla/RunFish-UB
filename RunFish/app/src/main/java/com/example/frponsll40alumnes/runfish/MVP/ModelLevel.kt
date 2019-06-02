package com.example.frponsll40alumnes.runfish.MVP

class ModelLevel {
    private var numPlankton: Int = 0
    private var numBomb: Int = 0
    private var numShark: Int = 0
    private var meters: Int = 0

    fun getLevelContext(numLevel: Int): MutableList<Int>{
        when(numLevel){
            -1 ->{
                numPlankton = 2
                numBomb = 2
                numShark = 2
                meters = -500
            }
            0 -> {
                numPlankton = 5
                numBomb = 5
                numShark = 5
                meters = -1000

            }
            1 -> {
                numPlankton = 10
                numBomb = 5
                numShark = 5
                meters = -2000
            }
            2 -> {
                numPlankton = 20
                numBomb = 15
                numShark = 10
                meters = -3000
            }
            3 -> {
                numPlankton = 35
                numBomb = 26
                numShark = 17
                meters = -4000
            }
            4 -> {
                numPlankton = 50
                numBomb = 32
                numShark = 25
                meters = -5000
            }
            5 -> {
                numPlankton = 60
                numBomb = 40
                numShark = 30
                meters = -6000
            }
            6 -> {
                numPlankton = 70
                numBomb = 45
                numShark = 34
                meters = -7000
            }
            7-> {
                numPlankton = 77
                numBomb = 50
                numShark = 39
                meters = -8000
            }
            8 -> {
                numPlankton = 88
                numBomb = 57
                numShark = 45
                meters = -9000
            }
            9 -> {
                numPlankton = 95
                numBomb = 64
                numShark = 55
                meters = -10000
            }
            10 -> {
                numPlankton = 150
                numBomb = 85
                numShark = 75
                meters = -15000
            }
        }
        return mutableListOf(numPlankton,numBomb, numShark, meters)
    }


    fun getMetersLevel() : Int{
        return this.meters
    }
}