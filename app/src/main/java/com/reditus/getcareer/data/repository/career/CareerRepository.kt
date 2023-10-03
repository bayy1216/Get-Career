package com.reditus.getcareer.data.repository.career

import com.reditus.getcareer.data.dto.CareerModel

interface CareerRepository {
    suspend fun getCareers() : List<CareerModel>
}