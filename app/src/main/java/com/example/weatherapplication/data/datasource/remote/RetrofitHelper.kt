package com.example.weatherapplication.data.datasource.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
private const val API_KEY =
    "3e85989370434ee692f162656222110"

object RetrofitHelper {

    val baseUrl = "https://api.weatherapi.com/v1/forecast.json?key=" +
                API_KEY +
                "&q=" +
                "&days=" +
                "3" +
                "&aqi=no&alerts=no"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}