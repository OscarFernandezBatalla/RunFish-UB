package com.example.frponsll40alumnes.runfish.activityFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.R
import kotlinx.android.synthetic.main.fragment_friends.*
import kotlinx.android.synthetic.main.fragment_game.*


class FriendsFragment : Fragment() {

    //var hola : String = "hola"
    var act : MainActivity ?= null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        act = (activity as MainActivity)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_friends, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //uploadFriendsFragment()

        imageButton_cross.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_friendsFragment_to_menuFragment))

        button_Invite.setOnClickListener {
            edit_text_username_invite.setText("")
        }
    }

    /*fun uploadFriendsFragment(){
    }
    */
   /* fun getBar() : Int{
        return bar_capacity.progress
    }*/

}
