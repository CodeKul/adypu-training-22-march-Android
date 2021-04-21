package com.example.myapplication.webservice

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("random_joke")
    fun getJokes():Call<JokeResponse>
}