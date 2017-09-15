package com.example.anhptt.kotlinandroid.main

import android.app.Activity
import android.content.Context
import android.util.Log
import com.example.anhptt.kotlinandroid.data.source.remote.request.UserRequest
import com.example.anhptt.kotlinandroid.data.source.repository.LoginDataRepository
import com.example.anhptt.kotlinandroid.data.source.source.LoginDataSource
import javax.inject.Inject


class MainActivityPresenter @Inject constructor(view: MainActivityContract.View) : MainActivityContract.Presenter {

    private var mView: MainActivityContract.View? = view

    @Inject
    lateinit var context: Context

    @Inject
    lateinit var activity: Activity

    @Inject
    lateinit var userDataRepository: LoginDataRepository

    override fun start() {
        if (context != null)
            Log.d(TAG,"context was dependency injection")
        else
            Log.d(TAG,"context not dependency injection")
        if (activity != null)
            Log.d(TAG,"activity was dependency injection")
        else
            Log.d(TAG,"activity not dependency injection")
    }

    override fun stop() {
    }

    override fun getUserList() {
        userDataRepository.getUserList(object : LoginDataSource.LoadUserListCallback{
            override fun onUserListLoaded(dataList: List<UserRequest>) {
                mView?.showUserList(dataList)
            }

            override fun onUserListDataNotAvailable() {
                mView?.showUserListError()
            }

        })
    }

    companion object {
        var TAG: String = MainActivityPresenter.javaClass.simpleName
    }
}