package com.example.jacket_tracker.ui.Base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jacket_tracker.Repository.BaseRepository
import com.example.jacket_tracker.Repository.JacketRepository
import com.example.jacket_tracker.ui.viewmodel.JacketViewModel
import com.example.jacket_tracker.ui.viewmodel.JacketsViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(
    private val repository: BaseRepository
): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(JacketsViewModel::class.java) ->JacketsViewModel(repository as JacketRepository) as T
            else -> throw IllegalArgumentException("viewModelClass not found")
        }
    }

}