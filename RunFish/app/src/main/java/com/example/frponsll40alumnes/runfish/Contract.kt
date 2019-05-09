package com.example.frponsll40alumnes.runfish

interface Contract {

    interface View {

        //aqui tots els metodes que ha de fer la view

        //fun initView()
        fun updateShopFragment()
        fun updateFishFragment()
        fun updateFriendsFragment()
        fun updateLevelsFragment()
        fun updateMultiplayerFragment()
        fun updateOptionsFragment()
        fun updateStatsFragment()

    }

    interface Presenter {

        //aqui tots els metodes que poden




        fun updateHp()
        fun engageGame()
        fun signIn()
        //fun register()  ??
        fun buyFish()
        fun music()
        fun sounds()
        fun vibration()
        fun language()
        fun useAbility()       //per canviar la icona a gris durant un temps
        fun win()
        fun gameOver()

        fun updateShopFragment()
        fun updateFishFragment()
        fun updateFriendsFragment()
        fun updateLevelsFragment()
        fun updateMultiplayerFragment()
        fun updateOptionsFragment()
        fun updateStatsFragment()

    }

    interface Model {

        //aqui tots els metodes que han d'implementar repositori


        fun signIn()
        fun buyFish()
        fun music()
        fun sounds()
        fun vibration()
        fun language()

        fun win()
        fun gameOver()



        /*repositori*/


    }

}