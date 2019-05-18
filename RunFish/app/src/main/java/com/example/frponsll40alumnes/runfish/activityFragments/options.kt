package com.example.frponsll40alumnes.runfish.activityFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.R
import kotlinx.android.synthetic.main.fragment_options.*

class Options : Fragment() {

    var act : HomeActivity ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        act = (activity as HomeActivity)
        act!!.signOut.visibility = View.VISIBLE
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

        switch_vibration.setOnCheckedChangeListener { _, isChecked ->
            setVibrationState(isChecked)
        }

    }


    private fun uploadOptionsFragments(){
        uploadMusicBar()
        uploadSoundBar()
        uploadVibrationSwitch()
    }

    private fun uploadMusicBar(){
        //this.text_view_int_deaths.text = statNumberOfDeath.toString()
        this.seekBar_musica.progress = act!!.presenter.uploadMusicBar()
    }

    private fun uploadSoundBar(){
        //this.text_view_int_deaths.text = statNumberOfDeath.toString()
        this.seekBar_sounds.progress = act!!.presenter.uploadSoundBar()
    }

    private fun uploadVibrationSwitch(){
        this.switch_vibration.isChecked = act!!.presenter.uploadVibrationSwitch()
    }

    private fun setVibrationState(activated : Boolean){
        act!!.presenter.setVibrationState(activated)
    }
}
