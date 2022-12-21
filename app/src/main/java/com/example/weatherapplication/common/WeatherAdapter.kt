package com.example.weatherapplication.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapplication.R
import com.example.weatherapplication.databinding.ListItemBinding
import com.squareup.picasso.Picasso

class WeatherAdapter(private val listener: Listener?) :
    ListAdapter<WeatherForecastUI, WeatherAdapter.Holder>(Comparator()) {

    class Holder(view: View, private val listener: Listener?) : RecyclerView.ViewHolder(view) {
        private val binding = ListItemBinding.bind(view)
        private var itemTemp: WeatherForecastUI? = null

        init {
            itemView.setOnClickListener {
                itemTemp?.let { it1 -> listener?.onClick(it1) }
            }
        }

        fun bind(item: WeatherForecastUI) = with(binding) {
            itemTemp = item
            tvDate.text = item.time
            tvCondition1.text = item.condition
            tvTemp.text = item.currentTemp.ifEmpty { "${item.maxTemp}°C / ${item.minTemp}°C" }
            Picasso.get().load("https:" + item.imageUrl).into(im)
        }
    }

    class Comparator : DiffUtil.ItemCallback<WeatherForecastUI>() {
        override fun areItemsTheSame(oldItem: WeatherForecastUI, newItem: WeatherForecastUI): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: WeatherForecastUI, newItem: WeatherForecastUI): Boolean {
            return oldItem == newItem

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Holder(view, listener)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    interface Listener {
        fun onClick(item: WeatherForecastUI)
    }
}