package com.example.frponsll40alumnes.runfish.fish

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.frponsll40alumnes.runfish.R


class CommonFish(context: Context) :
    Fish("Common Fish", 20, 0, "shield", 0, 20, 20) {

    init{
        this.image = BitmapFactory.decodeResource(context.resources, R.drawable.common_fish)
    }
}