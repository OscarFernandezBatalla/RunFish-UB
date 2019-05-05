package com.example.frponsll40alumnes.runfish.fish

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.frponsll40alumnes.runfish.R


class BlowFish(context: Context) :
    Fish("BlowFish", 20, 20, "shield", 2000) {

    init{
        this.image = BitmapFactory.decodeResource(context.resources, R.drawable.pez_globo)
    }


    override fun changePosition() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
