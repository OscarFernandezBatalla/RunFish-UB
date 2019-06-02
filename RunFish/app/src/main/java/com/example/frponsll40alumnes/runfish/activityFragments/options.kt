package com.example.frponsll40alumnes.runfish.activityFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
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

        button_audio_music.setOnClickListener {
            this.seekBar_musica.progress = 0
            act!!.presenter.setMusic(0)
            act!!.setVolume(0)
        }

        switch_sounds.setOnCheckedChangeListener { _, isChecked ->
            act!!.presenter.setSounds(isChecked)
        }

        switch_vibration.setOnCheckedChangeListener { _, isChecked ->
            setVibrationState(isChecked)
        }

        seekBar_musica.max = this.act!!.getMaxVolume()
        seekBar_musica.progress = this.act!!.getCurrentVolume()


        seekBar_musica.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                act!!.presenter.setMusic(progress)
                act!!.setVolume(progress)
            }
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        uploadOptionsFragments()
    }

    private fun uploadOptionsFragments(){
        uploadMusicBar()
        uploadSoundBar()
        uploadVibrationSwitch()
    }

    private fun uploadMusicBar(){
        this.seekBar_musica.progress = act!!.presenter.uploadMusicBar()
    }

    private fun uploadSoundBar(){
        this.switch_sounds.isChecked = act!!.presenter.uploadSoundSwitch()
    }

    private fun uploadVibrationSwitch(){
        this.switch_vibration.isChecked = act!!.presenter.uploadVibrationSwitch()
    }

    private fun setVibrationState(activated : Boolean){
        act!!.presenter.setVibrationState(activated)
    }
}
