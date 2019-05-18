package com.example.frponsll40alumnes.runfish.activityFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.FishType
import com.example.frponsll40alumnes.runfish.GameView
import com.example.frponsll40alumnes.runfish.Player
import com.example.frponsll40alumnes.runfish.R
import io.github.controlwear.virtual.joystick.android.JoystickView
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {

    var act : HomeActivity? = null
    //lateinit var joystick : JoystickView
    private lateinit var gameView : GameView
    lateinit var game : FrameLayout
    private lateinit var gameWidgets: LinearLayout

    var posX : Int = 0
    var posY : Int = 0

//    lateinit var text_y : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //act!!.signOut.visibility = View.GONE
        act = (activity as HomeActivity)
        game = FrameLayout(this.context!!)
        gameView = GameView(this.context!!, act!!.presenter)
        gameWidgets = LinearLayout(context)
        game.addView(gameView)
        game.addView(gameWidgets)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        //TODO: MIRAR MULTIPLAYER i crear persontatge en el presenter i no aquí.

        act!!.signOut.visibility = View.GONE

        val rootView = inflater.inflate(R.layout.fragment_game, container, false)
        game.addView(rootView)
        act!!.presenter.startGame(Player(act!!.presenter.getCurrentFish()),context = this.gameView.context)

        return game
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageButton_pause.setOnClickListener(){
            pause_fragment.bringToFront()
            pause_fragment.visibility=View.VISIBLE
            //gameView.thread.setRunning(false)
        }

        button_restart.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_gameFragment_self))

        button_resume.setOnClickListener(){
            pause_fragment.visibility=View.GONE
        }
        button_exit.setOnClickListener(){
            pause_fragment.visibility=View.GONE
        }

        button_exit.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_gameFragment_to_menuFragment))

        button_gameOver.setOnClickListener(){
            game_over_layout.bringToFront()
            game_over_layout.visibility=View.VISIBLE
        }

        button_successful.setOnClickListener(){
            successful_layout.bringToFront()
            successful_layout.visibility=View.VISIBLE
        }

        button_retry.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_gameFragment_self))

        
        button_back.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_gameFragment_to_menuFragment))

        button_back_successful.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_gameFragment_to_menuFragment))

        button_next_level.setOnClickListener(){
            //successful_layout.visibility=View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this.act!!.presenter.stopMusic()
    }
}
