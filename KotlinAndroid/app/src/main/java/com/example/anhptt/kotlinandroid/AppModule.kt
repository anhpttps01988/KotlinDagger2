package com.example.anhptt.kotlinandroid

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(application: Application): Context

}