package com.example.frponsll40alumnes.runfish.abilities

import com.example.frponsll40alumnes.runfish.fish.Fish

interface AbilityStrategy {

    val cooldown : Int;

    fun useAbility(fish : Fish) : Int
}