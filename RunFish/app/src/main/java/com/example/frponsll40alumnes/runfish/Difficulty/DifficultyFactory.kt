package com.example.frponsll40alumnes.runfish.Difficulty

class DifficultyFactory {

    fun createDifficulty(type : DifficultyType) : Difficulty? = when (type){
        DifficultyType.TUTORIAL -> Tutorial()
        DifficultyType.VERY_EASY -> VeryEasy()
        DifficultyType.EASY -> Easy()
        DifficultyType.NORMAL -> Normal()
        DifficultyType.HARD -> Hard()
        DifficultyType.VERY_HARD -> VeryHard()
    }

}