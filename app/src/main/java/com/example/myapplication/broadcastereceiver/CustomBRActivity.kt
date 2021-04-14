package com.example.myapplication.broadcastereceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class CustomBRActivity : AppCompatActivity() {

    lateinit var button: Button

    lateinit var receiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_b_r)

        button = findViewById(R.id.btnSendMsg)

        button.setOnClickListener {

            val customBR = CustomBR()
            customBR.sendMsg(this@CustomBRActivity)
        }



        receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {

                if (intent?.getStringExtra("msg") != null) {

                    Toast.makeText(
                        this@CustomBRActivity,
                        "msg from class=>${intent.getStringExtra("msg")}",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
        }

        var filter = IntentFilter()
        filter.addAction("com.example.sendmsg")
        registerReceiver(receiver, filter)

    }


}