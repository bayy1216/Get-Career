package com.reditus.getcareer.data.api.career

import com.reditus.getcareer.data.dto.CareerModel
import retrofit2.http.GET

interface CareerApi {
    @GET("/careers")
    suspend fun getCareers() : List<CareerModel>
}