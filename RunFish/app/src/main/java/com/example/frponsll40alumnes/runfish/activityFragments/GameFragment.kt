package com.example.frponsll40alumnes.runfish.activityFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.FishType
import com.example.frponsll40alumnes.runfish.GameView
import com.example.frponsll40alumnes.runfish.Player
import com.example.frponsll40alumnes.runfish.R
import io.github.controlwear.virtual.joystick.android.JoystickView
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {

    var act : HomeActivity? = null
    private lateinit var gameView : GameView
    lateinit var game : FrameLayout
    private lateinit var gameWidgets: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        act = (activity as HomeActivity)
        game = FrameLayout(this.context!!)
        gameView = GameView(this.context!!, act!!.presenter, this)
        gameWidgets = LinearLayout(context)
        game.addView(gameView)
        game.addView(gameWidgets)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        act!!.signOut.visibility = View.GONE
        val rootView = inflater.inflate(R.layout.fragment_game, container, false)
        game.addView(rootView)
        act!!.presenter.startGame(Player(act!!.presenter.getCurrentFish()),context = this.gameView.context)
        return game
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_restart.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_gameFragment_self))

        imageButton_pause.setOnClickListener{
            pause_fragment.visibility = View.VISIBLE
            gameView.setPause(true)
        }

        button_resume.setOnClickListener {
            pause_fragment.visibility = View.GONE
            gameView.setPause(false)
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
        //button_next_level.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_gameFragment_self))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this.act!!.presenter.stopMusic()
    }
}
