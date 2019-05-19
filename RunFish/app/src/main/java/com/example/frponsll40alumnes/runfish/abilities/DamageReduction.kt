package com.example.frponsll40alumnes.runfish.abilities

import com.example.frponsll40alumnes.runfish.fish.BlowFish
import com.example.frponsll40alumnes.runfish.fish.Fish

class DamageReduction : AbilityStrategy {

    val DAMAGE_REDUCTION_DURATION = 60;

    override fun useAbility(fish: Fish) {

        if(fish is BlowFish) {
            fish.damageReductionActivated = true;
            fish.damageReductionForNFrames = DAMAGE_REDUCTION_DURATION;
        }

    }

}