package com.example.frponsll40alumnes.runfish.npc

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.graphics.drawable.Drawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.widget.ImageView
import com.example.frponsll40alumnes.runfish.R
import com.example.frponsll40alumnes.runfish.fish.Fish
import kotlinx.android.synthetic.main.fragment_game.view.*

class Plankton(context: Context, points : Int): NPC(points) {


    private val image : Bitmap = changePlanktonImage(points,context)



    override var width: Int = image.width
    override var height: Int = image.height

    override var rectangle: Rect = Rect(this.x, this.y, this.x+width, this.y+height)


    init {
        //test de col·lisions (temporal):
        /*rec.setBounds(this.x, this.y, this.x+width, this.y+height)
        rec.paint.color = Color.parseColor("#009944")
        rec.paint.color=Color.TRANSPARENT
        rec.paint.style=Paint.Style.STROKE
        rec.paint.color = Color.RED*/
    }


    fun changePlanktonImage(points: Int, context: Context): Bitmap{
        return when(points){
            1 -> BitmapFactory.decodeResource(context.resources, R.drawable.plankton_one)
            2 -> BitmapFactory.decodeResource(context.resources, R.drawable.plankton_two)
            3 -> BitmapFactory.decodeResource(context.resources, R.drawable.plankton_three)
            4 -> BitmapFactory.decodeResource(context.resources, R.drawable.plankton_four)
            5 -> BitmapFactory.decodeResource(context.resources, R.drawable.plankton_five)
            else -> BitmapFactory.decodeResource(context.resources, R.drawable.placton)
        }

    }
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
        this.rectangle.set(this.x, this.y, this.x+width, this.y+height)
        //test de col·lisions (temporal):
        //rec.setBounds(this.x, this.y, this.x+width, this.y+height)
    }
/*

    override fun collision(playerFish: Fish?) {
        if(playerFish != null){
            //el peix recull el Plankton e incrementa la càrrega
            playerFish.gainCapacity(value);
        }
        super.collision(playerFish); // move offscreen
    }
*/


}