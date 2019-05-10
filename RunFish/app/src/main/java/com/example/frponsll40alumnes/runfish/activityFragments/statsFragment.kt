package com.example.frponsll40alumnes.runfish.activityFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.R
import kotlinx.android.synthetic.main.fragment_stats.*

class statsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateStatNumberofDeathOnView()

        button_comeback.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_statsFragment_to_menuFragment))
    }

    /*PAS 4 EXEMPLE B*/
    /*EXEMPLE CARREGAR statNumberOfDeath AL FRAGMENT STATS*/

    fun updateStatNumberofDeathOnView(){
        //this.text_view_int_deaths.text = statNumberOfDeath.toString()
        this.text_view_int_deaths.text = (activity as MainActivity).presenter.carregarStatNumberDeath().toString()

    }
}
