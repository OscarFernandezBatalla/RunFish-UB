package com.example.frponsll40alumnes.runfish.fish

import com.example.frponsll40alumnes.runfish.Fish

class Shark(name: String = "Shark",
            life: Int = 20,
            capacity: Int = 20,
            ability: String = "bite",
            price: Int = 1000) :
    Fish(name, life, capacity, ability, price) {
    override fun move() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun useAbility() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}