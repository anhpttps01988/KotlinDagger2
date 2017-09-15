package com.example.anhptt.kotlinandroid.common.di

import com.example.anhptt.kotlinandroid.login.dagger.LoginActivityModule
import com.example.anhptt.kotlinandroid.login.view.LoginActivity
import com.example.anhptt.kotlinandroid.main.view.MainActivity
import com.example.anhptt.kotlinandroid.main.dagger.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule{

    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun mainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = arrayOf(LoginActivityModule::class))
    abstract fun loginActivity(): LoginActivity
}