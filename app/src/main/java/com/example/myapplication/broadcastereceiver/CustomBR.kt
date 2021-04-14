package com.example.myapplication.broadcastereceiver

import android.content.Context
import android.content.Intent

class CustomBR {


    fun sendMsg(context: Context) {

        var intent: Intent = Intent("com.example.sendmsg").putExtra("msg", "Hii this is custom BR")
        context.sendBroadcast(intent)

    }


}