package com.example.myapplication.broadcastereceiver

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R

class InterrnetCheckActivity : AppCompatActivity() {


    lateinit var button: Button
    var textView:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interrnet_check)
        button = findViewById(R.id.btnIntenetCheck)

        button.setOnClickListener {


            if(checkInternet(this)){
                Toast.makeText(this, "Internet is connected", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Internet is disconnected", Toast.LENGTH_SHORT).show()
            }
        }

    }


    companion object{
        fun checkInternet(context: Context):Boolean{
            val check = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return check.activeNetworkInfo != null && check.activeNetworkInfo!!.isConnectedOrConnecting

        }
    }

}