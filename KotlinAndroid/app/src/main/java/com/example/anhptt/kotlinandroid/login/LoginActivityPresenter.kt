package com.example.anhptt.kotlinandroid.login

import android.util.Log
import com.example.anhptt.kotlinandroid.data.source.remote.request.UserRequest
import com.example.anhptt.kotlinandroid.data.source.repository.LoginDataRepository
import com.example.anhptt.kotlinandroid.data.source.source.LoginDataSource
import javax.inject.Inject

class LoginActivityPresenter : LoginActivityContract.Presenter {


    private var mView: LoginActivityContract.View? = null

    @Inject
    lateinit var loginRepository: LoginDataRepository

    @Inject
    constructor(view: LoginActivityContract.View) {
        this.mView = view
    }

    override fun start() {
        if (loginRepository != null) {
            Log.d(TAG, "login repository was dependency injection")
        } else {
            Log.d(TAG, "login repository not dependency injection")
        }
    }

    override fun stop() {

    }

    override fun login(user: String, pass: String) {
        mView?.showOpenLoading()
        var userRq: UserRequest = UserRequest()
        userRq.setUser(user)
        userRq.setPass(pass)
        loginRepository.login(userRq, object : LoginDataSource.LoginCallback{
            override fun onLoginSuccess() {
                mView?.showLoginSuccess()
                mView?.showCloseLoading()
            }

            override fun onLoginError(error: String) {
                mView?.showLoginError(error)
                mView?.showCloseLoading()
            }
        })
    }

    companion object {
        var TAG: String = LoginActivityPresenter.javaClass.name
    }


}