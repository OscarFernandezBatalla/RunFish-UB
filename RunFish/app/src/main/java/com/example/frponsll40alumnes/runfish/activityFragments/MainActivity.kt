package com.example.frponsll40alumnes.runfish.activityFragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.databinding.DataBindingUtil
import android.support.v4.app.FragmentManager
import android.view.WindowManager
//import com.example.frponsll40alumnes.runfish.R
import com.example.frponsll40alumnes.runfish.databinding.ActivityMainBinding
import com.example.frponsll40alumnes.runfish.MVP.Presenter
import com.example.frponsll40alumnes.runfish.R



//import android.R



var ReturnDirection : LevelDirection =
    LevelDirection.SINGLEPLAYER

enum class LevelDirection {
    SINGLEPLAYER, MULTIPLAYER
}

class MainActivity : AppCompatActivity() {


    /*TOTES les variables de tots els frag: Biblia*/
    //var textFish : String = "Select a fish"



    //OJOOOOOO







    /*
    * DOS OPCIONS: VARIABLES AQUI O MÈTODES QUE RETORNEN LES VARIABLES GUARDADES A MODEL
    *
    * Avantatges de variables aqui: molts menys mètodes
    * Desavantantges: practicament estarem posant més dades aquí que a repositori
    *
    *
    *
    * Avantatges de variables a model: no hi han variables aquí i estan millor a Model
    * Desavantantges: molts més mètodes aqui
    *
    *
    *
    *
    * */







    //aixo despres de les declaracions
    var presenter : Presenter = Presenter(this)






    var fm : FragmentManager? = null
    var statsFragment : statsFragment? = supportFragmentManager.findFragmentById(R.id.statsFragment) as statsFragment?



    lateinit var binding: ActivityMainBinding
    //lateinit var gameView : GameView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        //Amaga la barra de notificacions.
        //requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)



        /*
        gameView = GameView(this)
        setContentView(gameView)
*/

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


    }

    /*PAS 2 EXEMPLE A */
    /*EXEMPLE AUGMENTAR statNumberOfDeath AGAFANT EL VALOR DEL FRAGMENT GAME*/
    /*
    fun increaseStatNumberOfDeath(vegadesMort: Int) {
        presenter.increaseStatNumberOfDeath(vegadesMort)
    }
*/

    /*PAS 3 EXEMPLE B*/
    /*EXEMPLE CARREGAR statNumberOfDeath AL FRAGMENT STATS*/


}
