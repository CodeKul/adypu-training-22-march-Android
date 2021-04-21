package com.example.myapplication.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplication.R

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        var student = Student()
        student.name = "Sachin"
        student.lastName = "Kadam"
        student.address = "Nashik"

        Thread {
            AppDatabase.getInstance(this@RoomActivity).studentDao().save(student)
        }.start()

        Thread {
            var list = AppDatabase.getInstance(this@RoomActivity).studentDao().fetch()

            Log.i("list", "list of student =>" + list)
        }.start()
    }
}