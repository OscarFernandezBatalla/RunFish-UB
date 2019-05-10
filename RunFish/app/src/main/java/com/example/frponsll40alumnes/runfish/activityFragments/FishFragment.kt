package com.example.frponsll40alumnes.runfish.activityFragments


import android.opengl.Visibility
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.R
import kotlinx.android.synthetic.main.fragment_fish.*



class FishFragment : Fragment() {

    var act : MainActivity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        act = (activity as MainActivity)
        return inflater.inflate(R.layout.fragment_fish, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_common_fish.visibility = View.GONE
        button_clownfish.visibility = View.GONE
        button_blowFish.visibility = View.GONE
        button_swordFish.visibility = View.GONE
        button_shark.visibility = View.GONE

        uploadFishOwned()


        if (ReturnDirection == LevelDirection.SINGLEPLAYER) {
            button_comeback.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_fishFragment_to_singlePlayerFragment))
        } else if (ReturnDirection == LevelDirection.MULTIPLAYER) {
            button_comeback.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_fishFragment_to_multiplayerFragment))
        }

        button_common_fish.setOnClickListener {
            text_selected_fish.text =  "COMMON FISH"
            life_bar_selected_fish.progress = 30
            capactity_bar_selected_fish.progress = 20
            speed_bar_selected_fish.progress = 30
            button_ability_selected_fish.setBackgroundResource(R.drawable.shield)
        }

        button_clownfish.setOnClickListener {
            text_selected_fish.text =  "CLOWNFISH"
            life_bar_selected_fish.progress = 40
            capactity_bar_selected_fish.progress = 30
            speed_bar_selected_fish.progress = 30
            button_ability_selected_fish.setBackgroundResource(R.drawable.salud)
        }


        button_shark.setOnClickListener {

            text_selected_fish.text =  "WHITE SHARK"
            life_bar_selected_fish.progress = 100
            capactity_bar_selected_fish.progress = 75
            speed_bar_selected_fish.progress = 80
            button_ability_selected_fish.setBackgroundResource(R.drawable.shark_icon_dos)
        }

        button_swordFish.setOnClickListener {

            text_selected_fish.text =  "SWORD FISH"
            life_bar_selected_fish.progress = 100
            capactity_bar_selected_fish.progress = 75
            speed_bar_selected_fish.progress = 80
            button_ability_selected_fish.setBackgroundResource(R.drawable.shark_icon_dos)
        }

        button_blowFish.setOnClickListener {

            text_selected_fish.text =  "BLOW SHARK"
            life_bar_selected_fish.progress = 100
            capactity_bar_selected_fish.progress = 75
            speed_bar_selected_fish.progress = 80
            button_ability_selected_fish.setBackgroundResource(R.drawable.shark_icon_dos)
        }





        //this.text_selected_fish.text = (activity as MainActivity).textFish

        

    }

    private fun uploadFishOwned() {
        var fishOwned = act!!.presenter.uploadFishOwned()

        if (fishOwned[0]){
            button_common_fish.visibility = View.VISIBLE
        }
        if (fishOwned[1]){
            button_clownfish.visibility = View.VISIBLE
        }
        if (fishOwned[2]){
            button_blowFish.visibility = View.VISIBLE
        }
        if (fishOwned[3]){
            button_swordFish.visibility = View.VISIBLE
        }
        if (fishOwned[4]){
            button_shark.visibility = View.VISIBLE
        }

    }
}
