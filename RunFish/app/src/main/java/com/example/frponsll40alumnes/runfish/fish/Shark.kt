package com.example.frponsll40alumnes.runfish.fish

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import com.example.frponsll40alumnes.runfish.R
import com.example.frponsll40alumnes.runfish.abilities.Bite
import com.example.frponsll40alumnes.runfish.abilities.Health
import com.example.frponsll40alumnes.runfish.npc.NPC
import com.example.frponsll40alumnes.runfish.npc.Plankton

class Shark(context: Context, atributs : MutableList<Int>) :
    Fish(atributs[0], 0, Bite(), atributs[0], atributs[1]) {
    override var image = BitmapFactory.decodeResource(context.resources, R.drawable.shark)
    override val width: Int = image.width
    override val height: Int = image.height
    override var rectangle: Rect = Rect(this.x, this.y, this.x+width, this.y+height)

    var biteFrame = 0;
    var biteActivated = false;
    var collisionScaled = false;
    val biteLength = 100;

    init{
        //test de col·lisions (temporal):
        /*rec.setBounds(this.x, this.y, this.x+width, this.y+height)
        rec.paint.color = Color.parseColor("#009944")
        rec.paint.color= Color.TRANSPARENT
        rec.paint.style= Paint.Style.STROKE
        rec.paint.color = Color.GREEN*/
    }

    override fun update(xJoy : Double, yJoy : Double, strength : Int) {
        super.update(xJoy, yJoy, strength)
        if(this.biteFrame > 0){
            this.biteFrame--
        }else{
            if(this.biteActivated)
                this.biteActivated = false;
        }
        if(this.biteFrame <= 0 && this.biteActivated && this.collisionScaled){
            this.rectangle = Rect(this.x, this.y, this.x+width, this.y+height)
            this.collisionScaled = false;
        }else if(this.biteFrame >= 0 && this.biteActivated && !(this.collisionScaled)){
            this.rectangle = Rect(this.x, this.y, this.x+width, this.y+height+this.biteLength)
            this.collisionScaled = true;
        }
    }
/*
    override fun collision(npc: NPC) {
        if(npc is Plankton){
            this.gainCapacity(npc.value)
        }
        else {
            // Si CommonFish no té activat el shield per aquest frame
            if(this.biteActivated){
                npc.die()
                // emite vibration in loseLife
            }else{
                this.loseLife(npc.value)
            }
        }
    }*/

    override fun loseLife(value: Int) {
        if(!(this.biteActivated))
            super.loseLife(value)
    }
}

