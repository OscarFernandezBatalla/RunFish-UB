package com.example.frponsll40alumnes.runfish.abilities

import android.content.ContentValues
import android.util.Log
import com.example.frponsll40alumnes.runfish.fish.Fish
import com.example.frponsll40alumnes.runfish.fish.SwordFish

class Speed : AbilityStrategy {

    override val cooldown = 7

    private val SPEED_INCREASE_DURATION = 120

    override fun useAbility(fish: Fish) : Int {

        if(fish is SwordFish) {

            fish.speedIncreaseActivated = true
            fish.speed += fish.speedIncrease
            fish.speedIncreaseForNFrames = SPEED_INCREASE_DURATION
        }

        return this.cooldown
    }

}