package com.example.frponsll40alumnes.runfish.npc

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.graphics.drawable.shapes.Shape
import com.example.frponsll40alumnes.runfish.Movable
import com.example.frponsll40alumnes.runfish.R
import com.example.frponsll40alumnes.runfish.fish.Fish

class EnemyShark(context: Context, speed : Int, var vertical: Boolean, var leftToRight: Boolean) : NPC(speed),
    Movable {

    override var speed: Int = this.value

    private var image : Bitmap? = null

    override var width: Int = 0
    override var height: Int = 0

    override var rectangle: Rect = Rect()

    init {
        image = if (vertical){
            BitmapFactory.decodeResource(context.resources, R.drawable.shark_top_v)
        } else{
            if (leftToRight){
                BitmapFactory.decodeResource(context.resources, R.drawable.shark_top_h_r)
            } else{
                BitmapFactory.decodeResource(context.resources, R.drawable.shark_top_h_l)
            }
        }

        width = image!!.width
        height = image!!.height

        rectangle.set(this.x+95, this.y+75, this.x+width-125, this.y+height)

        //test de col·lisions (temporal):
        /*rec.setBounds(this.x+95, this.y+75, this.x+width-125, this.y+height)
        rec.paint.color = Color.parseColor("#009944")
        rec.paint.color=Color.TRANSPARENT
        rec.paint.style=Paint.Style.STROKE
        rec.paint.color = Color.RED*/
    }



    fun changeOrientation(vertical : Boolean){
        this.vertical = vertical
    }

    fun changeDirection(leftToRight : Boolean){
        this.leftToRight = leftToRight
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
        if (vertical){
            y+= speed
        }

        else{
            if (leftToRight){
                x+= speed
            }
            else{
                x-= speed
            }
        }
        this.rectangle.set(this.x+95, this.y+75, this.x+width-125, this.y+height)
        //test de col·lisions (temporal):
        //rec.setBounds(this.x+95, this.y+75, this.x+width-125, this.y+height)
    }

    override fun collision(playerFish: Fish?) {
        playerFish?.loseLife(value)
        super.collision(playerFish) // move offscreen
    }


}