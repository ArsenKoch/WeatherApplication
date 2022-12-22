package com.example.weatherapplication.di

import com.example.weatherapplication.domain.usecase.RequestWeatherDataUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<RequestWeatherDataUseCase> {
        RequestWeatherDataUseCase(repository = get())
    }
}