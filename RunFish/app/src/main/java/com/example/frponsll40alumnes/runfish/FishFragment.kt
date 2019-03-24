package com.example.frponsll40alumnes.runfish


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_fish.*


class FishFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fish, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        /*button_blowfish.setOnClickListener {
            text_selected_fish.text =  "BLOWFISH"
            life_bar_selected_fish.progress = 45
            capactity_bar_selected_fish.progress = 50
            speed_bar_selected_fish.progress = 20
            button_ability_selected_fish.setBackgroundResource(R.drawable.fuerza)
        }*/


        button_shark.setOnClickListener {

            text_selected_fish.text =  "WHITE SHARK"
            life_bar_selected_fish.progress = 100
            capactity_bar_selected_fish.progress = 75
            speed_bar_selected_fish.progress = 80
            button_ability_selected_fish.setBackgroundResource(R.drawable.shark_icon_dos)
        }

        button_comeback.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_fishFragment_to_singlePlayerFragment))

/*
        button_ability_selected_fish.setOnClickListener(){

            //val toast1 = Toast.makeText(this@FishFragment, "Prueba ASF", Toast.LENGTH_SHORT).show()
            Toast.makeText(activity, "Its toast!", Toast.LENGTH_SHORT).show()
        }
        */
    button_ability_selected_fish.setOnTouchListener { _, _ ->
            //TODO : PREGUNTAR COM FER QUE ES VEGI UN FRAGMENT ÚNICAMENT QUAN ESTIGUI APRETANT EL BOTÓ (PER MOSTRAR L'HABILITAT DEL PEIX)
            true
            }
    }
}
