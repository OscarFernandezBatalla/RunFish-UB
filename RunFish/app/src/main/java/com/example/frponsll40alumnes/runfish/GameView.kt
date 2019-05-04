package com.example.frponsll40alumnes.runfish

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.Button
import android.widget.ImageButton
import com.example.frponsll40alumnes.runfish.fish.Anemone
import com.example.frponsll40alumnes.runfish.fish.Fish
import com.example.frponsll40alumnes.runfish.npc.EnemyShark
import com.example.frponsll40alumnes.runfish.npc.Plankton
import io.github.controlwear.virtual.joystick.android.JoystickView
import kotlinx.android.synthetic.main.fragment_test.view.*
import java.util.jar.Attributes

class GameView(context: Context) : SurfaceView(context), SurfaceHolder.Callback{

    private val thread: GameThread
    private var plankton: Plankton? = null
    private var shark : EnemyShark?= null
    private var button : Button?=  null
    private var fish : Fish ?= null
   //private var button: ImageButton? = null

   // private var joystick: JoystickView? = null

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
        shark = EnemyShark(BitmapFactory.decodeResource(resources, R.drawable.shark_top))
        fish = Anemone(BitmapFactory.decodeResource(resources, R.drawable.anemone))


        //button = findViewById(R.id.buttton)

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
        shark!!.update()
        fish!!.update()
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


        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.fondo_marino),0f,0f,null)
        plankton!!.draw(canvas)
        shark!!.draw(canvas)
        fish!!.draw(canvas)
        //buttton!!.draw(canvas)


        //setBackgroundResource(R.drawable.fondo_marino)
        //}
    }

}