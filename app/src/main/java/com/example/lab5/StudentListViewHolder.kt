package com.example.lab5

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val studentName: TextView = itemView.findViewById(android.R.id.text1)
}