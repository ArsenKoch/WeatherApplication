package com.example.weatherapplication.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.weatherapplication.common.WeatherForecastUI
import com.example.weatherapplication.data.repository.RepositoryImpl
import com.example.weatherapplication.domain.usecase.RequestWeatherData

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = RepositoryImpl(application)

    private val requestWeatherData = RequestWeatherData(repository)

    val liveDataCurrent = MutableLiveData<WeatherForecastUI>()
    val liveDataList = MutableLiveData<List<WeatherForecastUI>>()

    //val rew = WeatherForecastUI()

    fun requestWeatherData(city: String) = requestWeatherData()

    companion object {

        const val LOG_TAG = "log_tag"
    }
}