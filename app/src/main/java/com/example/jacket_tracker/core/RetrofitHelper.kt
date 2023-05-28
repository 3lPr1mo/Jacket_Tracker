package com.example.jacket_tracker.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofitUser(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://localhost:3000/users/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getRetrofitJacket(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://localhost:3000/jacket/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getRetrofitDelivery(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://localhost:3000/delivery/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getRetrofitCategoryJacket(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://localhost:3000/category/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}