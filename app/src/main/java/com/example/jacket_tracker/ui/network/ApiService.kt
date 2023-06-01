package com.example.jacket_tracker.ui.network

import com.example.jacket_tracker.ui.model.jacket
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("jacket")
    fun getJackets(): Call<List<jacket>>?
}