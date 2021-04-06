package com.example.myapplication.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class ListMainActivity : AppCompatActivity() {


    var recyclerViewMenuList:RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_main)


        recyclerViewMenuList = findViewById(R.id.recylerview)

        recyclerViewMenuList?.layoutManager =
            LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val list = ArrayList<String>()

        list.add("Tea")
        list.add("Coffee")
        list.add("Toast")
        list.add("butter")

        val adapter = MenuAdapter(this,list)

        recyclerViewMenuList?.adapter = adapter

    }
}