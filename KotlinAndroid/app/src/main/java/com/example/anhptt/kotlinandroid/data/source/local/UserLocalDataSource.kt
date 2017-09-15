package com.example.anhptt.kotlinandroid.data.source.local

import com.example.anhptt.kotlinandroid.data.source.remote.request.UserRequest
import com.example.anhptt.kotlinandroid.data.source.source.LoginDataSource
import javax.inject.Inject


class UserLocalDataSource: LoginDataSource{
    override fun login(user: UserRequest, loginCallback: LoginDataSource.LoginCallback) {

    }

    override fun getUserList(loadUserListCallback: LoginDataSource.LoadUserListCallback) {
        if (getUserList().isNotEmpty()){
            loadUserListCallback.onUserListLoaded(getUserList())
        }else{
            loadUserListCallback.onUserListDataNotAvailable()
        }
    }

    @Inject
    constructor()

    var dataList: MutableList<UserRequest>? = null


    /*fake data*/
    fun getUserList(): List<UserRequest>{
        dataList = ArrayList<UserRequest>()
        for (i in 0..10){
            var user: UserRequest = UserRequest()
            user!!.setUser("a - "+ i)
            dataList!!.add(user)
        }
        return dataList!!
    }



}