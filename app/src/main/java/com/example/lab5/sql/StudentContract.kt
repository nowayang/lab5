package com.example.lab5.sql

import android.provider.BaseColumns

object StudentContract {

    object StudentEntry : BaseColumns {
        const val TABLE_NAME = "student"
        const val COLUMN_NAME_FIRST_NAME = "first_name"
        const val COLUMN_NAME_LAST_NAME = "last_name"
    }

    data class Student (val id: Int, val firstName: String?, val lastName: String?) {
        override fun toString(): String {
            return "$lastName $firstName"
        }
    }
}
