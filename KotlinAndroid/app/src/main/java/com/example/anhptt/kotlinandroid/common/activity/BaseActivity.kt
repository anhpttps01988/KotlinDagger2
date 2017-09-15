package com.example.anhptt.kotlinandroid.common.activity

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

open class BaseActivity: DaggerAppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}