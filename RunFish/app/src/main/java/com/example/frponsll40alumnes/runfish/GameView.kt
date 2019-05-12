package com.example.frponsll40alumnes.runfish

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.constraint.ConstraintLayout
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import com.example.frponsll40alumnes.runfish.fish.Anemone
import com.example.frponsll40alumnes.runfish.fish.Fish
import com.example.frponsll40alumnes.runfish.npc.EnemyShark
import com.example.frponsll40alumnes.runfish.npc.Plankton
import com.google.api.Distribution
import io.github.controlwear.virtual.joystick.android.JoystickView
import kotlinx.android.synthetic.main.fragment_game.view.*

import java.util.jar.Attributes
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

class GameView(context: Context) : SurfaceView(context), SurfaceHolder.Callback{

    private val thread: GameThread
    private var plankton: Plankton? = null
    private var shark : EnemyShark?= null
    private var fish : Fish ?= null
    private var textX: TextView? = null
    private var textY: TextView? = null

    private var meters: TextView? = null



    /*
     Prova 1: Posar variables Joystick com a globals
     */
    var angleRad : Double = 0.0
    var valy : Double = 0.0
    var valx : Double = 0.0
    var strength: Int = 0

    lateinit var gameEngine: GameEngine

    private var joystick: JoystickView? = null

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


        /*

        LA CLAVE ES EL ROOTVIEW.

         */
        // Crear joystick virtual
        joystick = rootView.findViewById(R.id.joystickView) as JoystickView
        textX = rootView.findViewById(R.id.valuex)
        textY = rootView.findViewById(R.id.valuey)

        joystick!!.setOnMoveListener { angle, strength ->

            //var angleRad = angle * PI / 180

            //var valy= sin(angleRad)
            //var valx= cos(angleRad)
            angleRad = angle * PI / 180
            valy= sin(angleRad)
            valx= cos(angleRad)
            this.strength = strength

            textX!!.text = "coordenada X:   $valx   strength: $strength"
            textY!!.text = "coordenada Y:   $valy   angle: $angle"

            //fish!!.update((valx*40).toInt(), -(valy*40).toInt())
            //fish!!.update((valx*strength/3).toInt(), -(valy*strength/3).toInt())

        }



        /* TODO: PROVA 2, INTENTAR USAR GAME ENGINE
        plankton = Plankton(BitmapFactory.decodeResource(resources, R.drawable.placton))
        shark = EnemyShark(BitmapFactory.decodeResource(resources, R.drawable.shark_top))
        fish = Anemone(BitmapFactory.decodeResource(resources, R.drawable.anemone_reduced))
*/
        gameEngine = GameEngine(Player(FishType.ANEMONE),context = this.context)
        gameEngine.startGame()

        meters = rootView.findViewById(R.id.textView_meters)

        //joystick = findViewById(R.id.joystickView)

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
    //@SuppressLint("SetTextI18n")
    fun update() {


        gameEngine.getJoystickInf(valx, valy, strength)
        gameEngine.updateView()

        meters!!.text = (gameEngine.getMeters()-5).toString()


        /* PROVA 3
        //TODO : Aquí crec que hauriem de fer un gameEngine.update() el qual actualitzarà tot com a engine.
        plankton!!.update()
        shark!!.update()
        fish!!.update((valx*strength/3).toInt(), -(valy*strength/3).toInt())
        //fish!!.update(3)
        //fish!!.update(joystick!!.normalizedX)
        //textX!!.text="hola"
           */
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


        //canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.fondo_marino),0f,0f,null)

        gameEngine.drawView(canvas)




/* PROVA 4
        //TODO: TOT AIXÒ HA D'ANAR AL GAME ENGINE
        plankton!!.draw(canvas)
        shark!!.draw(canvas)
        fish!!.draw(canvas)
        //textX!!.text="hola2"

*/

        //textX!!.text = "hola"
        //textY!!.text = joystick!!.normalizedY.toString()
        //buttton!!.draw(canvas)


        //setBackgroundResource(R.drawable.fondo_marino)
        //}
    }

}