package com.example.jacket_tracker.ui.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.jacket_tracker.ui.network.API
import com.example.jacket_tracker.ui.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class jacketProvider {
    var apInterface: ApiService? = null
    val model = MutableLiveData<List<jacket>>()

    fun getJackets() : MutableLiveData<List<jacket>> {
        apInterface = API().getClient()?.create(ApiService :: class.java)

        apInterface?.getJackets()?.enqueue(object : Callback<List<jacket>>{
            override fun onResponse(call: Call<List<jacket>>, response: Response<List<jacket>>) {
                Log.d("CODEHTTP", response.code().toString())
                val resource: List<jacket>? = response.body()

                Log.d("TAG", response.body().toString())
                model.value = resource as List<jacket>
            }

            override fun onFailure(call: Call<List<jacket>>, t: Throwable) {
                Log.d("HTTPERROR", t?.message.toString())
                call.cancel()
            }
        })
        return model
    }

}