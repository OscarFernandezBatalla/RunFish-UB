package com.example.frponsll40alumnes.runfish.abilities

import com.example.frponsll40alumnes.runfish.fish.CommonFish
import com.example.frponsll40alumnes.runfish.fish.Fish

class Shield : AbilityStrategy {

    override val cooldown = 12;

    val INVENCIBILITY_LENGTH_IN_FRAMES = 60

    override fun useAbility(fish: Fish) : Int {

        /* Invencibility for next INVENCIBILITY_LENGTH_IN_FRAMES frames */
        if(fish is CommonFish){

            // activate the invencibility for the next INVENCIBILITY_LENGTH_IN_FRAMES frames
            fish.invencibilityForNFrames = INVENCIBILITY_LENGTH_IN_FRAMES
        }

        return this.cooldown;
    }

}