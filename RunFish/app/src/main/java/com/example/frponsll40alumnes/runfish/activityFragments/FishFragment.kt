package com.example.frponsll40alumnes.runfish.activityFragments


import android.graphics.drawable.Drawable
import android.opengl.Visibility
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.R
import com.example.frponsll40alumnes.runfish.abilities.Ability
import kotlinx.android.synthetic.main.fragment_fish.*



class FishFragment : Fragment() {

    var act : HomeActivity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        act = (activity as HomeActivity)
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

            var barsCommon = act!!.presenter.uploadBarsCommonFish()

            life_bar_selected_fish.progress = barsCommon[0]
            capactity_bar_selected_fish.progress = barsCommon[1]
            speed_bar_selected_fish.progress = barsCommon[2]

            button_ability_selected_fish.background = getAbility(act!!.presenter.uploadAbilityCommonFish())
        }

        button_clownfish.setOnClickListener {
            text_selected_fish.text =  "CLOWNFISH"

            var barsClown = act!!.presenter.uploadBarsClownFish()

            life_bar_selected_fish.progress = barsClown[0]
            capactity_bar_selected_fish.progress = barsClown[1]
            speed_bar_selected_fish.progress = barsClown[2]

            button_ability_selected_fish.background = getAbility(act!!.presenter.uploadAbilityClownFish())
        }


        button_shark.setOnClickListener {

            text_selected_fish.text =  "WHITE SHARK"

            var barsShark = act!!.presenter.uploadBarsShark()

            life_bar_selected_fish.progress =  barsShark[0]
            capactity_bar_selected_fish.progress = barsShark[1]
            speed_bar_selected_fish.progress = barsShark[2]

            button_ability_selected_fish.background = getAbility(act!!.presenter.uploadAbilityShark())
        }

        button_swordFish.setOnClickListener {

            text_selected_fish.text =  "SWORD FISH"

            var barsSword = act!!.presenter.uploadBarsSwordFish()

            life_bar_selected_fish.progress = barsSword[0]
            capactity_bar_selected_fish.progress =barsSword[1]
            speed_bar_selected_fish.progress =barsSword[2]

            button_ability_selected_fish.background = getAbility(act!!.presenter.uploadAbilitySwordFish())
        }

        button_blowFish.setOnClickListener {

            text_selected_fish.text =  "BLOW SHARK"

            var barsBlow = act!!.presenter.uploadBarsBlowFish()

            life_bar_selected_fish.progress = barsBlow[0]
            capactity_bar_selected_fish.progress =barsBlow[1]
            speed_bar_selected_fish.progress =barsBlow[2]

            button_ability_selected_fish.background = getAbility(act!!.presenter.uploadAbilityBlowFish())
        }
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

    fun getAbility(type: Ability): Drawable?{
        return when (type){
            Ability.SHIELD -> ContextCompat.getDrawable(context!!, R.drawable.shield)
            Ability.HEALTH -> ContextCompat.getDrawable(context!!,R.drawable.salud)
            Ability.BITE -> ContextCompat.getDrawable(context!!,R.drawable.shark_icon_dos)
            Ability.CAMOUFLAGE -> ContextCompat.getDrawable(context!!,R.drawable.camouflage)
            Ability.STRENGTH -> ContextCompat.getDrawable(context!!,R.drawable.strength)
        }
    }



}
