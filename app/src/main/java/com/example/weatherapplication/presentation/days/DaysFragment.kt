package com.example.weatherapplication.presentation.days

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.weatherapplication.presentation.viewmodel.MainViewModel
import com.example.weatherapplication.R
import com.example.weatherapplication.common.WeatherAdapter
import com.example.weatherapplication.common.WeatherForecastUI
import com.example.weatherapplication.databinding.FragmentDaysBinding

class DaysFragment : Fragment(R.layout.fragment_days), WeatherAdapter.Listener {

    private lateinit var adapter: WeatherAdapter
    private val model: MainViewModel by activityViewModels()
    private val binding by viewBinding(FragmentDaysBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        model.liveDataList.observe(viewLifecycleOwner) {
            adapter.submitList(it.subList(1, it.size))
        }
    }

    private fun init() = with(binding) {
        adapter = WeatherAdapter(this@DaysFragment)
        rcView.layoutManager = LinearLayoutManager(activity)
        rcView.adapter = adapter
    }

    companion object {
        fun newInstance() = DaysFragment()
    }

    override fun onClick(item: WeatherForecastUI) {
        model.liveDataCurrent.value = item
    }
}