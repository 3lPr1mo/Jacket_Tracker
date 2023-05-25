package com.example.jacket_tracker.data.network

import com.example.jacket_tracker.core.RetrofitHelper
import com.example.jacket_tracker.data.model.JacketModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class JacketService {
    private val retrofit: Retrofit = RetrofitHelper.getRetrofitJacket()

    suspend fun getJacket(): List<JacketModel>{

        return withContext(Dispatchers.IO){
            val response = retrofit.create(JacketApiClient::class.java).getJackets()
            response.body() ?: emptyList()
        }
    }
}