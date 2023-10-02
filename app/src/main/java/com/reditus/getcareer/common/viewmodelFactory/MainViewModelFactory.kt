package com.reditus.getcareer.common.viewmodelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.reditus.getcareer.data.repository.career.CareerRepository
import com.reditus.getcareer.presentation.viewmodel.career.CareerViewModel
import com.reditus.getcareer.common.api.ApiClient

class MainViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CareerViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            val repository = CareerRepository(ApiClient.create())
            return CareerViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}