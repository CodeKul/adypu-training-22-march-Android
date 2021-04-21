package com.example.myapplication.webservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WebServiceActivity : AppCompatActivity() {

    lateinit var txtJoke:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_service)

        txtJoke= findViewById(R.id.txtJoke)
        getJokes()
    }


    private fun getJokes() {
        val BASE_URL = "https://official-joke-api.appspot.com/"

        var apiService = RetrofitInstance().getInstance(BASE_URL).create(ApiService::class.java)
        val call = apiService.getJokes()

        call.enqueue(object : Callback<JokeResponse> {
            override fun onFailure(call: Call<JokeResponse>, t: Throwable) {
                Toast.makeText(this@WebServiceActivity, "Error->"+t, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<JokeResponse>, response: Response<JokeResponse>) {
                Log.i("android", "Response=>${response.body()}")
                var setup = response.body()?.setup
                var punchline = response.body()?.punchline
                txtJoke.setText("setup \n"+setup.toString()+"\nPunchLine-${punchline}")
            }
        })

    }
}