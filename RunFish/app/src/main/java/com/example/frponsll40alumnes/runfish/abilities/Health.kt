package com.example.frponsll40alumnes.runfish.abilities

import com.example.frponsll40alumnes.runfish.fish.Fish

class Health(val additionHealth : Int = 30) : AbilityStrategy {

    override val cooldown = 10;

    override fun useAbility(fish: Fish) : Int {
        if((fish.life + additionHealth) >= fish.maxLife){
            fish.life = fish.maxLife
        }else {
            fish.life += additionHealth
        }

        return this.cooldown;
    }
}