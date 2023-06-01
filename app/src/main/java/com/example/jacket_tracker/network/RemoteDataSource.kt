package com.example.jacket_tracker.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource {

    companion object{
            private val BASE_URL = "http://localhost:3000/"
    }

    fun <Api> buildApi(
        api: Class<Api>
    ) : Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }
}