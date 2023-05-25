package com.example.jacket_tracker.data.network

import com.example.jacket_tracker.data.model.JacketModel
import retrofit2.Call
import retrofit2.http.GET

interface JacketApiClient {
    @GET("jacket")
    fun getAllJackets() : Call<List<JacketModel>>?
    suspend fun getJackets() : retrofit2.Response<List<JacketModel>> //Devuelve la solicitud web
}