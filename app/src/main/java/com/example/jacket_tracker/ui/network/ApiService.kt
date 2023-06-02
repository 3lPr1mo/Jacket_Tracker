package com.example.jacket_tracker.ui.network

import com.example.jacket_tracker.ui.model.Consolidate
import com.example.jacket_tracker.ui.model.jacket
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("jackets")
    fun getJackets(): Call<List<jacket>>?

    @GET("consolidate")
    fun getConsolidates(): Call<List<Consolidate>>
}