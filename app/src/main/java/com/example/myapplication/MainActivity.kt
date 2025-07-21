package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val cars = listOf(
            Car("Toyota", "Camry", 2020, "Надежный и комфортный седан.", 1800000, R.drawable.ic_launcher_foreground),
            Car("BMW", "X5", 2019, "Стильный и мощный внедорожник.", 3500000, R.drawable.ic_launcher_foreground),
            Car("Lada", "Vesta", 2022, "Доступный и современный автомобиль.", 1100000, R.drawable.ic_launcher_foreground),
            Car("Mercedes", "E-Class", 2021, "Премиальный бизнес-седан.", 4200000, R.drawable.ic_launcher_foreground),
            Car("Kia", "Rio", 2018, "Экономичный городской авто.", 950000, R.drawable.ic_launcher_foreground)
        )

        val adapter = CarAdapter(cars) { car ->
            val intent = Intent(this, CarDetailActivity::class.java)
            intent.putExtra("brand", car.brand)
            intent.putExtra("model", car.model)
            intent.putExtra("year", car.year)
            intent.putExtra("description", car.description)
            intent.putExtra("cost", car.cost)
            intent.putExtra("imageResId", car.imageResId)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}