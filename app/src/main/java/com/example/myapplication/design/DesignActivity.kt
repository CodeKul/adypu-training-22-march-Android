package com.example.myapplication.design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.myapplication.R

class DesignActivity : AppCompatActivity() {

    var image :ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_design)

        image = findViewById(R.id.imageView1)

        image?.setBackgroundResource(R.drawable.ic_baseline_desktop_mac_24)

    }
}