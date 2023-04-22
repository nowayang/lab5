package com.example.lab5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab5.sql.StudentContract
import com.example.lab5.sql.StudentDao


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val studentDao = StudentDao(this.applicationContext)
        var students = studentDao.getAll()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler)

        if (students.isEmpty()) {
            val s1 = StudentContract.Student(-1, "Kamil", "Nowak")
            studentDao.add(s1)

            val s2 = StudentContract.Student(-1, "Kamil", "Kowalski")
            studentDao.add(s2)

            students = studentDao.getAll()
        }

        recyclerView.adapter = StudentAdapter(students)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}