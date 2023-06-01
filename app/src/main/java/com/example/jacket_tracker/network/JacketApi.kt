package com.example.jacket_tracker.network

import com.example.jacket_tracker.Responses.jacket
import com.example.jacket_tracker.Responses.jacketResponse
import retrofit2.http.GET

interface JacketApi {
    @GET("jacket")
    suspend fun getJackets(): jacketResponse //TODO: PONER EL OBJETO .
}