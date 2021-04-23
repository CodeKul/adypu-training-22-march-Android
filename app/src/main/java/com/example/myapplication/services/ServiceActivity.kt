package com.example.myapplication.services

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import com.example.myapplication.R

class ServiceActivity : AppCompatActivity() {

    lateinit var btnStart: Button
    lateinit var btnStop: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        btnStart = findViewById(R.id.btnStart)
        btnStop = findViewById(R.id.btnStop)


        btnStart.setOnClickListener {
            startService(Intent(this@ServiceActivity, MyService::class.java))
        }

        btnStop.setOnClickListener {
            stopService(Intent(this@ServiceActivity, MyService::class.java))
        }

    }


    private fun playMusic() {
        var mediaPlayer: MediaPlayer =
            MediaPlayer.create(this@ServiceActivity, Settings.System.DEFAULT_ALARM_ALERT_URI)
        mediaPlayer.isLooping = true
        mediaPlayer.start()

    }
}