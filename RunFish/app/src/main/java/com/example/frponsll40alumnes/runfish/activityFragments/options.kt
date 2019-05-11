package com.example.frponsll40alumnes.runfish.activityFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.R
import kotlinx.android.synthetic.main.fragment_options.*

class Options : Fragment() {

    //var pres = (activity as MainActivity).presenter
    var act : HomeActivity ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        act = (activity as HomeActivity)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_options, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        act!!.signOut.visibility = View.VISIBLE

        uploadOptionsFragments()

        button_comeback_options.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_options_to_menuFragment))
        //button_logOut.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_options_to_mainFragment))
        button_audio_music.setOnClickListener {
            this.seekBar_musica.progress = 0
        }

        button_audio_music.setOnClickListener {
            this.seekBar_sounds.progress = 0
        }
    }


    fun uploadOptionsFragments(){
        uploadMusicBar()
        uploadSoundBar()
        uploadVibrationSwitch()
    }

    fun uploadMusicBar(){
        //this.text_view_int_deaths.text = statNumberOfDeath.toString()
        this.seekBar_musica.progress = act!!.presenter.uploadMusicBar()
    }

    fun uploadSoundBar(){
        //this.text_view_int_deaths.text = statNumberOfDeath.toString()
        this.seekBar_sounds.progress = act!!.presenter.uploadSoundBar()
    }

    fun uploadVibrationSwitch(){
        this.switch_vibration.isChecked = act!!.presenter.uploadVibrationSwitch()
    }
}
