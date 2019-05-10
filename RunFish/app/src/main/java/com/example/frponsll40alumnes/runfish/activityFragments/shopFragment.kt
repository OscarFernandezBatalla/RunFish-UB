package com.example.frponsll40alumnes.runfish.activityFragments


import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.R
import com.example.frponsll40alumnes.runfish.abilities.Ability
import kotlinx.android.synthetic.main.fragment_shop.*


class shopFragment : Fragment() {

    var act : MainActivity ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        act = (activity as MainActivity)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        uploadShopFragment()

        button_comeback_shop.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shopFragment_to_menuFragment))
    }



    private fun uploadShopFragment(){
        uploadCommonFish()
        uploadBlowFish()
        uploadClownFish()
        uploadSwordFish()
        uploadShark()
    }


    private fun uploadCommonFish() {

        var barsCommonFish : MutableList<Int> = act!!.presenter.uploadBarsCommonFish()

        this.life_bar_common_fish.progress = barsCommonFish[0]
        this.capactity_bar_common_fish.progress = barsCommonFish[1]
        this.speed_bar_common_fish.progress = barsCommonFish[2]

        this.text_preu_common_fish.text = act!!.presenter.uploadPriceCommonFish().toString()

        //this.button_ability_clownfish.background

        when (act!!.presenter.uploadAbilityFish()){
            Ability.SHIELD ->  this.button_ability_common_fish.background = ContextCompat.getDrawable(context!!, R.drawable.placton)

        }


    }

    private fun uploadBlowFish(){

        var barsBlowFish: MutableList<Int> = act!!.presenter.uploadBarsBlowFish()

        this.life_bar_blowfish.progress = barsBlowFish[0]
        this.capactity_bar_blowfish.progress = barsBlowFish[1]
        this.speed_bar_blowfish.progress = barsBlowFish[2]
    }

    private fun uploadClownFish(){

        var barsClownFish: MutableList<Int> = act!!.presenter.uploadBarsClownFish()

        this.life_bar_clownfish.progress = barsClownFish[0]
        this.capactity_bar_clownfish.progress = barsClownFish[1]
        this.speed_bar_clownfish.progress = barsClownFish[2]
    }

    private fun uploadSwordFish(){

        var barsSwordFish: MutableList<Int> = act!!.presenter.uploadBarsSwordFish()

        this.life_bar_swordfish.progress = barsSwordFish[0]
        this.capactity_bar_swordfish.progress = barsSwordFish[1]
        this.speed_bar_swordfish.progress = barsSwordFish[2]

    }

    private fun uploadShark(){

        var barsShark: MutableList<Int> = act!!.presenter.uploadBarsShark()

        this.life_bar_shark.progress = barsShark[0]
        this.capactity_bar_shark.progress = barsShark[1]
        this.speed_bar_shark.progress = barsShark[2]
    }



}
