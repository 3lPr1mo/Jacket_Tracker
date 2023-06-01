package com.example.jacket_tracker.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jacket_tracker.ui.model.jacket
import com.example.jacket_tracker.ui.model.jacketProvider

class JacketViewModel: ViewModel() {
    var modeldata = MutableLiveData<List<jacket>>()

    fun getDogs() : LiveData<List<jacket>>{
        modeldata = jacketProvider().getJackets()
        return modeldata
    }
}