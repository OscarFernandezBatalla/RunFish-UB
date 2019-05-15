package com.example.frponsll40alumnes.runfish.npc

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
import com.example.frponsll40alumnes.runfish.R
import com.example.frponsll40alumnes.runfish.fish.Fish

class Bomb(context: Context, damage : Int): NPC(damage) {

    private val image : Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.mina)
    override var width: Int = image.width
    override var height: Int = image.height

    override var rectangle: Rect = Rect(this.x, this.y, this.x+width, this.y+height)


    /**
     * Draws the object on to the canvas.
     */
    /**
     * Draws the object on to the canvas.
     */
    override fun draw(canvas: Canvas) {
        canvas.drawBitmap(image, x.toFloat(), y.toFloat(), null)
    }

    /**
     * update properties for the game object
     */
    override fun update() {

        y+= (pes)
        this.rectangle = Rect(this.x, this.y, this.x+width, this.y+height)
    }

    override fun collision(playerFish: Fish?) {
        if(playerFish != null){
            //value es el nom de la variable que guarda dmg
            playerFish.loseLife(value)
        }
        super.collision(playerFish) // move offscreen
    }

}