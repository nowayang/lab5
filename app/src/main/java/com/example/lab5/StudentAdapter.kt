package com.example.lab5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab5.sql.StudentContract
import com.example.lab5.sql.StudentDao
import java.util.*

class StudentAdapter(private val students: List<StudentContract.Student>) : RecyclerView.Adapter<StudentListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentListViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false);

        return StudentListViewHolder(view);
    }

    override fun onBindViewHolder(holder: StudentListViewHolder, position: Int) {
        val student = students[position]
        holder.studentName.text = student.toString()
    }

    override fun getItemCount(): Int {
        return students.size
    }
}