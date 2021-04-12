package com.example.myapplication.fragmentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R

class FragmentMainActivity : AppCompatActivity() {

    var button1:Button? = null
    var button2:Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_main)


        val fragment1 = Fragment1()
        val fragment2 = Fragment2()


        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)

        supportFragmentManager.beginTransaction().apply {

            replace(R.id.framelayout,fragment1)
            commit()
        }

        button1?.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {

              add(R.id.framelayout,fragment1)
                commit()
            }
        }

        button2?.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {

                replace(R.id.framelayout,fragment2)
                commit()
            }
        }

    }
}