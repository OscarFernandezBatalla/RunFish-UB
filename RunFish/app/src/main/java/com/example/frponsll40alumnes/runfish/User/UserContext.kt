package com.example.frponsll40alumnes.runfish.User

class UserContext(var user: String,
                  var userStats: StatsContext = StatsContext(),
                  var plankton: Int = 0,
                  var options: OptionsContext = OptionsContext(),
                  var friends: ArrayList<String> = ArrayList(),
                  var FishOwned: ArrayList<String> = ArrayList(),
                  var levelsRegister: Int = 0 ){

    /*
    TODO: Needs: LevelsRegister, Stats, FishOwned, Options, Plankton, FriendsList
     LevelRegister maybe enum? like TUTORIAL, LEVEL1, LEVEL2, .... LEVEL10
     fish owned maybe HashMap like {common_fish = true, blowfish = false, etc}
     */



}