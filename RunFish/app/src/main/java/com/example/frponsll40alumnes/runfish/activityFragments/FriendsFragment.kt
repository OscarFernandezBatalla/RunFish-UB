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

        refreshFriendListView()

        imageButton_cross.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_friendsFragment_to_menuFragment))

        button_Invite.setOnClickListener {
            val posibleFriend = edit_text_username_invite.text.toString()
            addFriend(posibleFriend)
            edit_text_username_invite.setText("")
        }
    }

    private fun addFriend(friendName: String){
        act!!.presenter.addFriend(friendName)
    }

    fun getFriendList(): List<String>{
        return act!!.presenter.getFriendsList()
    }

    private fun refreshFriendListView(){
        val friendList = mutableListOf("Pepito","Pepe",null,null)  //TODO : MÀXIM 4
        text_friend0.text = friendList[0]
        text_friend1.text = friendList[1]
        text_friend2.text = friendList[2]
        text_friend3.text = friendList[3]

        //friendList ha de retornar el amic sencer y no una array

        if (friendList[0] != null) {
            image_ball_friend0.setImageResource(R.drawable.bola_verde)
        } else {
            image_ball_friend0.setImageResource(R.drawable.bola_gris)
        }

        if (friendList[1] != null) {
            image_ball_friend1.setImageResource(R.drawable.bola_verde)
        } else {
            image_ball_friend1.setImageResource(R.drawable.bola_gris)
        }

        if (friendList[2] != null) {
            image_ball_friend2.setImageResource(R.drawable.bola_verde)
        } else {
            image_ball_friend2.setImageResource(R.drawable.bola_gris)
        }

        if (friendList[3] != null) {
            image_ball_friend3.setImageResource(R.drawable.bola_verde)
        } else {
            image_ball_friend3.setImageResource(R.drawable.bola_gris)
        }
    }
}
