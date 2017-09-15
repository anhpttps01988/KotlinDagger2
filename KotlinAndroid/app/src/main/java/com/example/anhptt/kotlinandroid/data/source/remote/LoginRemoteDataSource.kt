package com.example.anhptt.kotlinandroid.data.source.remote

import android.os.Handler
import com.example.anhptt.kotlinandroid.data.source.remote.request.UserRequest
import com.example.anhptt.kotlinandroid.data.source.source.LoginDataSource
import javax.inject.Inject

class LoginRemoteDataSource: LoginDataSource{
    override fun getUserList(loadUserListCallback: LoginDataSource.LoadUserListCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /*
    * fake data
    */
    var user: String = "abc"
    var pass: String = "abc"

    @Inject
    constructor()

    override fun login(user: UserRequest, loginCallback: LoginDataSource.LoginCallback) {
        Handler().postDelayed({
            if (user.getUser()!!.equals(this.user) && user.getPass()!!.equals(this.pass)){
                loginCallback.onLoginSuccess()
            }else{
                loginCallback.onLoginError("Login Error !")
            }
        },1000)
    }

}