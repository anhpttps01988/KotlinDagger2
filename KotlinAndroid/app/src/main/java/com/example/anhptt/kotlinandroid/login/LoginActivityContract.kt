package com.example.anhptt.kotlinandroid.login

import com.example.anhptt.kotlinandroid.common.mvp.BasePresenter
import com.example.anhptt.kotlinandroid.common.mvp.BaseView


interface LoginActivityContract{

    interface View: BaseView<Presenter>{
        fun showLoginSuccess()
        fun showLoginError(error: String)
        fun showOpenLoading()
        fun showCloseLoading()
    }

    interface Presenter: BasePresenter{
        fun login(user: String, pass: String)
    }

}