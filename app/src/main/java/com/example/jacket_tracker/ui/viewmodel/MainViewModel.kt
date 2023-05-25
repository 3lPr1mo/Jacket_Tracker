package com.example.jacket_tracker.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _navigateToRegister = MutableLiveData<Boolean>()
    val navigateToRegister: LiveData<Boolean> get() = _navigateToRegister

    fun onSingUpClicked(){
        _navigateToRegister.value = true
    }
}