package com.example.frponsll40alumnes.runfish.abilities

import com.example.frponsll40alumnes.runfish.fish.Fish

interface AbilityStrategy {
    fun useAbility(fish : Fish)
}