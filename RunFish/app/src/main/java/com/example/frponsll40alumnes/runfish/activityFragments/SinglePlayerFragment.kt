package com.example.frponsll40alumnes.runfish.activityFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.R
import kotlinx.android.synthetic.main.fragment_single_player.*


class SinglePlayerFragment : Fragment() {

    var act : HomeActivity? = null
    var lastLevel : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        act = (activity as HomeActivity)
        return inflater.inflate(R.layout.fragment_single_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        act!!.signOut.visibility = View.GONE

        ReturnDirection =
            LevelDirection.SINGLEPLAYER
        super.onViewCreated(view, savedInstanceState)
        button_resume_singleplayer.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_singlePlayerFragment_to_gameFragment))
        button_levels.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_singlePlayerFragment_to_levelsFragment))
        button_fish_multiplayer.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_singlePlayerFragment_to_fishFragment))
        button_freemode_singleplayer.isEnabled = false
        button_freemode_singleplayer.setBackgroundResource(R.drawable.tablon_block)
        if(act!!.presenter.getLevelsUnlocked() == 10){
            button_freemode_singleplayer.isEnabled = true
            button_freemode_singleplayer.setBackgroundResource(R.drawable.new_tablon)
        }
        button_freemode_singleplayer.setOnClickListener {
            constraint_freeMode.visibility = View.VISIBLE
            this.lastLevel = this.act!!.presenter.getActualLevel()
            this.act!!.presenter.freeModeON()

        }
        button_cancel.setOnClickListener{
            constraint_freeMode.visibility = View.GONE
            this.act!!.presenter.setActualLevel(lastLevel)

        }
        button_go.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_singlePlayerFragment_to_gameFragment))
        button_comeback.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_singlePlayerFragment_to_menuFragment))
    }
}
