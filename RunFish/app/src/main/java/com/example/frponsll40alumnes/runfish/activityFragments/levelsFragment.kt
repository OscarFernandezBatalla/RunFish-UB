package com.example.frponsll40alumnes.runfish.activityFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.R
import kotlinx.android.synthetic.main.fragment_levels.*


class levelsFragment : Fragment() {

    var act : HomeActivity ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        act = (activity as HomeActivity)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_levels, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Els posem tots a false per no poder accedir a tots els nivells
        //Només podrem accedir si estan desbloquejats

        //Posem un tablon bloquejat quan no els tinguem
        button_level2.isEnabled = false
        button_level2.setBackgroundResource(R.drawable.tablon_block)
        button_level3.isEnabled = false
        button_level3.setBackgroundResource(R.drawable.tablon_block)
        button_level4.isEnabled = false
        button_level4.setBackgroundResource(R.drawable.tablon_block)
        button_level5.isEnabled = false
        button_level5.setBackgroundResource(R.drawable.tablon_block)
        button_level6.isEnabled = false
        button_level6.setBackgroundResource(R.drawable.tablon_block)
        button_level7.isEnabled = false
        button_level7.setBackgroundResource(R.drawable.tablon_block)
        button_level8.isEnabled = false
        button_level8.setBackgroundResource(R.drawable.tablon_block)
        button_level9.isEnabled = false
        button_level9.setBackgroundResource(R.drawable.tablon_block)
        button_level10.isEnabled = false
        button_level10.setBackgroundResource(R.drawable.tablon_block)



        uploadLevelsFragment()

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

    fun uploadLevelsFragment(){
        var numLevels: Int = act!!.presenter.uploadLevels()
        for(i in 2..numLevels){
            when(numLevels){
                2 -> {
                    button_level2.isEnabled = true
                    button_level2.setBackgroundResource(R.drawable.new_tablon)
                }
                3 -> {
                    button_level3.isEnabled = true
                    button_level3.setBackgroundResource(R.drawable.new_tablon)
                }
                4 -> {
                    button_level4.isEnabled = true
                    button_level4.setBackgroundResource(R.drawable.new_tablon)
                }
                5 -> {
                    button_level5.isEnabled = true
                    button_level5.setBackgroundResource(R.drawable.new_tablon)
                }
                6 -> {
                    button_level6.isEnabled = true
                    button_level6.setBackgroundResource(R.drawable.new_tablon)
                }
                7 -> {
                    button_level7.isEnabled = true
                    button_level7.setBackgroundResource(R.drawable.new_tablon)
                }
                8 -> {
                    button_level8.isEnabled = true
                    button_level8.setBackgroundResource(R.drawable.new_tablon)
                }
                9 -> {
                    button_level9.isEnabled = true
                    button_level9.setBackgroundResource(R.drawable.new_tablon)
                }
                10 -> {
                    button_level10.isEnabled = true
                    button_level10.setBackgroundResource(R.drawable.new_tablon)
                }



            }
        }
    }
}


