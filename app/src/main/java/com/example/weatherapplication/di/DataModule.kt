package com.example.weatherapplication.di

import com.example.weatherapplication.data.repository.RepositoryImpl
import com.example.weatherapplication.domain.repository.Repository
import org.koin.dsl.module

val dataModule = module {

    single<Repository> {
        RepositoryImpl(application = get())
    }
}