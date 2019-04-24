package com.example.frponsll40alumnes.runfish.fish

import com.example.frponsll40alumnes.runfish.Dimension
import com.example.frponsll40alumnes.runfish.Movable
import com.example.frponsll40alumnes.runfish.Position
import com.example.frponsll40alumnes.runfish.abilities.AbilityStrategy
import com.example.frponsll40alumnes.runfish.collision.CollisionStrategy

abstract class Fish (
                    var name : String,
                    var life : Int,
                    var capacity : Int,
                    var ability : String,
                    var price : Int) : Position, Movable, Dimension {



    /*
      TODO: A cada classe que haguem de dibuixar, haurem de fer un draw i un update? En cas que sí, com accedim al valor
      TODO: del joystick? Perque el fish es mourà a partir d'ell, amb un paràmetres a la propi mètode? Els demés si que podríem fer-ho automàtic.
     */

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