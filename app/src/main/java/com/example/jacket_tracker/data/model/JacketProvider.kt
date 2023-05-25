package com.example.jacket_tracker.data.model

import androidx.lifecycle.MutableLiveData
import com.example.jacket_tracker.data.network.Api
import com.example.jacket_tracker.data.network.JacketApiClient
import retrofit2.Callback

class JacketProvider {
    companion object{
        var jackets: List<JacketModel> = emptyList()

    }
}