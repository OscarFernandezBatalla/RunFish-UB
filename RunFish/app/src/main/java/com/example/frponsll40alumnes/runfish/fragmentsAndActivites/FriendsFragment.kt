package com.example.frponsll40alumnes.runfish.fragmentsAndActivites


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.R
import kotlinx.android.synthetic.main.fragment_friends.*



class FriendsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_friends, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageButton_cross.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_friendsFragment_to_menuFragment))

        button_Invite.setOnClickListener {
            edit_text_username_invite.setText("")
        }

    }
}
