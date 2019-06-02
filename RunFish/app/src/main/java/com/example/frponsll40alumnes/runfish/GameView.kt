package com.example.frponsll40alumnes.runfish


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.support.constraint.ConstraintLayout
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import com.example.frponsll40alumnes.runfish.MVP.Presenter
import com.example.frponsll40alumnes.runfish.activityFragments.GameFragment
import com.example.frponsll40alumnes.runfish.fish.Fish
import com.example.frponsll40alumnes.runfish.npc.NPC
import io.github.controlwear.virtual.joystick.android.JoystickView
import kotlinx.android.synthetic.main.fragment_game.view.*
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin


class GameView(context: Context, var presenter: Presenter, var gameView: GameFragment) : SurfaceView(context), SurfaceHolder.Callback{
    val thread: GameThread
    private var planktonCollected : TextView? = null
    private var metersTravelled : TextView? = null
    private var imageButton_pause : ImageButton?= null
    private var button_resume: Button?=null
    private var constraintGameOver : ConstraintLayout? = null
    private var constraintSuccessfull : ConstraintLayout? = null
    private var paused : Boolean = false
    private var bar_life : ProgressBar? = null
    private var bar_capacity : ProgressBar? = null
    private var text_plankton : TextView? = null
    private var text_bonus : TextView? = null
    private var ability : Button? = null
    var angleRad : Double = 0.0
    var valy : Double = 0.0
    var valx : Double = 0.0
    var strength: Int = 0
    var condicioFreeMode = !this.presenter.getFreeMode()

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

        joystick = rootView.findViewById(R.id.joystickView) as JoystickView

        constraintGameOver = rootView.findViewById(R.id.game_over_layout)
        constraintSuccessfull = rootView.findViewById(R.id.successful_layout)

        text_bonus = rootView.findViewById(R.id.textView_bonus)
        imageButton_pause = rootView.findViewById(R.id.imageButton_pause)
        button_resume = rootView.findViewById(R.id.button_resume)
        planktonCollected = rootView.findViewById(R.id.textView_int_planctonCollected)
        metersTravelled = rootView.findViewById(R.id.textView_int_travelled_meters)

        bar_life = rootView.findViewById(R.id.life_bar)
        bar_capacity = rootView.findViewById(R.id.bar_capacity)
        text_plankton = rootView.findViewById(R.id.text_view_plankton)

        ability = rootView.findViewById(R.id.button_habilitat)

        loadAbilityImage()

        joystick!!.setOnMoveListener { angle, strength ->
            angleRad = angle * PI / 180
            valy= sin(angleRad)
            valx= cos(angleRad)
            this.strength = strength
        }

        //Use ability
        ability!!.setOnClickListener {
            ability!!.visibility = View.GONE
            android.os.Handler().postDelayed({
                ability!!.visibility = View.VISIBLE
            }, (presenter.useAbility() * 1000).toLong())
        }

        /* Posem la capacity si estem a levels o el plankton infinit si estem a freeMode */
        if(condicioFreeMode){
            bar_capacity!!.visibility = View.VISIBLE
        }else text_plankton!!.visibility = View.VISIBLE




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


        //setBonus()

        bar_life!!.progress = presenter.lifeBar()
        if(condicioFreeMode){
            bar_capacity!!.progress = presenter.capacityBar()
        }else text_plankton!!.text = presenter.getFreeModePlankton().toString()


        this.presenter.setMeters(presenter.getMeters())

        if(bar_life!!.progress <=0){

            this.thread.setRunning(false)
            //constraintGameOver!!.visibility = View.VISIBLE

            this.gameView.act!!.runOnUiThread( Runnable {
                constraintGameOver = rootView.findViewById(R.id.game_over_layout)
                constraintGameOver!!.visibility = View.VISIBLE
            })



            this.presenter.stopMusic()
            this.presenter.increaseDeath()

            this.presenter.setStatsToCloud()
        }
        var condicionMetres = presenter.getMeters() >= 0
        if(condicionMetres && condicioFreeMode){

            this.thread.setRunning(false)
            //constraintSuccessfull!!.visibility = View.VISIBLE

            this.gameView.act!!.runOnUiThread( Runnable {
                constraintSuccessfull = rootView.findViewById(R.id.successful_layout)
                constraintSuccessfull!!.visibility = View.VISIBLE
            })


            this.presenter.stopMusic()
            planktonCollected!!.text = presenter.getPlanktonCollected().toString()
            metersTravelled!!.text = presenter.getMetersLevel().toString()



            this.presenter.unlockNextLevel()
            this.presenter.setStatsToCloud()
        }
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        canvas.drawColor(Color.parseColor("#00fff2"))   //background
        this.presenter.getLevel().draw(canvas)

        val NPC: MutableList<NPC?>? = this.presenter.getNPC()
        val fish: Fish? = presenter.getFish()
        for(x in NPC!!){
            x!!.draw(canvas)

            //test de col·lisions (temporal):
            x.rec.draw(canvas)
        }
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

    fun setBonus(){
        if(this.presenter.getBonus()){
            //this.text_bonus!!.visibility = View.VISIBLE
            //this.text_bonus!!.bringToFront()
        }
        else{
            this.text_bonus!!.visibility = View.GONE
        }

    }
}