package com.example.frponsll40alumnes.runfish.abilities

import com.example.frponsll40alumnes.runfish.fish.Fish
import com.example.frponsll40alumnes.runfish.fish.SwordFish

class Speed : AbilityStrategy {

    val SPEED_INCREASE_DURATION = 30;

    override fun useAbility(fish: Fish) {

        if(fish is SwordFish) {
            fish.speed *= fish.speedIncreaseFactor;
            fish.speedIncreaseForNFrames = SPEED_INCREASE_DURATION;
        }

    }

}