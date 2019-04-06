package com.example.frponsll40alumnes.runfish.fragmentsAndActivites


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.R
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

        if (ReturnDirection == LevelDirection.SINGLEPLAYER) {
            button_comeback_singleplayer3.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_levelsFragment_to_singlePlayerFragment))
        } else if (ReturnDirection == LevelDirection.MULTIPLAYER) {
            button_comeback_singleplayer3.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_levelsFragment_to_multiplayerFragment))
        }

        button_tutorial.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_levelsFragment_to_gameFragment))
        button_level1.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_levelsFragment_to_gameFragment))
        button_level2.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_levelsFragment_to_gameFragment))
        button_level3.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_levelsFragment_to_gameFragment))
        button_level4.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_levelsFragment_to_gameFragment))
        button_level5.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_levelsFragment_to_gameFragment))
        button_level6.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_levelsFragment_to_gameFragment))
        button_level7.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_levelsFragment_to_gameFragment))
        button_level8.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_levelsFragment_to_gameFragment))
        button_level9.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_levelsFragment_to_gameFragment))
        button_level10.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_levelsFragment_to_gameFragment))

    }
}


