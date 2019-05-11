package com.example.frponsll40alumnes.runfish.activityFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.MVP.Presenter
import com.example.frponsll40alumnes.runfish.R
import kotlinx.android.synthetic.main.fragment_stats.*

class statsFragment : Fragment() {

    var act : HomeActivity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        act = (activity as HomeActivity)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        uploadStats()
        act!!.signOut.visibility = View.VISIBLE


        button_comeback.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_statsFragment_to_menuFragment))
    }

    private fun uploadStats() {
        var stats : MutableList<Int> = act!!.presenter.uploadStats()

        this.text_view_int_total_fish.text = stats[0].toString()
        this.text_view_int_plankton.text = stats[1].toString()
        this.text_view_int_deaths.text = stats[2].toString()
        this.text_view_int_murdered_fish.text = stats[3].toString()
        this.text_view_int_max_dist.text = stats[4].toString()
    }

    /*PAS 4 EXEMPLE B*/
    /*EXEMPLE CARREGAR statNumberOfDeath AL FRAGMENT STATS*/

}
