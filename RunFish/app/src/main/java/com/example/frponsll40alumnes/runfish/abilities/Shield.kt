package com.example.frponsll40alumnes.runfish.abilities

import com.example.frponsll40alumnes.runfish.fish.CommonFish
import com.example.frponsll40alumnes.runfish.fish.Fish

class Shield : AbilityStrategy {

    override val cooldown = 12

    override fun useAbility(fish: Fish) : Int {

        /* Invencibility for next INVENCIBILITY_LENGTH_IN_FRAMES frames */
        if(fish is CommonFish) {
            fish.damageReductionActivated = true
        }

        return this.cooldown
    }

}