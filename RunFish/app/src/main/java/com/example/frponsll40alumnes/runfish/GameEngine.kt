package com.example.frponsll40alumnes.runfish

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import com.example.frponsll40alumnes.runfish.fish.Anemone
import com.example.frponsll40alumnes.runfish.fish.Fish
import com.example.frponsll40alumnes.runfish.fish.FishFactory
import com.example.frponsll40alumnes.runfish.npc.*

class GameEngine(var player1: Player, var player2: Player? = null, var context: Context){

    /* TODO: Potser hem de passar parametres a la classe, per exemple potser posar les imatges dels objectes aqui passant resources.*/
    // LevelStats instanciat a player??????? Llavors quan tinguem dos, sol haurem de fer-nos carrec de player.stats

    var planktonCollected: Int = 0
    var numberOfDeaths: Int = 0 //Potser un bool? //Int per les stats
    var murderedFish: Int = 0
    var distanceTraveled: Int = 0

    var fish : Fish? = null
    var plankton: NPC? = null
    var plankton2: NPC? = null
    var shark: NPC? = null
    var shark2: NPC? = null
    var shark3: NPC? = null
    var bomb: NPC? = null
    var bomb2: NPC? = null

    //lateinit var shark: EnemyShark

    var fishFactory = FishFactory()
    var npcFactory = NPCFactory()

    var valy : Double = 0.0
    var valx : Double = 0.0
    var strength: Int = 0

    var NPCList: MutableList<NPC> = mutableListOf()

    //Inicialitzem el joc, hauriem de comprobar si es SinglePlayer o Multiplayer i després crear el peix AQUI.
    fun startGame(){
        //fish = factory.createFish(FishType.ANEMONE,context)

        fish = Anemone(context)         //player1.getFish()

        //plankton amb punts per defecte
        plankton = npcFactory.createNPC(NPCType.PLANKTON, context)
        plankton!!.changeCoordinates(300, -500)

        //plankton amb 100 punts

        plankton2 = npcFactory.createNPC(NPCType.PLANKTON, context, value = 100)
        plankton2!!.changeCoordinates(100, -1000)

        //shark amb damage per defecte
        shark = npcFactory.createNPC(NPCType.ENEMYSHARK, context)
        shark!!.changeCoordinates(400, -1500)

        //shark amb 50 de damage
        shark2 = npcFactory.createNPC(NPCType.ENEMYSHARK, context, value = 50)
        shark2!!.changeCoordinates(950, -3000)

        //shark horitzontal
        shark3 = npcFactory.createNPC(NPCType.ENEMYSHARK, context, value = 50, vertical = false, leftToRight = false)
        shark3!!.changeCoordinates(950, 250)


        //bomb amb damage per defecte
        bomb = npcFactory.createNPC(NPCType.BOMB, context)
        bomb!!.changeCoordinates(600, -3000)

        //bomb amb 20 de damage
        bomb2 = npcFactory.createNPC(NPCType.BOMB, context, value = 20)
        bomb2!!.changeCoordinates(550, -2500)


        NPCList.add(plankton!!)
        NPCList.add(plankton2!!)
        NPCList.add(shark!!)
        NPCList.add(shark2!!)
        NPCList.add(shark3!!)
        NPCList.add(bomb!!)
        NPCList.add(bomb2!!)


    }

    //Mètode que obté la informació del joystick
    fun getJoystickInf(xJoy: Double, yJoy: Double, strength: Int){
        valx = xJoy
        valy = yJoy
        this.strength = strength
    }

    fun collision(npc: NPC): Boolean{
        if (fish!!.x < npc!!.x + npc!!.width &&
            fish!!.x + fish!!.width > npc!!.x &&
            fish!!.y < npc!!.y + npc!!.height &&
            fish!!.height + fish!!.y > npc!!.y) {
            return true
            // ¡colision detectada!
        }
        return false
    }


    //Mètode que fa un update de cada objecte
    fun updateView(){
        fish!!.update(valx, valy, strength)
        plankton!!.update()
        shark!!.update()
        bomb!!.update()
        plankton2!!.update()
        shark2!!.update()
        bomb2!!.update()
        shark3!!.update()


        for(x in NPCList){
            if(collision(x)){
                x!!.x = 10000000
            }
        }
/*

        if(collision(plankton!!)){
            plankton!!.x = 100000000
        }
        if(collision(plankton2!!)){
            plankton2!!.x = 100000000
        }
        if(collision(shark!!)){
            shark!!.x = 100000000
        }
        if(collision(shark2!!)){
            shark2!!.x = 100000000
        }
        if(collision(bomb!!)){
            bomb!!.x = 100000000
        }
        if(collision(bomb2!!)){
            bomb2!!.x = 100000000
        }
        if(collision(shark3!!)){
            shark3!!.x = 100000000
        }
*/


        //TODO: For de tots els NPC de la array i dins: NPC.action()
    }

    //Mètode que dibuixa sobre el canvas, no estic molt segur de si aniría aqui, pero el update jo estic casi segur que si.
    fun drawView(canvas : Canvas){
        plankton!!.draw(canvas)
        bomb!!.draw(canvas)
        shark!!.draw(canvas)
        plankton2!!.draw(canvas)
        bomb2!!.draw(canvas)
        shark2!!.draw(canvas)
        shark3!!.draw(canvas)
        fish!!.draw(canvas)
    }










}