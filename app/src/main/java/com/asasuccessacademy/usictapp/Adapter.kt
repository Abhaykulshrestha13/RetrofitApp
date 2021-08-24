package com.asasuccessacademy.usictapp

import POJO
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(mainActivity: MainActivity, postList: List<POJO>) : RecyclerView.Adapter<ViewHolder>() {
    var mContext = mainActivity
    var mList = postList
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.desText.text = mList[position].body
        holder.titleText.text = mList[position].title
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}