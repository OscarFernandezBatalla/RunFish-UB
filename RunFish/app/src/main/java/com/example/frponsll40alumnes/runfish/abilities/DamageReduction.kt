package com.example.frponsll40alumnes.runfish.abilities

import com.example.frponsll40alumnes.runfish.fish.BlowFish
import com.example.frponsll40alumnes.runfish.fish.Fish

class DamageReduction : AbilityStrategy {

    override val cooldown = 8;

    val DAMAGE_REDUCTION_DURATION = 60;

    override fun useAbility(fish: Fish) : Int {

        if(fish is BlowFish) {
            fish.damageReductionActivated = true;
            fish.damageReductionForNFrames = DAMAGE_REDUCTION_DURATION;
        }

        return this.cooldown;
    }

}