package com.reditus.getcareer.common.api

import com.reditus.getcareer.data.dto.CareerModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiClient {
    @GET("/careers")
    suspend fun getCareers() : List<CareerModel>


    companion object{
        fun create(): ApiClient{

            val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl("https://zzvebj8cwb.execute-api.ap-northeast-2.amazonaws.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(ApiClient::class.java)

        }
    }
}