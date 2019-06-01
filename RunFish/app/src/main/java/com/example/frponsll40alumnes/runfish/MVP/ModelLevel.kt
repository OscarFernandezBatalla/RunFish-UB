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
                meters = -10000
            }
            0 -> {
                numPlankton = 5
                numBomb = 5
                numShark = 5
                meters = -10000

            }
            1 -> {
                numPlankton = 5
                numBomb = 5
                numShark = 5
                meters = -10000
            }
            2 -> {
                numPlankton = 5
                numBomb = 5
                numShark = 5
                meters = -10000
            }
            3 -> {
                numPlankton = 5
                numBomb = 5
                numShark = 5
                meters = -10000
            }
            4 -> {
                numPlankton = 5
                numBomb = 5
                numShark = 5
                meters = -10000
            }
            5 -> {
                numPlankton = 5
                numBomb = 5
                numShark = 5
                meters = -10000
            }
            6 -> {
                numPlankton = 5
                numBomb = 5
                numShark = 5
                meters = -10000
            }
            7-> {
                numPlankton = 5
                numBomb = 5
                numShark = 5
                meters = -10000
            }
            8 -> {
                numPlankton = 5
                numBomb = 5
                numShark = 5
                meters = -10000
            }
            9 -> {
                numPlankton = 5
                numBomb = 5
                numShark = 5
                meters = -10000
            }
            10 -> {
                numPlankton = 5
                numBomb = 5
                numShark = 5
                meters = -10000
            }
        }
        return mutableListOf(numPlankton,numBomb, numShark, meters)
    }


}