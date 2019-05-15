package com.example.frponsll40alumnes.runfish.npc

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.example.frponsll40alumnes.runfish.R
import com.example.frponsll40alumnes.runfish.fish.Fish
import kotlinx.android.synthetic.main.fragment_game.view.*

class Plankton(context: Context, points : Int): NPC(points) {


    private val image : Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.placton)

    override var width: Int = image.width
    override var height: Int = image.height

    override var rectangle: Rect = Rect(this.x, this.y, this.x+width, this.y+height)

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
            //el peix recull el Plankton e incrementa la càrrega
            playerFish.gainCapacity(value);
        }
        super.collision(playerFish); // move offscreen
    }


}