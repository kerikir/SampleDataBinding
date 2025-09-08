package com.example.sampledatabinding.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class SimpleViewModel : ViewModel()
{
    val name: String = "John"
    val lastName: String = "Smith"

    // Скрываем изменения извне
    private val _counterLikes = MutableLiveData<Int>(0)
    val counterLikes: LiveData<Int> = _counterLikes


    // Увеличение счетчика лайков
    fun onLike() : Unit
    {
        // Оператор элвис
        _counterLikes.value = (_counterLikes.value ?: 0) + 1
    }


    // Получение категории популярности
    // Live Data зависима от другой - обновление UI при изменении значения
    val popularity: LiveData<Popularity> = _counterLikes.map { likes ->
        when {
            likes >= 10 -> Popularity.STAR
            likes >= 5 -> Popularity.POPULAR
            else -> Popularity.NORMAL
        }
    }
}