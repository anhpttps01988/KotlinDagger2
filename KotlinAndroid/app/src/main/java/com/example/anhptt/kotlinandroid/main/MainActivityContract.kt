package com.example.anhptt.kotlinandroid.main

import com.example.anhptt.kotlinandroid.common.mvp.BasePresenter
import com.example.anhptt.kotlinandroid.common.mvp.BaseView
import com.example.anhptt.kotlinandroid.data.source.remote.request.UserRequest


interface MainActivityContract{

    interface View: BaseView<Presenter>{
        fun showUserList(dataList: List<UserRequest>)
        fun showUserListError()
    }

    interface Presenter: BasePresenter{
        fun getUserList()
    }

}