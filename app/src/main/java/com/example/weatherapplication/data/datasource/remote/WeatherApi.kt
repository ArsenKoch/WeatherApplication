package com.example.weatherapplication.data.datasource.remote

import com.android.volley.Response
import retrofit2.http.GET

interface WeatherApi {
    @GET("/weather")
    suspend fun getWeather(): Response<WeatherList>
}