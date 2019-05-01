package com.example.frponsll40alumnes.runfish.activityFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.GameView
import com.example.frponsll40alumnes.runfish.R
import io.github.controlwear.virtual.joystick.android.JoystickView
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {

    lateinit var joystick : JoystickView
    lateinit var gameView : GameView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {


        gameView = GameView(this.context!!)
        activity!!.setContentView(gameView)

        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_game, container, false)
        joystick = rootView.findViewById(R.id.joystickView) as JoystickView

        return rootView

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        joystick.setOnMoveListener { angle, strength ->
            // aqui fer coses
        }

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
