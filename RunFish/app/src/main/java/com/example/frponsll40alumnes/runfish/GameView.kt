package com.example.frponsll40alumnes.runfish


import android.content.Context
import android.graphics.Canvas

import android.support.constraint.ConstraintLayout
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import android.widget.Button

import android.widget.ProgressBar
import android.widget.TextView
import com.example.frponsll40alumnes.runfish.fish.Fish
import com.example.frponsll40alumnes.runfish.npc.EnemyShark
import com.example.frponsll40alumnes.runfish.npc.Plankton

import io.github.controlwear.virtual.joystick.android.JoystickView
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

    private var constraint : ConstraintLayout? = null

    private var bar_life : ProgressBar? = null
    private var bar_capacity : ProgressBar? = null

    private var ability : Button? = null
    
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
        // Crear joystick virtual
        constraint = rootView.findViewById(R.id.game_over_layout)
        joystick = rootView.findViewById(R.id.joystickView) as JoystickView
        textX = rootView.findViewById(R.id.valuex)
        textY = rootView.findViewById(R.id.valuey)

        bar_life = rootView.findViewById(R.id.life_bar)
        bar_capacity = rootView.findViewById(R.id.bar_capacity)

        ability = rootView.findViewById(R.id.button_habilitat)

        joystick!!.setOnMoveListener { angle, strength ->
            angleRad = angle * PI / 180
            valy= sin(angleRad)
            valx= cos(angleRad)
            this.strength = strength

            textX!!.text= "coordenada X:   $valx   strength: $strength"
            textY!!.text= "coordenada Y:   $valy   angle: $angle"
        }

        ability!!.setOnClickListener {
            ability!!.visibility = View.GONE
            gameEngine.life += 20
            android.os.Handler().postDelayed({
                ability!!.visibility = View.VISIBLE
            }, 8000)
        }

        gameEngine = GameEngine(Player(FishType.ANEMONE),context = this.context)
        gameEngine.startGame()

        thread.setRunning(true)
        thread.start()
    }

    override fun surfaceChanged(p0: SurfaceHolder?, p1: Int, p2: Int, p3: Int) {

    }

    fun update() {

        gameEngine.getJoystickInf(valx, valy, strength)
        gameEngine.updateView()

        bar_life!!.progress = gameEngine.life
        bar_capacity!!.progress = gameEngine.capacity


        if(bar_life!!.progress <=0){
            this.thread.setRunning(false)
            constraint!!.visibility = View.VISIBLE
        }


        /*

        if(gameEngine.gameOver){
            //gameEngine.numberOfDeaths++
            this.thread.setRunning(false)
            constraint!!.visibility = View.VISIBLE
        }

        */


    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        gameEngine.drawView(canvas)
    }


}