package com.reditus.getcareer.data.repository.career

import com.reditus.getcareer.data.dto.CareerModel
import com.reditus.getcareer.common.api.ApiClient

class CareerRepository(
    private val apiClient: ApiClient
) {
    suspend fun getCareers() : List<CareerModel>{
        return apiClient.getCareers()
    }
}