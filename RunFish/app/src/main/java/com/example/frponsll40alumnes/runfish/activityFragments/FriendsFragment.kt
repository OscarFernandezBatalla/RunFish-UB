package com.example.frponsll40alumnes.runfish.activityFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.R
import kotlinx.android.synthetic.main.fragment_friends.*
import kotlinx.android.synthetic.main.fragment_game.*



class FriendsFragment : Fragment() {

    var act : HomeActivity ?= null
    var usernameFriendView: MutableList<TextView> ?= null
    var imatgeBallView: MutableList<ImageView> ?= null


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

        usernameFriendView = mutableListOf(text_friend0, text_friend1, text_friend2, text_friend3)
        imatgeBallView = mutableListOf(image_ball_friend0, image_ball_friend1, image_ball_friend2, image_ball_friend3)
        refreshFriendListView()

        imageButton_cross.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_friendsFragment_to_menuFragment))

        button_Invite.setOnClickListener {
            val posibleFriend = edit_text_username_invite.text.toString()
            addFriend(posibleFriend)
            refreshFriendListView()
            edit_text_username_invite.setText("")
        }
    }

    private fun addFriend(friendName: String){
        act!!.presenter.addFriend(friendName)
    }

    fun getFriendList(): MutableList<String>{
        return act!!.presenter.getFriendsList()
    }


    fun refreshFriendListView(){
        var friendList = getFriendList()
        if(friendList.size == 0){
            for(i in 0 until usernameFriendView!!.size){
                usernameFriendView!![i].visibility = View.GONE
                imatgeBallView!![i].visibility = View.GONE
            }
        }
        else{
            for (i in 0 until friendList.size) {
                usernameFriendView!![i].visibility = View.VISIBLE
                usernameFriendView!![i].text = friendList[i]
                imatgeBallView!![i].visibility = View.VISIBLE
            }
        }
    }
}
