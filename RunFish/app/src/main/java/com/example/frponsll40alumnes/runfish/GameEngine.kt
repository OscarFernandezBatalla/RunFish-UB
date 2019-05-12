package com.example.frponsll40alumnes.runfish

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.widget.ProgressBar
import com.example.frponsll40alumnes.runfish.Difficulty.DifficultyType
import com.example.frponsll40alumnes.runfish.fish.Fish
import com.example.frponsll40alumnes.runfish.fish.FishFactory
import com.example.frponsll40alumnes.runfish.npc.*

class GameEngine(var player1: Player, var player2: Player? = null, var context: Context){

    var planktonCollected: Int = 0
    var numberOfDeaths: Int = 0 //Potser un bool? //Int per les stats
    var murderedFish: Int = 0
    var distanceTraveled: Int = 0

    var displayMetrics = Resources.getSystem().displayMetrics
    var displayWidth = displayMetrics.widthPixels
    var displayHeight = displayMetrics.heightPixels

    var fish : Fish? = null

    var background : Map? = null

    var fishFactory = FishFactory()
    var npcFactory = NPCFactory()

    var level = Level(0, DifficultyType.VERY_HARD, 85)

    var valy : Double = 0.0
    var valx : Double = 0.0
    var strength: Int = 0

    var NPCList: MutableList<NPC> = mutableListOf()

    //Inicialitzem el joc, hauriem de comprobar si es SinglePlayer o Multiplayer i després crear el peix AQUI.
    fun startGame(){

        // Create player fish
        fish = fishFactory.createFish(player1.fishType, context);

        // Create background
        background = Map(context)



        // Create npcs for the level
        for((key, value) in level.npcs){
            for(i in 0..value){
                var npc = npcFactory.createNPC(key, context)
                if(npc != null){
                    NPCList.add(npc)
                }
            }
        }

        // Spawn created npcs
        for(x in NPCList){
            // Handpicked values that fit the demo
            var posx = (10..(displayWidth - 200)).random()
            var posy = (displayHeight..(level.meters * 53)).random() * (-1)
            x.changeCoordinates(posx, posy)
        }
    }

    //Mètode que obté la informació del joystick
    fun getJoystickInf(xJoy: Double, yJoy: Double, strength: Int){
        valx = xJoy
        valy = yJoy
        this.strength = strength
    }

    fun collision(npc: NPC): Boolean{
        if (fish!!.x < npc.x + npc.width &&
            fish!!.x + fish!!.width > npc.x &&
            fish!!.y < npc.y + npc.height &&
            fish!!.height + fish!!.y > npc.y) {
            return true
            // ¡colision detectada!
        }
        return false
    }


    //Mètode que fa un update de cada objecte
    fun updateView(){
        // Update positions for player's fish
        fish!!.update(valx, valy, strength)

        // Update positions for npcs
        for(x in NPCList){
            x.update()
        }

        // Check if npcs had a collision
        for(x in NPCList){
            if(collision(x)){
                x.collision(fish)
                //x!!.action()
            }
        }

        // Update scrolling of background
        background!!.update()

        // Check if player is still alive
        if(fish!!.isDead){
            // Stop game
        }




    }

    //Mètode que dibuixa sobre el canvas, no estic molt segur de si aniría aqui, pero el update jo estic casi segur que si.
    fun drawView(canvas : Canvas){
        // Draw background
        background!!.draw(canvas)

        // Draw npcs
        for(x in NPCList){
            x!!.draw(canvas)
        }

        // Draw player
        fish!!.draw(canvas)
    }

}