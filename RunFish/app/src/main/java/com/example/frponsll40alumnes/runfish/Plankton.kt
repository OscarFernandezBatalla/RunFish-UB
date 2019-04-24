package com.example.frponsll40alumnes.runfish

import android.content.res.Resources

class Plankton(var value : Int) : Dimension{

    //TODO : Ojo que és 0 ara mateix

    override var width: Int
        get() = 0
        set(value) {}
    override var height: Int
        get() = 0
        set(value) {}

    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeight = Resources.getSystem().displayMetrics.heightPixels

    
}