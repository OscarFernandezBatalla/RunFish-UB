package com.example.frponsll40alumnes.runfish.abilities

import com.example.frponsll40alumnes.runfish.fish.Fish
import com.example.frponsll40alumnes.runfish.fish.Shark

class Bite : AbilityStrategy {

    override val cooldown = 8

    override fun useAbility(fish: Fish) : Int {

        if(fish is Shark) {
            fish.biteActivated = true;
            fish.biteFrame = 3;
        }

        return this.cooldown
    }
}