package com.example.myapplication.broadcastereceiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.R

class BroadcasteActivity : AppCompatActivity() {

    var txtBatteryLevel: TextView? = null

    var batteryReceiver: BatteryReceiver? = null

    var airPlanMode: AirPlanMode? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcaste)

//
//        txtBatteryLevel = findViewById(R.id.txtBattery)
//
//        batteryReceiver = BatteryReceiver(txtBatteryLevel!!)
//
//        registerReceiver(batteryReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))


        airPlanMode = AirPlanMode()

        registerReceiver(airPlanMode, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))

    }


    override fun onStop() {
        super.onStop()

        unregisterReceiver(airPlanMode)
    }

}