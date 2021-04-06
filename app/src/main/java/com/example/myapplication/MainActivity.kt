package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    var txtValue:TextView ? =null
    var btnIncreament:Button ? = null
    var number:Int = 0

    var bundle = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        txtValue = findViewById(R.id.txt1)
        btnIncreament = findViewById(R.id.btnIncreament)
        btnIncreament?.setOnClickListener {
//            number++
//            txtValue?.setText(number.toString())

            bundle.putString("myBundle","From activity first")
            val intent = Intent(this,MainActivity2::class.java)
            intent.putExtras(bundle)
            startActivity(intent)

        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter",number)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        number = savedInstanceState.getInt("counter")
        txtValue?.setText(number.toString())
    }



    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "On Start", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "On Resume", Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "On Pause", Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "On Stop", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "On Destroy", Toast.LENGTH_LONG).show()
    }

    override fun onRestart() {
        super.onRestart()

        Toast.makeText(this, "On Restart", Toast.LENGTH_LONG).show()
    }


}