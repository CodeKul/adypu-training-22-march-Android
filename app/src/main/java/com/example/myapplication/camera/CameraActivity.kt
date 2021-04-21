package com.example.myapplication.camera

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import com.example.myapplication.R

class CameraActivity : AppCompatActivity() {

    lateinit var btnOpenCamera:Button
    lateinit var imgPhoto:ImageView
    lateinit var btnNext:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        val actionBar = supportActionBar
        actionBar?.title = "Camera Activity"

        btnOpenCamera = findViewById(R.id.btnOpen)
        imgPhoto = findViewById(R.id.imgPhoto)
        btnNext = findViewById(R.id.btnNext)

        btnOpenCamera.setOnClickListener {
            openCamera()
        }

        btnNext.setOnClickListener {

            var intent = Intent(this@CameraActivity,NewActivity::class.java)
            startActivity(intent)
        }

    }

    var REQUEST_IMAGE_CAPTURE = 1

    private fun openCamera(){
        var takePicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try{

            startActivityForResult(takePicture,REQUEST_IMAGE_CAPTURE)
        }catch (e:ActivityNotFoundException){
            Log.i("android","e=>"+e)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val imageData = data?.extras?.get("data") as Bitmap
        imgPhoto.setImageBitmap(imageData)


    }



}