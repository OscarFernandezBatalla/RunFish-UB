package com.example.frponsll40alumnes.runfish

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RemoteRepository: DataModel{
    /*
    TODO: Add methods:
        getMap() -> Calls other functions.
        setMap()
     */

    var database : FirebaseAuth? = null;
    var user : FirebaseUser? = null;

    init{
        database = FirebaseAuth.getInstance();
        user = database!!.currentUser;
    }

    fun logIn(){
        //get user email and password from fragment
        val email : String = "hello";
        val password : String = "world";
        database!!.signInWithEmailAndPassword(email, password);

    }

    fun register(){

    }

    fun logOut(){
        database!!.signOut();
    }

    fun getCurrentUser() : FirebaseUser? {
        if(database != null){
            return database!!.currentUser;
        } else {
            return null;
        }
    }

    fun getCurrentUserName() : String {

        var name : String? = getCurrentUser()!!.displayName;

        if(name == null){
            return "John Doe";
        } else {
            return name;
        }

    }

    fun getCurrentUserEmail() : String {

        var email : String? = getCurrentUser()!!.email;

        if(email == null){
            return "johndoe@gmail.com";
        } else {
            return email;
        }

    }


}
