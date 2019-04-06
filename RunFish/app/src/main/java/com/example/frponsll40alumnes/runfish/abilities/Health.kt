package com.example.frponsll40alumnes.runfish.abilities

import com.example.frponsll40alumnes.runfish.fish.Fish

class Health(val additionHealth : Int = 30) : AbilityStrategy {

    override fun useAbility(fish: Fish) {
        fish.life += additionHealth
        if (fish.life> 100){
            fish.life = 100
        }
    }

}