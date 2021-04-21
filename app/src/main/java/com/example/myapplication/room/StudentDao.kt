package com.example.myapplication.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface StudentDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(student: Student)

    @Query(value = "select * from student")
    fun fetch():List<Student>

}