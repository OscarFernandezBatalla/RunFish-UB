package com.example.frponsll40alumnes.runfish.fish

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Rect
import com.example.frponsll40alumnes.runfish.R
import com.example.frponsll40alumnes.runfish.npc.NPC
import com.example.frponsll40alumnes.runfish.npc.Plankton


class CommonFish(context: Context) :
    Fish("Common Fish", 20, 0, "shield", 0, 20, 20) {

    var invencibilityForNFrames = 0

    init{
        this.image = BitmapFactory.decodeResource(context.resources, R.drawable.common_fish)
    }
    override val width: Int = image.width
    override val height: Int = image.height

    override var rectangle: Rect = Rect(this.x, this.y, this.x+width, this.y+height)

    override fun update(xJoy : Double, yJoy : Double, strength : Int) {
        super.update(xJoy, yJoy, strength)
        if(this.invencibilityForNFrames > 0){
            // decrease invencibility per frame
            this.invencibilityForNFrames--
        }
    }

    override fun collision(npc: NPC) {
        if(npc is Plankton){
            this.gainCapacity(npc.value)
        }
        else {
            // Si CommonFish no té activat el shield per aquest frame
            if(this.invencibilityForNFrames <= 0){
                this.loseLife(npc.value)
                // emite vibration in loseLife
            }
        }
    }
}