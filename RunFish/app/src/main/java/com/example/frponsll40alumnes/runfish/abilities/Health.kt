package com.example.frponsll40alumnes.runfish.abilities

import com.example.frponsll40alumnes.runfish.fish.Fish

class Health(val additionHealth : Int = 30) : AbilityStrategy {

    override fun useAbility(fish: Fish) {
        if((fish.life + additionHealth) >= fish.maxLife){
            fish.life = fish.maxLife
        }else {
            fish.life += additionHealth
        }

    }
}