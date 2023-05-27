package com.example.jacket_tracker.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jacket_tracker.data.model.JacketModel

class JacketViewModel : ViewModel() {
    val jacket = MutableLiveData<JacketModel>()

    fun bringJackets(){

    }

}