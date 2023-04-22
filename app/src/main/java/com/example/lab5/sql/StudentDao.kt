package com.example.lab5.sql

import android.content.ContentValues
import android.content.Context
import android.provider.BaseColumns
import java.util.*


class StudentDao(context: Context) {
    private val dbHelper: DBHelper = DBHelper(context)

    fun add(student: StudentContract.Student) {
        val db = this.dbHelper.writableDatabase

        val cv = ContentValues()
        cv.put(StudentContract.StudentEntry.COLUMN_NAME_FIRST_NAME, student.firstName)
        cv.put(StudentContract.StudentEntry.COLUMN_NAME_LAST_NAME, student.lastName)

        val newRowId = db?.insert(
            StudentContract.StudentEntry.TABLE_NAME,
            null,
            cv
        )

        db.close()
    }

    fun edit(student: StudentContract.Student) {
        val db = this.dbHelper.writableDatabase

        val cv = ContentValues()
        cv.put(StudentContract.StudentEntry.COLUMN_NAME_LAST_NAME, "Last")

        val newRowId = db?.update(
            StudentContract.StudentEntry.TABLE_NAME,
            null,
            "${BaseColumns._ID} EQUAL ?",
            arrayOf(student.id.toString())
        )
    }

    fun getAll(): List<StudentContract.Student> {
        val db = this.dbHelper.readableDatabase

        val cursor = db.query(
            StudentContract.StudentEntry.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            "${StudentContract.StudentEntry.COLUMN_NAME_LAST_NAME} ASC"
        )

        val items = ArrayList<StudentContract.Student>()

        val lastNameIndex = cursor.getColumnIndex(StudentContract.StudentEntry.COLUMN_NAME_LAST_NAME)
        val firstNameIndex = cursor.getColumnIndex(StudentContract.StudentEntry.COLUMN_NAME_FIRST_NAME)
        val idIndex = cursor.getColumnIndex(BaseColumns._ID)

        while (cursor.moveToNext()) {
            items.add(
                StudentContract.Student(
                    cursor.getInt(idIndex),
                    cursor.getString(firstNameIndex),
                    cursor.getString(lastNameIndex),
                )
            )
        }

        cursor.close()
        db.close()

        return items
    }
}