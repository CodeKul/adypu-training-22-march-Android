package com.example.myapplication.runtimepermission

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.myapplication.R

class PermissionActivity : AppCompatActivity() {


    val PERMISSION_REQUEST_CODE = 1

    lateinit var btnCall:Button
    lateinit var edtNumber:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
//        isPermissionRequired()

        btnCall = findViewById(R.id.btnCall)
        edtNumber = findViewById(R.id.edtNumber)

        btnCall.setOnClickListener {
            val number = edtNumber.text.toString()

            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:"+number)
            startActivity(intent)

        }


    }


    private fun isPermissionRequired() {

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            if (!checkPermission()) {
                requestPermission()
            }
        }
    }

    private fun checkPermission(): Boolean {
        val result: Int = ContextCompat.checkSelfPermission(
            this@PermissionActivity,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        return result == PackageManager.PERMISSION_GRANTED
    }


    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this@PermissionActivity,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            PERMISSION_REQUEST_CODE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults.isNotEmpty()) {
                    Toast.makeText(
                        this@PermissionActivity,
                        "Permission is Granted",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(this, "Permission is Denied", Toast.LENGTH_LONG).show()
                }
            }
        }

    }


}