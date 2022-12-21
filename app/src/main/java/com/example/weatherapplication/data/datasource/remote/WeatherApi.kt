package com.example.weatherapplication.data.datasource.remote

import retrofit2.http.GET

interface WeatherApi {
    @GET("/weather")
    fun getWeather(): WeatherForecast
}