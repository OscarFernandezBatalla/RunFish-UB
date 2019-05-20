package com.example.frponsll40alumnes.runfish.abilities

import com.example.frponsll40alumnes.runfish.fish.Fish
import com.example.frponsll40alumnes.runfish.fish.Shark

class Bite : AbilityStrategy {


    override fun useAbility(fish: Fish) {

        if(fish is Shark) {
            fish.biteActivated = true;
            fish.biteFrame = 1;
        }

    }
}