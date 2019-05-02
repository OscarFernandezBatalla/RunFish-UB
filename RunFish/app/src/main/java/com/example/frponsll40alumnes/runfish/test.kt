package com.example.frponsll40alumnes.runfish

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_test.*


class test : Fragment() {
    // TODO: Rename and change types of parameters

    lateinit var gameView : GameView
    lateinit var game : FrameLayout
    lateinit var gameWidgets: LinearLayout
    lateinit var pauseButtonn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //gameView = GameView(this.context!!)
        game = FrameLayout(this.context)
        gameView = GameView(this.context!!)
        gameWidgets = LinearLayout(context)

        pauseButtonn = Button(context)
        pauseButtonn.width=300
        pauseButtonn.text="hola"

        gameWidgets.addView(pauseButtonn)

        game.addView(gameView)
        game.addView(gameWidgets)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment

        return game
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //buttton.bringToFront()
    }




    }
