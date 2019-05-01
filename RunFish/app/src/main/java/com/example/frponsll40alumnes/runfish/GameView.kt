package com.example.frponsll40alumnes.runfish

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.example.frponsll40alumnes.runfish.npc.Plankton
import java.util.jar.Attributes

class GameView(context: Context) : SurfaceView(context), SurfaceHolder.Callback{

    //private var paint : Paint = Paint()
    private val thread: GameThread
    private var plankton: Plankton? = null

    init {

        // add callback
        holder.addCallback(this)

        // instantiate the game thread
        thread = GameThread(holder, this)
    }

    override fun surfaceDestroyed(p0: SurfaceHolder?) {
        var retry = true
        while (retry) {
            try {
                thread.setRunning(false)
                thread.join()
            } catch (e: Exception) {
                e.printStackTrace()
            }

            retry = false
        }
    }

    override fun surfaceCreated(p0: SurfaceHolder?) {
        plankton = Plankton(BitmapFactory.decodeResource(resources, R.drawable.placton))



        thread.setRunning(true)
        thread.start()
    }

    override fun surfaceChanged(p0: SurfaceHolder?, p1: Int, p2: Int, p3: Int) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Function to update the positions of player and game objects
     */
    fun update() {
        plankton!!.update()
    }

    /**
     * Everything that has to be drawn on Canvas
     */
    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        //if (holder.surface.isValid){
            /*
            canvas.drawColor(Color.argb(255,0,0,0))

            paint.color = Color.argb(255,0,255,0)
            //paint.color = Color.argb(255,255,255,255)
            paint.textSize = 70f
            canvas.drawText("dkjkdjktljdkljdkljkfdjtlkgjdkgj", 20f, 75f, paint)
*/

        plankton!!.draw(canvas)
        //}
    }

}