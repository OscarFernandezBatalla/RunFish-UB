package com.example.frponsll40alumnes.runfish.activityFragments


import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.FishType
import com.example.frponsll40alumnes.runfish.R
import com.example.frponsll40alumnes.runfish.abilities.Ability
import kotlinx.android.synthetic.main.fragment_shop.*


class shopFragment : Fragment() {

    var act : MainActivity ?= null
    var ownedFish : MutableList<Boolean>? = null

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
        ownedFish = act!!.presenter.uploadFishOwned()
        uploadCommonFish()
        uploadBlowFish()
        uploadClownFish()
        uploadSwordFish()
        uploadShark()
        uploadPlayerPlankton()
    }

    private fun uploadPlayerPlankton(){
        this.actual_plankton.text = act!!.presenter.uploadPlayerPlankton().toString()
    }


    fun getAbility(type: Ability): Drawable?{
        var image: Drawable? = null
        when (type){
            Ability.SHIELD ->  image = ContextCompat.getDrawable(context!!, R.drawable.shield)
            Ability.HEALTH -> image = ContextCompat.getDrawable(context!!,R.drawable.salud)
            Ability.BITE -> image = ContextCompat.getDrawable(context!!,R.drawable.shark_icon_dos)
            Ability.CAMOUFLAGE -> image = ContextCompat.getDrawable(context!!,R.drawable.camouflage_icon_dos)
            Ability.STRENGTH -> image = ContextCompat.getDrawable(context!!,R.drawable.fuerza)
        }
        return image
    }


    private fun uploadCommonFish() {

        var barsCommonFish : MutableList<Int> = act!!.presenter.uploadBarsCommonFish()

        this.life_bar_common_fish.progress = barsCommonFish[0]
        this.capactity_bar_common_fish.progress = barsCommonFish[1]
        this.speed_bar_common_fish.progress = barsCommonFish[2]

        this.text_preu_common_fish.text = act!!.presenter.uploadPriceCommonFish().toString()

        this.button_ability_common_fish.background = getAbility(act!!.presenter.uploadAbilityCommonFish())

        if(ownedFish!![0]){
            this.image_common_fish.setImageResource(R.drawable.pez_comun)
        }
    }


    private fun uploadClownFish(){

        var barsClownFish: MutableList<Int> = act!!.presenter.uploadBarsClownFish()

        this.life_bar_clownfish.progress = barsClownFish[0]
        this.capactity_bar_clownfish.progress = barsClownFish[1]
        this.speed_bar_clownfish.progress = barsClownFish[2]

        this.text_preu_clownfish.text = act!!.presenter.uploadPriceClownFish().toString()

        this.button_ability_clownfish.background = getAbility(act!!.presenter.uploadAbilityClownFish())

        if(ownedFish!![1]){
            this.image_clownfish.setImageResource(R.drawable.anemone)
        }
        else{
            this.image_clownfish.setImageResource(R.drawable.anemone_lock)
        }

    }

    private fun uploadBlowFish(){

        var barsBlowFish: MutableList<Int> = act!!.presenter.uploadBarsBlowFish()

        this.life_bar_blowfish.progress = barsBlowFish[0]
        this.capactity_bar_blowfish.progress = barsBlowFish[1]
        this.speed_bar_blowfish.progress = barsBlowFish[2]

        this.text_preu_blowfish.text = act!!.presenter.uploadPriceBlowFish().toString()

        this.button_ability_blowfish.background = getAbility(act!!.presenter.uploadAbilityBlowFish())

        if(ownedFish!![2]){
            this.image_blowfish.setImageResource(R.drawable.pez_globo)
        }
        else{
            this.image_blowfish.setImageResource(R.drawable.blowfish_lock)
        }
    }



    private fun uploadSwordFish(){

        var barsSwordFish: MutableList<Int> = act!!.presenter.uploadBarsSwordFish()

        this.life_bar_swordfish.progress = barsSwordFish[0]
        this.capactity_bar_swordfish.progress = barsSwordFish[1]
        this.speed_bar_swordfish.progress = barsSwordFish[2]

        this.text_preu_swordfish.text = act!!.presenter.uploadPriceSwordFish().toString()

        this.button_ability_swordfish.background = getAbility(act!!.presenter.uploadAbilitySwordFish())

        if(ownedFish!![3]){
            this.image_swordfish.setImageResource(R.drawable.pez_espada)
        }
        else{
            this.image_swordfish.setImageResource(R.drawable.swordfish_lock)
        }

    }

    private fun uploadShark(){

        var barsShark: MutableList<Int> = act!!.presenter.uploadBarsShark()

        this.life_bar_shark.progress = barsShark[0]
        this.capactity_bar_shark.progress = barsShark[1]
        this.speed_bar_shark.progress = barsShark[2]

        this.text_preu_shark.text = act!!.presenter.uploadPriceShark().toString()

        this.button_ability_shark.background = getAbility(act!!.presenter.uploadAbilityShark())

        if(ownedFish!![4]){
            this.image_shark.setImageResource(R.drawable.tiburon)
        }
        else{
            this.image_shark.setImageResource(R.drawable.shark_lock)
        }
    }



}
