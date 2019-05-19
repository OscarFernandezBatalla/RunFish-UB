package com.example.frponsll40alumnes.runfish.abilities

import com.example.frponsll40alumnes.runfish.fish.Anemone
import com.example.frponsll40alumnes.runfish.fish.Fish

class Speed : AbilityStrategy {

    val SPEED_INCREASE_DURATION = 30;

    override fun useAbility(fish: Fish) {

        if(fish is Anemone) {
            fish.speed *= 2;
            fish.speedIncreaseForNFrames = SPEED_INCREASE_DURATION;
        }

    }

}