package com.example.frponsll40alumnes.runfish

import com.example.frponsll40alumnes.runfish.abilities.AbilityStrategy
import com.example.frponsll40alumnes.runfish.collision.CollisionStrategy

abstract class Fish(
                    var name : String,
                    var life : Int,
                    var capacity : Int,
                    var ability : String,
                    var price : Int) : Movable() {

    //fun looseLife(damage : Int){}
    //fun looseCapacity(damage : Int){}
    fun useAbility(ability : AbilityStrategy){
        ability.useAbility(this)
    }

    fun collision(collision : CollisionStrategy){
        collision.collision()//parametres? fish? position?
    }

    override fun move() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}