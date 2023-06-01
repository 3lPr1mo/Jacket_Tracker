package com.example.jacket_tracker.Repository

import com.example.jacket_tracker.network.JacketApi

class JacketRepository(
    private val api: JacketApi
): BaseRepository() {

    suspend fun getJacket() = safeApiCall {
        api.getJackets()
    }

}