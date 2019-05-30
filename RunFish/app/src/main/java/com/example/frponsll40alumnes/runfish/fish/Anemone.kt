package com.example.frponsll40alumnes.runfish.fish

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import com.example.frponsll40alumnes.runfish.R
import com.example.frponsll40alumnes.runfish.abilities.Health

class Anemone(context: Context, atributs : MutableList<Int>) :
    Fish(atributs[0], 0, Health(), atributs[0], atributs[1]) {


    override var image = BitmapFactory.decodeResource(context.resources, R.drawable.anemone)

    override val width: Int = image.width
    override val height: Int = image.height
    override var rectangle: Rect = Rect(this.x, this.y, this.x+width, this.y+height)

    init{
        //test de col·lisions (temporal):
        /*rec.setBounds(this.x, this.y, this.x+width, this.y+height)
        rec.paint.color = Color.parseColor("#009944")
        rec.paint.color= Color.TRANSPARENT
        rec.paint.style= Paint.Style.STROKE
        rec.paint.color = Color.GREEN*/
    }

}