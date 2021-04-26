package com.example.myapplication.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.myapplication.R

class ViewActivity : AppCompatActivity() {

    lateinit var imgOnOff: ImageView
    lateinit var imgFromGallary:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        imgOnOff = findViewById(R.id.imgOnOff)
        imgFromGallary = findViewById(R.id.imgFromGallary)

        var flag: Boolean = true

        imgOnOff.setOnClickListener {

            if (flag) {
                imgOnOff.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_baseline_music_note_24
                    )
                )
                flag = false
            } else {
                imgOnOff.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_baseline_music_off_24
                    )
                )
                flag = true
            }

        }


        when {
//            intent.action == Intent.ACTION_SEND -> {
//
////                if (intent.type == "text/") {
//                    handleText(intent)
////                }
//            }

            intent.action == Intent.ACTION_SEND->{
                handleImage(intent)
            }
        }
    }

    private fun handleImage(intent: Intent?) {

        var image = intent?.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM) as Uri
        Log.i("ViewActivity","Image from gallary=>"+image)
        imgFromGallary.setImageURI(image)
    }

    private fun handleText(intent: Intent?) {

        val text = intent?.getStringExtra(Intent.EXTRA_TEXT)
        Log.i("android", "Text from another app=>$text")
    }
}