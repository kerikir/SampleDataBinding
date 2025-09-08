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

        // Устанавливаем переменные макета
        binding.viewmodel = viewModel

        // Явно указываем начальные значения
        updateLikes()
    }


    // Обновление счетчика лайков и аватара в макете
    private fun updateLikes() : Unit
    {
        findViewById<TextView>(R.id.plain_likes).text = viewModel.counterLikes.toString()
        findViewById<ProgressBar>(R.id.progressBar).progress = (viewModel.counterLikes * 100 / 5)
            .coerceAtMost(100)

        val image: ImageView = findViewById<ImageView>(R.id.imageView)
        image.setImageDrawable(getImage(this, viewModel.popularity))

        val color: Int = getColor(this, viewModel.popularity)
        ImageViewCompat.setImageTintList(image, ColorStateList.valueOf(color))
    }


    // Получение цвета в зависимости от категории популярности
    fun getColor(context: Context, popularity: Popularity) : Int
    {
        return when (popularity)
        {
            Popularity.NORMAL -> context.theme.obtainStyledAttributes(
                intArrayOf(android.R.attr.colorForeground)).getColor(0, 0x000000)

            Popularity.POPULAR -> ContextCompat.getColor(context, R.color.popular)
            Popularity.STAR -> ContextCompat.getColor(context, R.color.star)
        }
    }


    // Получение иконки в зависимости от категории популярности
    fun getImage(context: Context, popularity: Popularity) : Drawable?
    {
        return when (popularity)
        {
            Popularity.NORMAL -> ContextCompat.getDrawable(context, R.drawable.icon_person)
            Popularity.POPULAR -> ContextCompat.getDrawable(context, R.drawable.icon_fire)
            Popularity.STAR -> ContextCompat.getDrawable(context, R.drawable.icon_fire)
        }
    }
}