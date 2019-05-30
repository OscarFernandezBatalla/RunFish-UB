package com.example.frponsll40alumnes.runfish.activityFragments


import android.content.ContentValues.TAG
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.Game
import com.example.frponsll40alumnes.runfish.R
import kotlinx.android.synthetic.main.fragment_single_player.*

import com.example.frponsll40alumnes.runfish.GameModes


class SinglePlayerFragment : Fragment() {

    var act : HomeActivity? = null
    var bundle : Bundle? = null;

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
        button_resume_singleplayer.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_singlePlayerFragment_to_gameFragment)
            /*View.OnClickListener {
                bundle = Bundle();
                bundle!!.putSerializable("game_mode", GameModes.GAME_MODE_FINITE);
                Log.w(TAG, "QWE navigation");
                Navigation.createNavigateOnClickListener(R.id.action_singlePlayerFragment_to_gameFragment, bundle);
            }*/
        )
        button_levels.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_singlePlayerFragment_to_levelsFragment))

        /* aquest boto no es multiplayer, porta a la fish store */
        button_fish_multiplayer.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_singlePlayerFragment_to_fishFragment)
            /*View.OnClickListener {
                bundle = Bundle();
                bundle!!.putSerializable("game_mode", GameModes.GAME_MODE_MULTIPLAYER);
                Navigation.createNavigateOnClickListener(R.id.action_singlePlayerFragment_to_fishFragment, bundle)
            }*/
        )

        button_freemode_singleplayer.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_singlePlayerFragment_to_gameFragment)
            /*View.OnClickListener {
                bundle = Bundle();
                bundle!!.putSerializable("game_mode",GameModes.GAME_MODE_FREE);
                Log.w(TAG, "QWE navigation");
                Navigation.createNavigateOnClickListener(R.id.action_singlePlayerFragment_to_gameFragment, bundle);
            }*/
        )

        button_comeback.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_singlePlayerFragment_to_menuFragment))
    }
}
