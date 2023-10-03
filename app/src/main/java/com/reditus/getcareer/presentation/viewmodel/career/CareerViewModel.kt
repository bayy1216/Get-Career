package com.reditus.getcareer.presentation.viewmodel.career

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reditus.getcareer.data.dto.CareerModel
import com.reditus.getcareer.data.repository.career.CareerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CareerViewModel @Inject constructor(
    private val careerRepository: CareerRepository
): ViewModel() {
    var careerList = mutableStateListOf<CareerModel>()
    init {
        Log.d("tt","grtCareers!!")
        getCareers()
    }




    private fun getCareers(){
        viewModelScope.launch {
            val resp = careerRepository.getCareers()
            careerList.addAll(resp)
        }
    }
}