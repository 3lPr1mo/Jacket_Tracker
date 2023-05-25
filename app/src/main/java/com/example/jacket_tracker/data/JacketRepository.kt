package com.example.jacket_tracker.data

import com.example.jacket_tracker.data.model.JacketModel
import com.example.jacket_tracker.data.model.JacketProvider
import com.example.jacket_tracker.data.network.JacketService

class JacketRepository {

    private val api = JacketService()

    suspend fun getAllJackets(): List<JacketModel>{
        val response = api.getJacket()
        JacketProvider.jackets = response
        return response
    }
}