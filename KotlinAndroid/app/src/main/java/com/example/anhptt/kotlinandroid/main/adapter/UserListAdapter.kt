package com.example.anhptt.kotlinandroid.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.anhptt.kotlinandroid.R
import com.example.anhptt.kotlinandroid.data.source.remote.request.UserRequest

class UserListAdapter(context: Context?, resource: Int, dataList: List<UserRequest>?) : ArrayAdapter<UserRequest>(context, resource, dataList) {

    var mResource: Int? = null
    var mContext: Context? = null
    var mDataList: List<UserRequest> = mutableListOf()


    init {
        this.mResource = resource
        this.mContext = context
        this.mDataList = dataList as List<UserRequest>
    }

    class ViewHolder(row: View){
        var tvName: TextView? = null

        init {
            tvName = row.findViewById(R.id.tvName)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder: ViewHolder
        var reView: View
        if (convertView == null){
            var mInflater: LayoutInflater = LayoutInflater.from(mContext)
            reView = mInflater.inflate(R.layout.item_user,null)
            holder = ViewHolder(reView)
            reView.tag = holder
        }else{
            reView = convertView
            holder = convertView.getTag() as ViewHolder
        }
        var name: UserRequest = mDataList[position]
        holder.tvName?.text = name.getUser()
        return reView
    }

}

