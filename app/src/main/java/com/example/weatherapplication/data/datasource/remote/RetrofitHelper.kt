package com.example.weatherapplication.data.datasource.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
// здесь функция которая возвращает объект Retrofit
object RetrofitHelper {

    val baseUrl = "https://www.weatherapi.com/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}