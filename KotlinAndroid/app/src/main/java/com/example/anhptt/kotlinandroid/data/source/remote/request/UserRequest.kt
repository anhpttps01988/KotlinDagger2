package com.example.anhptt.kotlinandroid.data.source.remote.request

class UserRequest{

    private var mUser: String? = null
    private var mPass: String? = null

    constructor(){

    }

    constructor(user: String, pass: String ){
        this.mUser = user
        this.mPass = pass
    }


    fun getUser(): String?{
        return mUser
    }

    fun setUser(user: String){
        this.mUser = user
    }

    fun getPass(): String? {
        return mPass
    }

    fun setPass(pass: String){
        this.mPass = pass
    }

}