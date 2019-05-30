package com.example.frponsll40alumnes.runfish.fish

import android.content.Context
import com.example.frponsll40alumnes.runfish.FishType

class FishFactory {
    fun createFish(type : FishType, context: Context, atributs : MutableList<Int>) : Fish? = when (type) {
        FishType.COMMONFISH -> CommonFish(context,atributs)
        FishType.ANEMONE -> Anemone(context, atributs)
        FishType.BLOWFISH -> BlowFish(context, atributs)
        FishType.SWORDFISH -> SwordFish(context, atributs)
        FishType.SHARK -> Shark(context, atributs)
    }
}