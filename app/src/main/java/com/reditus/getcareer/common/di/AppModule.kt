package com.reditus.getcareer.common.di

import com.reditus.getcareer.data.api.career.CareerApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient{
        val httpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideConverterFactory(): Converter.Factory{
        return GsonConverterFactory.create()
    }
    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory
    ): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .baseUrl("https://zzvebj8cwb.execute-api.ap-northeast-2.amazonaws.com")
            .build()
    }

    @Singleton
    @Provides
    fun providerApiService(retrofit: Retrofit): CareerApi{
        return retrofit.create(CareerApi::class.java)
    }



}