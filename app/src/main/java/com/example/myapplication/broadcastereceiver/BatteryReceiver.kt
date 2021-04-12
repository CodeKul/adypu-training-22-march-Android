package com.example.myapplication.broadcastereceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.widget.TextView

class BatteryReceiver(var txt:TextView) : BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {
        var level :Int? = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL,0)


        if(level!= 0){
            txt.setText("Pere=>"+level.toString())
        }
    }
}