package com.example.frponsll40alumnes.runfish.activityFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.R
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
//import com.google.android.gms.auth.api.signin.GoogleSignInOptionsCreator
import com.google.android.gms.common.api.GoogleApiClient
import kotlinx.android.synthetic.main.fragment_main.*






class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //button_enter.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_menuFragment))
        //button_SignIn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_signIn))


        //text_view_run.text = (activity as MainActivity).textFish




    }







}
