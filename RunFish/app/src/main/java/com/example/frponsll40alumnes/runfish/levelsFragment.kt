package com.example.frponsll40alumnes.runfish


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_levels.*


class levelsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_levels, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        button_tutorial.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_levelsFragment_to_gameFragment))

        if(ReturnLevelDirection == LevelDirection.SINGLEPLAYER){
            button_comeback_singleplayer3.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_levelsFragment_to_singlePlayerFragment))
        }
        else if(ReturnLevelDirection == LevelDirection.MULTIPLAYER)
            button_comeback_singleplayer3.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_levelsFragment_to_multiplayerFragment))
        }

    }


