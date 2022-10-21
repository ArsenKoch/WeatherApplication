package com.example.weatherapplication.data.datasource.remote
// data class на основе gson
data class QuoteList(
    val city: String,
    val time: String,
    val condition: String,
    val currentTemp: String,
    val maxTemp: String,
    val minTemp: String,
    val imageUrl: String,
    val hours: String
)