package com.example.frponsll40alumnes.runfish.npc

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.example.frponsll40alumnes.runfish.R
import kotlinx.android.synthetic.main.fragment_game.view.*

class Plankton(var image: Bitmap): NPC(value = 20, x = 200, y = 200) {


    private var xVelocity = 20
    private var yVelocity = 20
    private val screenWidth = Resources.getSystem().displayMetrics.widthPixels
    private val screenHeight = Resources.getSystem().displayMetrics.heightPixels

    init {

        var height = image.height
        var width = image.width

        y=3000
        x = screenWidth/2
    }

    /**
     * Draws the object on to the canvas.
     */
    fun draw(canvas: Canvas) {
        canvas.drawBitmap(image, x.toFloat(), y.toFloat(), null)
    }

    /**
     * update properties for the game object
     */
    fun update() {
        // val randomNum = ThreadLocalRandom.current().nextInt(1, 5)
/*

        if (x > screenWidth - image.width || x < image.width) {
            xVelocity = xVelocity * -1
        }
        if (y > screenHeight - image.height || y < image.height) {
            yVelocity = yVelocity * -1
        }

        x += (xVelocity)
        y += (yVelocity)
*/


        y-= (xVelocity)


    }

    override fun changePosition() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}