package com.example.frponsll40alumnes.runfish


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
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
