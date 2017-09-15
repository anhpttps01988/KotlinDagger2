package com.example.anhptt.kotlinandroid.login.dagger

import android.content.Context
import com.example.anhptt.kotlinandroid.common.di.ActivityScoped
import com.example.anhptt.kotlinandroid.data.source.repository.LoginDataRepository
import com.example.anhptt.kotlinandroid.data.source.source.LoginDataSource
import com.example.anhptt.kotlinandroid.login.LoginActivityContract
import com.example.anhptt.kotlinandroid.login.LoginActivityPresenter
import com.example.anhptt.kotlinandroid.login.view.LoginActivity
import dagger.Binds
import dagger.Module

@Module
abstract class LoginActivityModule{

    @ActivityScoped
    @Binds
    abstract fun view(loginActivity: LoginActivity): LoginActivityContract.View

    @ActivityScoped
    @Binds
    abstract fun presenter(presenter: LoginActivityPresenter) : LoginActivityContract.Presenter

    @ActivityScoped
    @Binds
    abstract fun context(loginActivity: LoginActivity): Context

    @ActivityScoped
    @Binds
    abstract fun loginDataRepository(loginDataRepository: LoginDataRepository): LoginDataSource
}