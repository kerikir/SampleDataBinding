package com.example.sampledatabinding.ui

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.sampledatabinding.R
import com.example.sampledatabinding.data.Popularity
import com.example.sampledatabinding.data.SimpleViewModel
import com.example.sampledatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private val viewModel by lazy {
        ViewModelProvider(this).get(SimpleViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        // Установка макета в активности
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Указание Lifecycle Owner так как поддерживает собятия жизненного цикла
        binding.lifecycleOwner = this

        // Устанавливаем переменные макета
        binding.viewmodel = viewModel
    }
}