package com.example.sampledatabinding.data

import androidx.lifecycle.ViewModel

class SimpleViewModel : ViewModel()
{
    val name: String = "John"
    val lastName: String = "Smith"

    // Предотвращение от изменений извне
    var counterLikes: Int = 0
        private set

    // Увеличение счетчика лайков
    fun onLike() : Unit
    {
        counterLikes++
    }

    // Получение категории популярности
    val popularity: Popularity
        get()
        {
            return when{
                counterLikes >= 10 -> Popularity.STAR
                counterLikes >= 5 -> Popularity.POPULAR
                else -> Popularity.NORMAL
            }
        }
}