package com.example.weatherapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapplication.data.datasource.remote.QuotesApi
import com.example.weatherapplication.data.datasource.remote.RetrofitHelper
import com.example.weatherapplication.features.weather.MainFragment
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.placeHolder, MainFragment.newInstance())
            .commit()

        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)

        GlobalScope.launch {
            val result = quotesApi.getQuotes()
            Log.d("ayush: ", result.toString())
        }
    }
}