package com.example.lab5.sql

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("DROP TABLE IF EXISTS " + StudentContract.StudentEntry.TABLE_NAME)
        db.execSQL("CREATE TABLE ${StudentContract.StudentEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${StudentContract.StudentEntry.COLUMN_NAME_FIRST_NAME} TEXT," +
                "${StudentContract.StudentEntry.COLUMN_NAME_LAST_NAME} TEXT)");
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (db !== null) {
            onCreate(db)
        }
    }

    companion object {
        const val DATABASE_VERSION = 4
        const val DATABASE_NAME = "Student.db"
    }
}
