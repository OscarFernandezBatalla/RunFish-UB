package com.example.frponsll40alumnes.runfish.activityFragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.R
import kotlinx.android.synthetic.main.fragment_menu.*

class menuFragment : Fragment() {

    var act : HomeActivity ?= null                //    aixo feia que petes
    //var userChecked: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Use ability
        act = (activity as HomeActivity)
        act!!.signOut.visibility = View.GONE

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if(!act!!.userChecked){
            android.os.Handler().postDelayed({

                if(act!!.presenter.getUsername() == ""){
                    imageView_commonFishh.visibility = View.GONE
                    imageView_nemo.visibility = View.GONE
                    imageView_shark.visibility = View.GONE
                    text_view_loading.visibility = View.GONE
                    welcome_username.visibility = View.VISIBLE
                    button_user_petition.setOnClickListener{
                        act!!.hideNav()
                        var username = edit_text_username.text.toString()
                        if(username != ""){    //TODO: COMPROVAR QUE L'USERNAME NO EXISTEIX...
                            act!!.presenter.setUsername(username)
                            welcome_username.visibility = View.GONE
                            menu_layout.visibility = View.VISIBLE
                        }
                        else{
                            Toast.makeText(this.context,"Unvalid username",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                else{
                    imageView_commonFishh.visibility = View.GONE
                    imageView_nemo.visibility = View.GONE
                    imageView_shark.visibility = View.GONE
                    text_view_loading.visibility = View.GONE
                    welcome_username.visibility = View.GONE
                    menu_layout.visibility = View.VISIBLE
                }
                act!!.userChecked = true
            }, 7000)
        }
        else{
            imageView_commonFishh.visibility = View.GONE
            imageView_nemo.visibility = View.GONE
            imageView_shark.visibility = View.GONE
            text_view_loading.visibility = View.GONE
            menu_layout.visibility = View.VISIBLE
        }
        uploadMenuFragment()
        button_singleplayer.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_menuFragment_to_singlePlayerFragment))
        button_multiplayer.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_menuFragment_to_multiplayerFragment))
        button_shop.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_menuFragment_to_shopFragment))
        button_stats.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_menuFragment_to_statsFragment))
        button_options.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_menuFragment_to_options))
        imageButton_friends.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_menuFragment_to_friendsFragment))

    }

    /*fun addUserId(){
        this.act!!.presenter.addUserId()
    }*/

    private fun uploadMenuFragment(){
        uploadFriends()
    }

    private fun uploadFriends(){
        this.text_view_users.text = act!!.presenter.uploadFriends().toString()
    }
}