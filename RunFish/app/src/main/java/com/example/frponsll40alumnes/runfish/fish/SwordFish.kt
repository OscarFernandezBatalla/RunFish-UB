package com.example.frponsll40alumnes.runfish.fish

import android.content.ContentValues.TAG
import android.content.Context
import android.graphics.*
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.util.Log
import com.example.frponsll40alumnes.runfish.R
import com.example.frponsll40alumnes.runfish.abilities.Speed

class SwordFish(context: Context) : Fish("SwordFish", 125,0, Speed(), 1000, 125, 30){
    override var image = BitmapFactory.decodeResource(context.resources, R.drawable.sword_fish)
    override val width: Int = image.width
    override val height: Int = image.height
    override var rectangle: Rect = Rect(this.x, this.y, this.x+width, this.y+height)

    var speedIncreaseForNFrames = 0;
    var speedIncreaseActivated = false;
    var speedIncrease = 100

    init{
        //test de col·lisions (temporal):
        /*rec.setBounds(this.x, this.y, this.x+width, this.y+height)
        rec.paint.color = Color.parseColor("#009944")
        rec.paint.color= Color.TRANSPARENT
        rec.paint.style= Paint.Style.STROKE
        rec.paint.color = Color.GREEN*/
    }

    override fun update(xJoy : Double, yJoy : Double, strength : Int) {
        //Log.w(TAG, "QWE speed: ${this.speed}")
        if(this.speedIncreaseForNFrames > 0){
            // decrease speed boost per frame
            this.speedIncreaseForNFrames--
        }else{
            if(speedIncreaseActivated){
                this.speedIncreaseActivated = false;
                this.speed -= speedIncrease;
                Log.w(TAG, "QWE decreasing speed: ${this.speed}")
            }

        }
        super.update(xJoy, yJoy, strength)
    }

}
