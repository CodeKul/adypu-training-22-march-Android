package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {

   var bundle = Bundle()
    var btn:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btn = findViewById(R.id.activityMain2btn)

        bundle = intent.extras!!

        val str:String = bundle.getString("myBundle").toString()

        btn?.setText(str)

    }
}