package com.example.anhptt.kotlinandroid.main.view

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.anhptt.kotlinandroid.R
import com.example.anhptt.kotlinandroid.common.activity.BaseActivity
import com.example.anhptt.kotlinandroid.data.source.remote.request.UserRequest
import com.example.anhptt.kotlinandroid.main.MainActivityContract
import com.example.anhptt.kotlinandroid.main.adapter.UserListAdapter
import javax.inject.Inject

class MainActivity : BaseActivity(), MainActivityContract.View {


    @Inject
    lateinit var mPresenter: MainActivityContract.Presenter

    var mUserAdapter: UserListAdapter? = null
    var mLvUser: ListView? = null
    var mListUser: MutableList<UserRequest> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter.getUserList()
        mUserAdapter = UserListAdapter(this, R.layout.item_user, mListUser)
        mLvUser = findViewById(R.id.listUser)
        mLvUser?.adapter = mUserAdapter
    }

    override fun onStart() {
        super.onStart()
        mPresenter.start()
    }

    override fun onStop() {
        super.onStop()
        mPresenter.stop()
    }

    override fun setPresenter(presenter: MainActivityContract.Presenter) {
        this.mPresenter = presenter
    }

    override fun showUserList(dataList: List<UserRequest>) {
        mListUser.addAll(dataList)
        mUserAdapter?.notifyDataSetChanged()
    }

    override fun showUserListError() {
        Toast.makeText(this, "Data not available !", Toast.LENGTH_SHORT).show()
    }
}
