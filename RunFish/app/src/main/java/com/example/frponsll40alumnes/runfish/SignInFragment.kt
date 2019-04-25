package com.example.frponsll40alumnes.runfish

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_sign_in.*


class SignInFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_comeback.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_signInFragment_to_mainFragment))
        button_sign_in.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_signInFragment_to_mainFragment))
    }

}
