package com.example.weatherapplication.data.repository

import android.app.Application
import android.util.Log
import com.example.weatherapplication.common.WeatherForecastUI
import com.example.weatherapplication.data.datasource.remote.RetrofitHelper
import com.example.weatherapplication.data.datasource.remote.WeatherApi
import com.example.weatherapplication.domain.repository.Repository
import com.example.weatherapplication.presentation.viewmodel.MainViewModel

class RepositoryImpl(
    private val application: Application
) : Repository {

    override fun requestWeatherData() {
        val weatherApi = RetrofitHelper.getInstance().create(WeatherApi::class.java)
        val result = weatherApi.getWeather()
        WeatherForecastUI(
            result.city,
            result.time,
            result.condition,
            result.currentTemp,
            result.maxTemp,
            result.minTemp,
            result.imageUrl,
            result.hours
        )
        Log.d(MainViewModel.LOG_TAG, result.toString())
    }
}