package com.example.frponsll40alumnes.runfish.fish

import com.example.frponsll40alumnes.runfish.Fish

class CommonFish(
    name: String = "Common Fish",
    life: Int = 20,
    capacity: Int = 20,
    ability: String = "shield",
    price: Int = 0

) : Fish(name, life, capacity, ability, price) {
    override fun useAbility() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun move() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}