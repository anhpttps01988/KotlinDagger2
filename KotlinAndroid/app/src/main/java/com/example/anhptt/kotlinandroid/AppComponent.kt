package com.example.anhptt.kotlinandroid

import android.app.Application
import com.example.anhptt.kotlinandroid.common.di.ActivityBindingModule
import com.example.anhptt.kotlinandroid.data.dagger.DataRepositoryBindingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules =
arrayOf(ActivityBindingModule::class,
        DataRepositoryBindingModule::class,
        AppModule::class,
        AndroidSupportInjectionModule::class))
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(app:App)

    override fun inject(instance: DaggerApplication?)

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }

}