package com.example.anhptt.kotlinandroid.data.source.repository

import com.example.anhptt.kotlinandroid.common.di.Local
import com.example.anhptt.kotlinandroid.common.di.Remote
import com.example.anhptt.kotlinandroid.data.source.local.UserLocalDataSource
import com.example.anhptt.kotlinandroid.data.source.remote.request.UserRequest
import com.example.anhptt.kotlinandroid.data.source.source.LoginDataSource
import javax.inject.Inject

class LoginDataRepository: LoginDataSource{


    private var mRemoteDataSource: LoginDataSource? = null
    private var mLocalDataSource: LoginDataSource? = null

    @Inject
    constructor(@Remote remoteDataSource: LoginDataSource, @Local localDataSource: LoginDataSource){
        this.mRemoteDataSource = remoteDataSource
        this.mLocalDataSource = localDataSource
    }

    override fun getUserList(loadUserListCallback: LoginDataSource.LoadUserListCallback) {
        mLocalDataSource!!.getUserList(object : LoginDataSource.LoadUserListCallback{
            override fun onUserListLoaded(dataList: List<UserRequest>) {
                loadUserListCallback.onUserListLoaded(dataList)
            }

            override fun onUserListDataNotAvailable() {
                loadUserListCallback.onUserListDataNotAvailable()
            }
        })
    }

    override fun login(user: UserRequest, loginCallback: LoginDataSource.LoginCallback) {
        mRemoteDataSource!!.login(user, object : LoginDataSource.LoginCallback{
            override fun onLoginSuccess() {
                loginCallback.onLoginSuccess()
            }

            override fun onLoginError(error: String) {
                loginCallback.onLoginError(error)
            }
        })
    }

}