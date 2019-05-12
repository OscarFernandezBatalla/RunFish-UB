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

    //lateinit var joystick : JoystickView
    lateinit var gameView : GameView
    lateinit var game : FrameLayout
    lateinit var gameWidgets: LinearLayout
    var act : HomeActivity ?= null

    var posX : Int = 0
    var posY : Int = 0

//    lateinit var text_y : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //act!!.signOut.visibility = View.GONE
        act = (activity as HomeActivity)
        game = FrameLayout(this.context)
        gameView = GameView(this.context!!,act!!.presenter)
        gameWidgets = LinearLayout(context)
        game.addView(gameView)
        game.addView(gameWidgets)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_game, container, false)
        game.addView(rootView)
        //Mirar de ferho amb multiplayer
        act!!.presenter.startGame(Player(FishType.ANEMONE),context = this.gameView.context)
        return game
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageButton_pause.setOnClickListener(){
            pause_fragment.bringToFront()
            pause_fragment.visibility=View.VISIBLE
        }

        button_restart.setOnClickListener(){
            pause_fragment.visibility=View.GONE
        }
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

        button_retry.setOnClickListener(){
            game_over_layout.visibility=View.GONE
        }

        button_back.setOnClickListener(){
            game_over_layout.visibility=View.GONE
        }

        button_back_successful.setOnClickListener(){
           successful_layout.visibility=View.GONE
        }

        button_next_level.setOnClickListener(){
            successful_layout.visibility=View.GONE
        }
    }
}
