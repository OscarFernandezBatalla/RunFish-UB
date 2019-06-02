package com.example.frponsll40alumnes.runfish.activityFragments


import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.frponsll40alumnes.runfish.FishType
import com.example.frponsll40alumnes.runfish.R
import com.example.frponsll40alumnes.runfish.fish.Fish
import kotlinx.android.synthetic.main.fragment_levels.*
import com.example.frponsll40alumnes.runfish.Difficulty.DifficultyType


class LevelsFragment : Fragment(){

    var act : HomeActivity ?= null
    //private var constraint : ConstraintLayout ?= null
    var numLevel : Int = 0
    private var accept : Button ?= null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        act = (activity as HomeActivity)
        act!!.signOut.visibility = View.GONE

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_levels, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        //Els posem tots a false per no poder accedir a tots els nivells
        //Només podrem accedir si estan desbloquejats

        //Posem un tablon bloquejat quan no els tinguem
        button_level2.isEnabled = false
        button_level2.setBackgroundResource(R.drawable.tablon_block)
        button_level3.isEnabled = false
        button_level3.setBackgroundResource(R.drawable.tablon_block)
        button_level4.isEnabled = false
        button_level4.setBackgroundResource(R.drawable.tablon_block)
        button_level5.isEnabled = false
        button_level5.setBackgroundResource(R.drawable.tablon_block)
        button_level6.isEnabled = false
        button_level6.setBackgroundResource(R.drawable.tablon_block)
        button_level7.isEnabled = false
        button_level7.setBackgroundResource(R.drawable.tablon_block)
        button_level8.isEnabled = false
        button_level8.setBackgroundResource(R.drawable.tablon_block)
        button_level9.isEnabled = false
        button_level9.setBackgroundResource(R.drawable.tablon_block)
        button_level10.isEnabled = false
        button_level10.setBackgroundResource(R.drawable.tablon_block)

        uploadLevelsFragment()

        button_tutorial.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_levelsFragment_to_gameFragment))

        if (ReturnDirection == LevelDirection.SINGLEPLAYER) {
            button_comeback_singleplayer3.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_levelsFragment_to_singlePlayerFragment))
        } else if (ReturnDirection == LevelDirection.MULTIPLAYER) {
            button_comeback_singleplayer3.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_levelsFragment_to_multiplayerFragment))
        }


        button_acceptar.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_levelsFragment_to_gameFragment))

        button_cancelarLevel.setOnClickListener {
            constraint_confirm_level.visibility = View.GONE
        }

        button_tutorial.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_levelsFragment_to_tutorial))

        button_level1.setOnClickListener {
            numLevel = 1
            act!!.presenter.setActualLevel(numLevel)
            updateActualLevelFrag()
            constraint_confirm_level.visibility = View.VISIBLE
        }
        button_level2.setOnClickListener {
            numLevel = 2
            act!!.presenter.setActualLevel(numLevel)
            updateActualLevelFrag()
            constraint_confirm_level.visibility = View.VISIBLE
        }
        button_level3.setOnClickListener {
            numLevel = 3
            act!!.presenter.setActualLevel(numLevel)
            updateActualLevelFrag()
            constraint_confirm_level.visibility = View.VISIBLE
        }
        button_level4.setOnClickListener {
            numLevel = 4
            act!!.presenter.setActualLevel(numLevel)
            updateActualLevelFrag()
            constraint_confirm_level.visibility = View.VISIBLE
        }
        button_level5.setOnClickListener {
            numLevel = 5
            act!!.presenter.setActualLevel(numLevel)
            updateActualLevelFrag()
            constraint_confirm_level.visibility = View.VISIBLE
        }
        button_level6.setOnClickListener {
            numLevel = 6
            act!!.presenter.setActualLevel(numLevel)
            updateActualLevelFrag()
            constraint_confirm_level.visibility = View.VISIBLE
        }
        button_level7.setOnClickListener {
            numLevel = 7
            act!!.presenter.setActualLevel(numLevel)
            updateActualLevelFrag()
            constraint_confirm_level.visibility = View.VISIBLE
        }
        button_level8.setOnClickListener {
            numLevel = 8
            act!!.presenter.setActualLevel(numLevel)
            updateActualLevelFrag()
            constraint_confirm_level.visibility = View.VISIBLE
        }
        button_level9.setOnClickListener {
            numLevel = 9
            act!!.presenter.setActualLevel(numLevel)
            updateActualLevelFrag()
            constraint_confirm_level.visibility = View.VISIBLE
        }
        button_level10.setOnClickListener {
            numLevel = 10
            act!!.presenter.setActualLevel(numLevel)
            updateActualLevelFrag()
            constraint_confirm_level.visibility = View.VISIBLE
        }
    }

    private fun updateActualLevelFrag(){
        textView_numLevel.text = "Level $numLevel"
        imageView_actualFish.background = getFishImage()
        /* S'ha de treure de Engine?*/
        var levelContext: MutableList<Int> = act!!.presenter.getLevelContext()
        textView_numPlancton.text = levelContext[0].toString()
        textView_numBomb.text = levelContext[1].toString()
        textView_numShark.text = levelContext[2].toString()
        var meters: Int = levelContext[3]
        textView_levelMeters.text = "Meters: $meters M"

    }

    private fun getFishImage(): Drawable?{
        var type: FishType = act!!.presenter.getCurrentFish()
        return when (type){
            FishType.COMMONFISH -> ContextCompat.getDrawable(context!!, R.drawable.common_fish_shop)
            FishType.BLOWFISH -> ContextCompat.getDrawable(context!!,R.drawable.blow_fish_shop)
            FishType.ANEMONE -> ContextCompat.getDrawable(context!!,R.drawable.anemone)
            FishType.SWORDFISH -> ContextCompat.getDrawable(context!!,R.drawable.sword_fish_shop)
            FishType.SHARK -> ContextCompat.getDrawable(context!!,R.drawable.shark)
        }
    }



    fun uploadLevelsFragment(){
        val numLevels: Int = act!!.presenter.uploadLevels()
        for(i in 2..numLevels){
            when(i){
                2 -> {
                    button_level2.isEnabled = true
                    button_level2.setBackgroundResource(R.drawable.new_tablon)
                }
                3 -> {
                    button_level3.isEnabled = true
                    button_level3.setBackgroundResource(R.drawable.new_tablon)
                }
                4 -> {
                    button_level4.isEnabled = true
                    button_level4.setBackgroundResource(R.drawable.new_tablon)
                }
                5 -> {
                    button_level5.isEnabled = true
                    button_level5.setBackgroundResource(R.drawable.new_tablon)
                }
                6 -> {
                    button_level6.isEnabled = true
                    button_level6.setBackgroundResource(R.drawable.new_tablon)
                }
                7 -> {
                    button_level7.isEnabled = true
                    button_level7.setBackgroundResource(R.drawable.new_tablon)
                }
                8 -> {
                    button_level8.isEnabled = true
                    button_level8.setBackgroundResource(R.drawable.new_tablon)
                }
                9 -> {
                    button_level9.isEnabled = true
                    button_level9.setBackgroundResource(R.drawable.new_tablon)
                }
                10 -> {
                    button_level10.isEnabled = true
                    button_level10.setBackgroundResource(R.drawable.new_tablon)
                }
            }
        }
    }
}


