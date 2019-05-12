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

    var act : HomeActivity ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        act = (activity as HomeActivity)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_friends, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        act!!.signOut.visibility = View.GONE

        //uploadFriendsFragment()

        imageButton_cross.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_friendsFragment_to_menuFragment))

        button_Invite.setOnClickListener {
            //var posibleFriend = edit_text_username_invite.text.toString()
            //addFriend(posibleFriend)
            edit_text_username_invite.setText("")
        }
    }

    fun addFriend(friendName: String){
        act!!.presenter.addFriend(friendName)
    }

    /*fun uploadFriendsFragment(){
    }
    */
   /* fun getBar() : Int{
        return bar_capacity.progress
    }*/

}
