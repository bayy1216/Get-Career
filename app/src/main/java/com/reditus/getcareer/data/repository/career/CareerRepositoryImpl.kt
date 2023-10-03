package com.reditus.getcareer.data.repository.career

import com.reditus.getcareer.data.api.career.CareerApi
import com.reditus.getcareer.data.dto.CareerModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CareerRepositoryImpl @Inject constructor(
    private val careerApi: CareerApi
):CareerRepository {
    override suspend fun getCareers(): List<CareerModel> {
        return careerApi.getCareers()
    }
}
