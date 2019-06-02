package com.example.frponsll40alumnes.runfish.abilities

import com.example.frponsll40alumnes.runfish.fish.BlowFish
import com.example.frponsll40alumnes.runfish.fish.CommonFish
import com.example.frponsll40alumnes.runfish.fish.Fish

class DamageReduction : AbilityStrategy {

    override val cooldown = 8

    override fun useAbility(fish: Fish) : Int {
        if(fish is BlowFish) {
            fish.noDamage = true
        }

        return this.cooldown
    }

}