package com.example.weatherapplication.data.datasource.remote

import com.android.volley.Response
import retrofit2.http.GET
// interface для работы с data class gson
interface QuotesApi {
    @GET("/quotes")
    suspend fun getQuotes(): Response<QuoteList>
}