package com.example.frponsll40alumnes.runfish.fish

import android.content.ContentValues.TAG
import android.content.Context
import android.graphics.*
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.util.Log
import com.example.frponsll40alumnes.runfish.R
import com.example.frponsll40alumnes.runfish.abilities.Health
import com.example.frponsll40alumnes.runfish.abilities.Speed

class SwordFish(context: Context, atributs : MutableList<Int>) :
    Fish(atributs[0], 0, Speed(), atributs[0], atributs[1]) {
    override var image = BitmapFactory.decodeResource(context.resources, R.drawable.sword_fish)!!
    override val width: Int = image.width
    override val height: Int = image.height
    override var rectangle: Rect = Rect(this.x, this.y, this.x+width, this.y+height)

    var speedIncreaseForNFrames = 0;
    var speedIncreaseActivated = false;
    var speedIncrease = 100


    override fun update(xJoy : Double, yJoy : Double, strength : Int) {
        if(this.speedIncreaseForNFrames > 0){
            // decrease speed boost per frame
            this.speedIncreaseForNFrames--
        }else{
            if(speedIncreaseActivated){
                this.speedIncreaseActivated = false;
                this.speed -= speedIncrease;
            }
        }
        super.update(xJoy, yJoy, strength)
    }

}
