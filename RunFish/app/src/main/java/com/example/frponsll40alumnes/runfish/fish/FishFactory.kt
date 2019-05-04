package com.example.frponsll40alumnes.runfish.fish

import android.content.Context
import com.example.frponsll40alumnes.runfish.FishType

class FishFactory {

    fun createFish(type : FishType, context: Context) : Fish? = when (type) {

        FishType.COMMONFISH -> null
        FishType.ANEMONE -> Anemone(context)
        FishType.BLOWFISH -> null
        FishType.SWORDFISH -> null
        FishType.SHARK -> null


    }

}