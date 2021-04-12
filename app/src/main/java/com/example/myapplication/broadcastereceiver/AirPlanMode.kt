package com.example.myapplication.broadcastereceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirPlanMode:BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {

        val isAirPlanModeEnable:Boolean? = intent?.getBooleanExtra("state",false)

        if(isAirPlanModeEnable==true){
            Toast.makeText(context, "Airplane mode is enable", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Airplane mode is disabled", Toast.LENGTH_SHORT).show()
        }
    }
}