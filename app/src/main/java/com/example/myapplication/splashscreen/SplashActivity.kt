package com.example.myapplication.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R

class SplashActivity : AppCompatActivity() {


    var topAnimation:Animation?= null
    var bottomAnimation:Animation? = null

    var textview:TextView? = null
    var imageview:ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation)
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation)

        textview = findViewById(R.id.txtMyCollege)
        imageview = findViewById(R.id.imageView2)

        topAnimation?.duration = 2000
        bottomAnimation?.duration = 2000


        imageview?.animation = topAnimation
        textview?.animation = bottomAnimation


    }
}