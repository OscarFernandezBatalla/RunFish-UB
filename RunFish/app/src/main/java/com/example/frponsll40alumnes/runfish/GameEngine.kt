package com.example.frponsll40alumnes.runfish

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import com.example.frponsll40alumnes.runfish.fish.Anemone
import com.example.frponsll40alumnes.runfish.fish.Fish
import com.example.frponsll40alumnes.runfish.fish.FishFactory
import com.example.frponsll40alumnes.runfish.npc.EnemyShark
import com.example.frponsll40alumnes.runfish.npc.Plankton

class GameEngine(var player1: Player, var player2: Player? = null, var context: Context){

    /* TODO: Potser hem de passar parametres a la classe, per exemple potser posar les imatges dels objectes aqui passant resources.*/
    // LevelStats instanciat a player??????? Llavors quan tinguem dos, sol haurem de fer-nos carrec de player.stats

    var planktonCollected: Int = 0
    var numberOfDeaths: Int = 0 //Potser un bool?
    var murderedFish: Int = 0
    var distanceTraveled: Int = 0

    var fish : Fish? = null
    lateinit var plankton: Plankton
    lateinit var shark: EnemyShark



    var valy : Double = 0.0
    var valx : Double = 0.0
    var strength: Int = 0




    //Inicialitzem el joc, hauriem de comprobar si es SinglePlayer o Multiplayer i després crear el peix AQUI.
    fun startGame(){
        //TODO: Obviament s'ha de fer bé, de moment volia probar si funciona tot correctament.

        //fish = Anemone(BitmapFactory.decodeResource(context.resources, R.drawable.anemone_reduced))
        //fish = Fish(context) //fish = Fish(ANEMONE, context)
        var factory = FishFactory()
        fish = factory.createFish(FishType.ANEMONE,context)

        plankton = Plankton(BitmapFactory.decodeResource(context.resources, R.drawable.placton))
        shark = EnemyShark(BitmapFactory.decodeResource(context.resources, R.drawable.shark_top))


    }

    //Mètode que obté la informació del joystick
    fun getJoystickInf(xJoy: Double, yJoy: Double, strength: Int){
        valx = xJoy
        valy = yJoy
        this.strength = strength
    }

    //Mètode que fa un update de cada objecte
    fun updateView(){
        fish!!.update((valx*strength/3).toInt(), -(valy*strength/3).toInt())
        plankton!!.update()
        shark!!.update()
        //fish!!.update((valx*strength/3).toInt(), -(valy*strength/3).toInt())
    }

    //Mètode que dibuixa sobre el canvas, no estic molt segur de si aniría aqui, pero el update jo estic casi segur que si.
    fun drawView(canvas : Canvas){
        plankton!!.draw(canvas)
        shark!!.draw(canvas)
        fish!!.draw(canvas)
    }







}