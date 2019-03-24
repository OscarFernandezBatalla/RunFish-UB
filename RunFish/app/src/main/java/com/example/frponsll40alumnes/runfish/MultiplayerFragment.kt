package com.example.frponsll40alumnes.runfish


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_multiplayer.*


class MultiplayerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_multiplayer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        ReturnLevelDirection = LevelDirection.MULTIPLAYER
        super.onViewCreated(view, savedInstanceState)
        button_fish_multiplayer.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_multiplayerFragment_to_fishFragment))
        button_levels.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_multiplayerFragment_to_levelsFragment))
        button_comeback.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_multiplayerFragment_to_menuFragment))
        button_go.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_multiplayerFragment_to_gameFragment))
        button_invite.setOnClickListener{
            fragment_invite.bringToFront()
            fragment_invite.visibility=View.VISIBLE
        }

        // Amaga el constraint de INVITAR:

        button_friend.setOnClickListener {
            fragment_invite.visibility=View.GONE
        }
        button_friend1.setOnClickListener {
            fragment_invite.visibility=View.GONE
        }
        button_friend2.setOnClickListener {
            fragment_invite.visibility=View.GONE
        }
        button_friend3.setOnClickListener {
            fragment_invite.visibility=View.GONE
        }

        button_cross.setOnClickListener {
            fragment_invite.visibility=View.GONE
        }

        button_receive_invitation.setOnClickListener {
            constaint_receive_invitation.bringToFront()
            constaint_receive_invitation.visibility=View.VISIBLE
        }

        button_accept_invitation.setOnClickListener {
            fragment_invite.visibility=View.GONE
            constaint_receive_invitation.visibility=View.GONE

        }

        button_reject_invitation.setOnClickListener {
            constaint_receive_invitation.visibility=View.GONE
        }

    }
}
