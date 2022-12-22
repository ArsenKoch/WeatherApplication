package com.example.weatherapplication.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.weatherapplication.common.WeatherForecastUI
import com.example.weatherapplication.data.repository.RepositoryImpl
import com.example.weatherapplication.domain.usecase.RequestWeatherDataUseCase

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = RepositoryImpl(application)

    private val requestWeatherDataUseCase = RequestWeatherDataUseCase(repository)

    val liveDataCurrent = MutableLiveData<WeatherForecastUI>()
    val liveDataList = MutableLiveData<List<WeatherForecastUI>>()

    //val rew = WeatherForecastUI()

    fun requestWeatherData(city: String) = requestWeatherDataUseCase()

    companion object {

        const val LOG_TAG = "log_tag"
    }
}