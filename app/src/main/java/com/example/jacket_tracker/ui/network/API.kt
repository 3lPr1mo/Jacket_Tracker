package com.example.jacket_tracker.ui.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API {
    private var retrofit: Retrofit? = null
    private var baseURL = "http://localhost:3000/"

    fun getClient(): Retrofit?{
        val client = OkHttpClient.Builder().build()
        retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit
    }
}
