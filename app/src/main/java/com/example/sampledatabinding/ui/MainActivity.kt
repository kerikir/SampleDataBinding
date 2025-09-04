package com.example.sampledatabinding.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.sampledatabinding.R
import com.example.sampledatabinding.data.SimpleViewModel

class MainActivity : AppCompatActivity()
{
    private val viewModel by lazy {
        ViewModelProvider(this).get(SimpleViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Явно указываем начальные значения
    }


    // Бизнес логика
    fun onLike(view: View) : Unit
    {
        viewModel.onLike()
    }


    // Установка значений в макете
    private fun updateName() : Unit
    {
        findViewById<TextView>(R.id.plain_name).text = viewModel.name
        findViewById<TextView>(R.id.plain_lastName).text = viewModel.lastName
    }


    // 
    private fun updateLikes()
    {
        findViewById<TextView>(R.id.label_likes).text = viewModel.counterLikes.toString()
        findViewById<ProgressBar>(R.id.progressBar).progress = (viewModel.counterLikes * 100 / 5)
            .coerceAtMost(100)

        val image: ImageView = findViewById<ImageView>(R.id.imageView)
    }
}