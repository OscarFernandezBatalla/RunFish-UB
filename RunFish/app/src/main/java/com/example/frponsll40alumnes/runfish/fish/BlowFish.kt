package com.example.frponsll40alumnes.runfish.fish

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import com.example.frponsll40alumnes.runfish.R
import com.example.frponsll40alumnes.runfish.npc.NPC
import com.example.frponsll40alumnes.runfish.npc.Plankton


class BlowFish(context: Context) :
    Fish("BlowFish", 20, 0, "shield", 2000, 20, 20) {

    override var image = BitmapFactory.decodeResource(context.resources, R.drawable.blow_fish)
    override val width: Int = image.width
    override val height: Int = image.height
    override var rectangle: Rect = Rect(this.x, this.y, this.x+width, this.y+height)

    var damageReductionForNFrames = 0;

    val damageReduction = 15;
    var damageReductionActivated = false;

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
        if(this.damageReductionForNFrames > 0){
            // decrease speed boost per frame
            this.damageReductionForNFrames--
        }else{
            if(damageReductionActivated){
                damageReductionActivated = false;
            }
        }
    }

    override fun collision(npc : NPC){
        if(npc is Plankton){
            this.gainCapacity(npc.value)
        }
        else {
            if(this.damageReductionActivated){
                this.loseLife(npc.value - this.damageReduction)
            }else {
                this.loseLife(npc.value)
            }
            // emite vibration in loseLife
        }
    }

}
