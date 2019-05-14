package com.example.frponsll40alumnes.runfish.abilities

import com.example.frponsll40alumnes.runfish.fish.Fish
import com.example.frponsll40alumnes.runfish.MVP.Presenter

class Bite : AbilityStrategy {


    override fun useAbility(fish: Fish) {
        /* the range of the ability */
        val y_range = 100
        val x_radius = 20
        /* check if there's some npc in range */
        /* eliminate npc */

        /*
        for(npc in presenter.getNPCsInArea( fish.x - x_radius,
                                            fish.x + x_radius,
                                            fish.y,
                                            fish.y + y_range)){
            npc.die()
        }
        */

        TODO("Com podem accedir a GameEngine?") //To change body of created functions use File | Settings | File Templates.
    }

}