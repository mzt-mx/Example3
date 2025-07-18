package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarAdapter(
    private val cars: List<Car>,
    private val onItemClick: (Car) -> Unit
) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val brandModel: TextView = itemView.findViewById(R.id.tvBrandModel)
        val year: TextView = itemView.findViewById(R.id.tvYear)
        val description: TextView = itemView.findViewById(R.id.tvDescription)
        val cost: TextView = itemView.findViewById(R.id.tvCost)
        val image: ImageView = itemView.findViewById(R.id.ivCarImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = cars[position]
        holder.brandModel.text = "${car.brand} ${car.model}"
        holder.year.text = car.year.toString()
        holder.description.text = car.description
        holder.cost.text = "${car.cost} ₽"
        holder.image.setImageResource(car.imageResId)
        holder.itemView.setOnClickListener { onItemClick(car) }
    }

    override fun getItemCount(): Int = cars.size
}

