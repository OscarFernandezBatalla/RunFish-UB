package com.example.frponsll40alumnes.runfish

import com.example.frponsll40alumnes.runfish.fish.Fish
import com.example.frponsll40alumnes.runfish.npc.Bomb
import com.example.frponsll40alumnes.runfish.npc.EnemyShark
import com.example.frponsll40alumnes.runfish.npc.Plankton

class RemoteRepository: DataModel{
    /*
    TODO: Add methods:
        getMap() -> Calls other functions.
        setMap()
     */

    fun getFish() : ArrayList<Fish> {
        //Returns array of fish that are playing
        var qwe = ArrayList<Fish>();
        return qwe;
    }

    fun setFish(data: ArrayList<Fish>) {
        //
    }

    fun getBombs() : ArrayList<Bomb> {
        //Returns all bombs created in map.
        var qwe = ArrayList<Bomb>();
        return qwe;
    }

    fun setBombs(data: ArrayList<Bomb>){
        //
    }

    fun getPlankton() : ArrayList<Plankton> {
        //Returns array of all plankton created in map.
        var qwe = ArrayList<Plankton>();
        return qwe;
    }

    fun setPlankton(data: ArrayList<Plankton>) {
        //
    }

    fun getSharks() : ArrayList<EnemyShark> {
        //Returns array of all sharks created in map.
        var qwe = ArrayList<EnemyShark>();
        return qwe;
    }

    fun setSharks(data: ArrayList<EnemyShark>){
        //
    }

}