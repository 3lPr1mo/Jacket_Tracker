package com.example.jacket_tracker.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jacket_tracker.Repository.JacketRepository
import com.example.jacket_tracker.Responses.jacket
import com.example.jacket_tracker.Responses.jacketResponse
import com.example.jacket_tracker.network.Resource
import kotlinx.coroutines.launch

class JacketsViewModel(
    private val repository: JacketRepository
): ViewModel() {
    private val _jacketResponse : MutableLiveData<Resource<jacketResponse>> = MutableLiveData()
    val jacketResponse: LiveData<Resource<jacketResponse>>
        get() = _jacketResponse
    fun getJac() = viewModelScope.launch {
        _jacketResponse.value = repository.getJacket()
    }
}