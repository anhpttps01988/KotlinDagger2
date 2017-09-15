package com.example.anhptt.kotlinandroid.login.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.example.anhptt.kotlinandroid.R
import com.example.anhptt.kotlinandroid.common.activity.BaseActivity
import com.example.anhptt.kotlinandroid.login.LoginActivityContract
import com.example.anhptt.kotlinandroid.main.view.MainActivity
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginActivityContract.View {


    override fun showOpenLoading() {
        proBar!!.visibility = View.VISIBLE
    }

    override fun showCloseLoading() {
        proBar!!.visibility = View.GONE
    }

    override fun showLoginSuccess() {
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)
    }

    override fun showLoginError(error: String) {
        Toast.makeText(this@LoginActivity,error,Toast.LENGTH_SHORT).show()
    }

    @Inject lateinit var mPresenter: LoginActivityContract.Presenter

    override fun setPresenter(presenter: LoginActivityContract.Presenter) {
        this.mPresenter = presenter
    }

    private var editUser: EditText? = null
    private var editPass: EditText? = null
    private var btnLogin: Button? = null
    private var proBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViews()
    }

    fun initViews() {
        editUser = findViewById(R.id.editUser)
        editPass = findViewById(R.id.editPass)
        btnLogin = findViewById(R.id.btnLogin)
        proBar = findViewById(R.id.progressBar)
        btnLogin?.setOnClickListener { view ->
            var user: String = editUser?.text.toString()
            var pass: String = editPass?.text.toString()
            mPresenter.login(user, pass)
        }
    }

    override fun onStart() {
        super.onStart()
        mPresenter.start()
    }

    override fun onStop() {
        super.onStop()
        mPresenter.stop()
    }

}