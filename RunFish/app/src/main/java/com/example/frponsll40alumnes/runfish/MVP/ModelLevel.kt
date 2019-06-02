package com.example.frponsll40alumnes.runfish.MVP

class ModelLevel {
    private var numPlankton: Int = 0
    private var numBomb: Int = 0
    private var numShark: Int = 0
    private var meters: Int = 0



    fun getLevelContext(numLevel: Int): MutableList<Int>{
        when(numLevel){
            -1 ->{
                numPlankton = 10
                numBomb = 2
                numShark = 2
                meters = -3000
            }
            0 -> {
                numPlankton = 15
                numBomb = 5
                numShark = 5
                meters = -4000

            }
            1 -> {
                numPlankton = 20
                numBomb = 5
                numShark = 5
                meters = -5000
            }
            2 -> {
                numPlankton = 25
                numBomb = 7
                numShark = 7
                meters = -6000
            }
            3 -> {
                numPlankton = 30
                numBomb = 7
                numShark = 7
                meters = -7000
            }
            4 -> {
                numPlankton = 30
                numBomb = 7
                numShark = 7
                meters = -8000
            }
            5 -> {
                numPlankton = 30
                numBomb = 7
                numShark = 7
                meters = -9000
            }
            6 -> {
                numPlankton = 30
                numBomb = 7
                numShark = 7
                meters = -10000
            }
            7-> {
                numPlankton = 30
                numBomb = 7
                numShark = 7
                meters = -10000
            }
            8 -> {
                numPlankton = 30
                numBomb = 7
                numShark = 7
                meters = -10000
            }
            9 -> {
                numPlankton = 30
                numBomb = 7
                numShark = 7
                meters = -10000
            }
            10 -> {
                numPlankton = 30
                numBomb = 7
                numShark = 7
                meters = -10000
            }
        }
        return mutableListOf(numPlankton,numBomb, numShark, meters)
    }


}