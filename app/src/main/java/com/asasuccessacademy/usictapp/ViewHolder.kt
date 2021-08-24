package com.asasuccessacademy.usictapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var desText:TextView = itemView.findViewById(R.id.text_description)
    var titleText:TextView = itemView.findViewById(R.id.text_title)
}