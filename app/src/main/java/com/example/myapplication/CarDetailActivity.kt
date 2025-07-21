package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import android.widget.ImageView
import android.widget.TextView

class CarDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_detail)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener { finish() }

        val image = findViewById<ImageView>(R.id.ivDetailImage)
        val brandModel = findViewById<TextView>(R.id.tvDetailBrandModel)
        val year = findViewById<TextView>(R.id.tvDetailYear)
        val description = findViewById<TextView>(R.id.tvDetailDescription)
        val cost = findViewById<TextView>(R.id.tvDetailCost)

        val brand = intent.getStringExtra("brand") ?: ""
        val model = intent.getStringExtra("model") ?: ""
        val yearValue = intent.getIntExtra("year", 0)
        val descriptionValue = intent.getStringExtra("description") ?: ""
        val costValue = intent.getIntExtra("cost", 0)
        val imageResId = intent.getIntExtra("imageResId", R.drawable.ic_launcher_foreground)

        image.setImageResource(imageResId)
        brandModel.text = "$brand $model"
        year.text = yearValue.toString()
        description.text = descriptionValue
        cost.text = "$costValue ₽"
    }
}

