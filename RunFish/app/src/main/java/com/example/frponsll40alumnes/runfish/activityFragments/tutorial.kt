package com.example.frponsll40alumnes.runfish.activityFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.frponsll40alumnes.runfish.R
import kotlinx.android.synthetic.main.fragment_tutorial.*


class tutorial : Fragment() {

    var contador: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tutorial, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_next_tutorial.setOnClickListener{
            contador++
        }
        actualitzarTutorial()
    }

    fun actualitzarTutorial(){
        if(contador == 0){ //description tutorial
            tutorialConstraint.visibility = View.VISIBLE
            enemiesConstraint.visibility = View.GONE
            planctonConstraint.visibility = View.GONE
        }
        else if(contador == 1){ //enemies tutorial
            tutorialConstraint.visibility = View.GONE
            enemiesConstraint.visibility = View.VISIBLE
            planctonConstraint.visibility = View.GONE
        }
        else if(contador == 2){ //plancton tutorial
            tutorialConstraint.visibility = View.GONE
            enemiesConstraint.visibility = View.GONE
            planctonConstraint.visibility = View.VISIBLE
        }
    }


}
