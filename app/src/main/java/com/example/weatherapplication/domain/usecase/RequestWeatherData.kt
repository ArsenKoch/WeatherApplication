package com.example.weatherapplication.domain.usecase

import com.example.weatherapplication.domain.repository.Repository

class RequestWeatherData(
    private val repository: Repository
) {

    operator fun invoke() = repository.requestWeatherData()
}