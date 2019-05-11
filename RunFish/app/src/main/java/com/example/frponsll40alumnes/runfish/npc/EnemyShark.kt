package com.example.frponsll40alumnes.runfish.npc

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.drawable.GradientDrawable
import com.example.frponsll40alumnes.runfish.Movable
import com.example.frponsll40alumnes.runfish.R
import com.example.frponsll40alumnes.runfish.fish.Fish

class EnemyShark(context: Context, speed : Int, var vertical: Boolean, var leftToRight: Boolean) : NPC(speed),
    Movable {

    override var speed: Int = this.value

    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeight = Resources.getSystem().displayMetrics.heightPixels
    private val image : Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.shark_top)

    override var width: Int = image.width
    override var height: Int = image.height

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
        /*if (vertical){
            y+= speed
        }
*/
        y+= speed
/*
        else{
            /*
            if (leftToRight){
                x-= speed
            }*/
            //else{
                x+= speed
            //}
        }*/
    }

    override fun collision(playerFish: Fish?) {
        if(playerFish != null){
            //value es el nom de la variable que guarda dmg
            playerFish.looseLife(value);
        }
        super.collision(playerFish); // move offscreen
    }


}