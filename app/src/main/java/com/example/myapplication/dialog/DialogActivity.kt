package com.example.myapplication.dialog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.R

class DialogActivity : AppCompatActivity() {

    var btn: Button? = null
    var btnOk:Button? = null
    var btnCancel:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        btn = findViewById(R.id.btnOpenDialog)

        btn?.setOnClickListener {
            dialog()
        }
    }


    private fun dialog() {

        var dialog = Dialog(this@DialogActivity)
        dialog.setContentView(R.layout.dialog_layout)
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()


        btnCancel = dialog.findViewById(R.id.btnCancel)
        btnOk = dialog.findViewById(R.id.btnOk)

        btnOk?.setOnClickListener {
            Toast.makeText(this@DialogActivity, "You are clicked on Ok", Toast.LENGTH_SHORT).show()
        }

        btnCancel?.setOnClickListener {
            dialog.dismiss()
        }

    }
}