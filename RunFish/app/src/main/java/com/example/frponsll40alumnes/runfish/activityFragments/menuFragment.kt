package com.example.frponsll40alumnes.runfish.activityFragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.R
import kotlinx.android.synthetic.main.fragment_menu.*


class menuFragment : Fragment() {

    var act : MainActivity ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        act = (activity as MainActivity)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        uploadMenuFragment()

        button_singleplayer.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_menuFragment_to_singlePlayerFragment))
        button_multiplayer.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_menuFragment_to_multiplayerFragment))
        button_shop.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_menuFragment_to_shopFragment))
        button_stats.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_menuFragment_to_statsFragment))
        button_options.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_menuFragment_to_options))
        imageButton_friends.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_menuFragment_to_friendsFragment))
    }

    fun uploadMenuFragment(){
        uploadUsers()
    }

    fun uploadUsers(){
        this.text_view_users.text = act!!.presenter.uploadUsers().toString()
    }
}

