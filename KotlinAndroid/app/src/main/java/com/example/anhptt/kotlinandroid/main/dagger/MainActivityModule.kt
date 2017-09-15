package com.example.anhptt.kotlinandroid.main.dagger

import android.app.Activity
import com.example.anhptt.kotlinandroid.common.di.ActivityScoped
import com.example.anhptt.kotlinandroid.data.source.repository.LoginDataRepository
import com.example.anhptt.kotlinandroid.data.source.source.LoginDataSource
import com.example.anhptt.kotlinandroid.main.view.MainActivity
import com.example.anhptt.kotlinandroid.main.MainActivityContract
import com.example.anhptt.kotlinandroid.main.MainActivityPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class MainActivityModule{

    @ActivityScoped
    @Binds
    abstract fun view(view: MainActivity): MainActivityContract.View

    @ActivityScoped
    @Binds
    abstract fun presenter(presenter: MainActivityPresenter): MainActivityContract.Presenter

    @ActivityScoped
    @Binds
    abstract fun activity(mainActivity: MainActivity) : Activity

    @ActivityScoped
    @Binds
    abstract fun loginDataRepository(loginDataRepository: LoginDataRepository): LoginDataSource

}