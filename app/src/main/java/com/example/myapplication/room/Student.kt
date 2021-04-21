package com.example.myapplication.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Student(

    @ColumnInfo(name = "name")
    var name:String? = null,

    @ColumnInfo(name ="lastName")
    var lastName:String? = null,

    @ColumnInfo(name="address")
    var address:String? = null
) :Serializable{

    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}