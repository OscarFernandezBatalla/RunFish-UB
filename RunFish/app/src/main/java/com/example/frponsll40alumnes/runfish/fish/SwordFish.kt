package com.example.frponsll40alumnes.runfish.fish

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import com.example.frponsll40alumnes.runfish.R

class SwordFish(context: Context) : Fish("SwordFish", 20,0,"speed", 1000, 20, 20){
    override var image = BitmapFactory.decodeResource(context.resources, R.drawable.sword_fish)
    override val width: Int = image.width
    override val height: Int = image.height
    override var rectangle: Rect = Rect(this.x, this.y, this.x+width, this.y+height)

    var speedIncreaseForNFrames = 0;
    var speedIncreaseActivated = false;
    var speedIncreaseFactor = 2

    init{
        //test de col·lisions (temporal):
        rec.setBounds(this.x, this.y, this.x+width, this.y+height)
        rec.paint.color = Color.parseColor("#009944")
        rec.paint.color= Color.TRANSPARENT
        rec.paint.style= Paint.Style.STROKE
        rec.paint.color = Color.GREEN
    }

    override fun update(xJoy : Double, yJoy : Double, strength : Int) {
        super.update(xJoy, yJoy, strength)
        if(this.speedIncreaseForNFrames > 0){
            // decrease speed boost per frame
            this.speedIncreaseForNFrames--
        }else{
            this.speed /= speedIncreaseFactor;
        }
    }

}
