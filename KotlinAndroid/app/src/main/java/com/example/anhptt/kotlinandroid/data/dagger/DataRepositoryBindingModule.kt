package com.example.anhptt.kotlinandroid.data.dagger

import com.example.anhptt.kotlinandroid.common.di.ActivityScoped
import com.example.anhptt.kotlinandroid.common.di.Local
import com.example.anhptt.kotlinandroid.common.di.Remote
import com.example.anhptt.kotlinandroid.data.source.local.UserLocalDataSource
import com.example.anhptt.kotlinandroid.data.source.remote.LoginRemoteDataSource
import com.example.anhptt.kotlinandroid.data.source.source.LoginDataSource
import dagger.Binds
import dagger.Module


@Module
abstract class DataRepositoryBindingModule{

    @ActivityScoped
    @Binds
    @Remote
    abstract fun provideLoginRemoteDataSource(loginRemoteDataSource: LoginRemoteDataSource): LoginDataSource

    @ActivityScoped
    @Binds
    @Local
    abstract fun provideLoginLocalDataSource(userLocalDataSource: UserLocalDataSource) : LoginDataSource

}