package com.example.anhptt.kotlinandroid.data.source.source

import com.example.anhptt.kotlinandroid.data.source.remote.request.UserRequest
import javax.annotation.Nonnull

interface LoginDataSource{

    interface LoginCallback{
        fun onLoginSuccess()
        fun onLoginError(error: String)
    }

    interface LoadUserListCallback{
        fun onUserListLoaded(dataList: List<UserRequest>)
        fun onUserListDataNotAvailable()
    }

    fun login(user: UserRequest ,@Nonnull loginCallback: LoginCallback)

    fun getUserList(@Nonnull loadUserListCallback: LoadUserListCallback)

}