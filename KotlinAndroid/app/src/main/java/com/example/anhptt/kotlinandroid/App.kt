package com.example.anhptt.kotlinandroid

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App: DaggerApplication(){


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        var appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)
        return appComponent
    }

}