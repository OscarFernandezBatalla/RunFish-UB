package com.example.frponsll40alumnes.runfish.abilities

import android.content.ContentValues
import android.util.Log
import com.example.frponsll40alumnes.runfish.fish.Fish
import com.example.frponsll40alumnes.runfish.fish.SwordFish

class Speed : AbilityStrategy {

    override val cooldown = 7;

    val SPEED_INCREASE_DURATION = 120;

    override fun useAbility(fish: Fish) : Int {

        if(fish is SwordFish) {

            fish.speedIncreaseActivated = true;
            fish.speed += fish.speedIncrease;
            Log.w(ContentValues.TAG, "QWE Increasing speed ${fish.speed}")
            fish.speedIncreaseForNFrames = SPEED_INCREASE_DURATION;
        }

        return this.cooldown
    }

}