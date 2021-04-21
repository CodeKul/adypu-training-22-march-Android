package com.example.myapplication.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Student::class), version = 1)
abstract class AppDatabase : RoomDatabase() {


    abstract fun studentDao():StudentDao

    companion object {

        var dbInstance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {

            if (dbInstance == null) {
                dbInstance = Room.databaseBuilder(context, AppDatabase::class.java, "testdb")
                    .fallbackToDestructiveMigration().build()
            }
            return dbInstance!!

        }
    }
}