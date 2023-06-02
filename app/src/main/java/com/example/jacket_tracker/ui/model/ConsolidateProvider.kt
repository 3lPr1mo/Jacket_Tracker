package com.example.jacket_tracker.ui.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.jacket_tracker.ui.network.API
import com.example.jacket_tracker.ui.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConsolidateProvider {
    var apInterface: ApiService? = null
    val model = MutableLiveData<List<Consolidate>>()

    fun getConsolidate() : MutableLiveData<List<Consolidate>> {
        apInterface = API().getClient()?.create(ApiService :: class.java)

        apInterface?.getConsolidates()?.enqueue(object : Callback<List<Consolidate>> {
            override fun onResponse(call: Call<List<Consolidate>>, response: Response<List<Consolidate>>) {
                Log.d("CODEHTTP", response.code().toString())
                val resource: List<Consolidate>? = response.body()

                Log.d("TAG", response.body().toString())
                model.value = resource as List<Consolidate>
            }

            override fun onFailure(call: Call<List<Consolidate>>, t: Throwable) {
                Log.d("HTTPERROR", t?.message.toString())
                call.cancel()
            }
        })
        return model
    }
}