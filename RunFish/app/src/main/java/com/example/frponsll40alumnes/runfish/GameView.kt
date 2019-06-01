package com.example.frponsll40alumnes.runfish


import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color

import android.support.constraint.ConstraintLayout
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import android.widget.Button
import android.widget.ImageButton

import android.widget.ProgressBar
import android.widget.TextView
import com.example.frponsll40alumnes.runfish.MVP.Presenter
import com.example.frponsll40alumnes.runfish.fish.Fish
import com.example.frponsll40alumnes.runfish.npc.EnemyShark
import com.example.frponsll40alumnes.runfish.npc.NPC
import com.example.frponsll40alumnes.runfish.npc.Plankton

import io.github.controlwear.virtual.joystick.android.JoystickView
import kotlinx.android.synthetic.main.fragment_game.view.*
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin


class GameView(context: Context, var presenter: Presenter) : SurfaceView(context), SurfaceHolder.Callback{

    //private var meters : TextView? = null
    var num = 0
    val thread: GameThread
    private var plankton: Plankton? = null
    private var shark : EnemyShark?= null
    private var fish : Fish ?= null
    private var textX: TextView? = null
    private var textY: TextView? = null
    private var planktonCollected : TextView? = null
    private var imageButton_pause : ImageButton?= null
    private var button_resume: Button?=null
    //private var textMeters : TextView? = null

    private var constraint : ConstraintLayout? = null

    private var paused : Boolean = false

    private var bar_life : ProgressBar? = null
    private var bar_capacity : ProgressBar? = null

    private var ability : Button? = null

    
    var angleRad : Double = 0.0
    var valy : Double = 0.0
    var valx : Double = 0.0
    var strength: Int = 0

    //lateinit var gameEngine: GameEngine

    private var joystick: JoystickView? = null

    init {
        // add callback
        holder.addCallback(this)

        // instantiate the game thread
        thread = GameThread(holder, this)
        //presenter.startGame(Player(FishType.ANEMONE),context = context)
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

        //constraint = rootView.findViewById(R.id.game_over_layout)
        joystick = rootView.findViewById(R.id.joystickView) as JoystickView
        //meters = rootView.findViewById(R.id.textView_meters)
        textX = rootView.findViewById(R.id.valuex)
        textY = rootView.findViewById(R.id.valuey)

        imageButton_pause = rootView.findViewById(R.id.imageButton_pause)
        button_resume = rootView.findViewById(R.id.button_resume)
        //textMeters = rootView.findViewById(R.id.textView_metersMap)
        //textMeters!!.text= "àkjfsdklgn"

        planktonCollected = rootView.findViewById(R.id.textView_int_planctonCollected)

        bar_life = rootView.findViewById(R.id.life_bar)
        bar_capacity = rootView.findViewById(R.id.bar_capacity)

        ability = rootView.findViewById(R.id.button_habilitat)

        loadAbilityImage()

        joystick!!.setOnMoveListener { angle, strength ->
            angleRad = angle * PI / 180
            valy= sin(angleRad)
            valx= cos(angleRad)
            this.strength = strength

            textX!!.text= ""//"coordenada X:   $valx   strength: $strength"
            textY!!.text= ""//"coordenada Y:   $valy   angle: $angle"
        }

        //Use ability
        ability!!.setOnClickListener {

            ability!!.visibility = View.GONE
            //presenter.useAbility()//gameEngine.life += 20
            /*android.os.Handler().postDelayed({
                ability!!.visibility = View.VISIBLE
            }, 8000)*/
            android.os.Handler().postDelayed({
                ability!!.visibility = View.VISIBLE
            }, (presenter.useAbility() * 1000).toLong())
        }

        thread.setRunning(true)
        thread.start()

    }

    private fun loadAbilityImage() {
        val fish = this.presenter.getCurrentFish()
        when(fish){
            FishType.COMMONFISH -> this.ability!!.setBackgroundResource(R.drawable.shield)
            FishType.ANEMONE -> this.ability!!.setBackgroundResource(R.drawable.salud)
            FishType.BLOWFISH -> this.ability!!.setBackgroundResource(R.drawable.strength_hd)
            FishType.SWORDFISH -> this.ability!!.setBackgroundResource(R.drawable.thunderbolt)
            FishType.SHARK -> this.ability!!.setBackgroundResource(R.drawable.shark_icon_dos)
        }
    }

    override fun surfaceChanged(p0: SurfaceHolder?, p1: Int, p2: Int, p3: Int) {}

    fun update() {
        presenter.updateJoystickInf(valx,valy,strength)
        presenter.updateView()

        bar_life!!.progress = presenter.lifeBar()
        bar_capacity!!.progress = presenter.capacityBar()

        this.presenter.setMeters(presenter.getMeters())

        if(bar_life!!.progress <=0){
            this.thread.setRunning(false)
            Log.w(TAG, "QWE You died")
            this.presenter.stopMusic()
            this.presenter.increaseDeath()
            //constraint = rootView.findViewById(R.id.game_over_layout)
            //constraint!!.visibility = View.VISIBLE
            //if(constraint!!.visibility == View.VISIBLE) {
            //    Log.w(TAG, "QWE fragment is visible")
            //}
            this.presenter.setStatsToCloud()
        }
        if(presenter.getMeters() >= 0){
            Log.w(TAG, "QWE You win")
            this.thread.setRunning(false)
            this.presenter.stopMusic()
            planktonCollected!!.text = presenter.getPlanktonCollected().toString()
            /*constraint = rootView.findViewById(R.id.successful_layout)
            //TODO: no es mostra successful layout
            constraint!!.visibility = View.VISIBLE

            if(constraint!!.visibility == View.VISIBLE) {
                Log.w(TAG, "QWE fragment is visible")
            }*/
            this.presenter.unlockNextLevel()
            this.presenter.setStatsToCloud()
        }
    }


    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        canvas.drawColor(Color.parseColor("#00fff2"))   //background
        this.presenter.getLevel().draw(canvas)

        val NPC: MutableList<NPC?>? = this.presenter.getNPC()
        //val map: Map? = presenter.getMap()
        val fish: Fish? = presenter.getFish()

        //map!!.draw(canvas)

        for(x in NPC!!){
            x!!.draw(canvas)

            //test de col·lisions (temporal):
            x.rec.draw(canvas)
        }
        //canvas.drawText("Metres",20f,64f, paint)
        fish!!.draw(canvas)


        //test de col·lisions (temporal):
        fish.rec.draw(canvas)
    }

    fun getPause() : Boolean{
        return this.paused
    }

    fun setPause(paused: Boolean) {
        this.paused = paused
    }


}