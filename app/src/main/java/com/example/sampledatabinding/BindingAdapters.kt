package com.example.sampledatabinding

import android.view.View
import androidx.databinding.BindingAdapter

class BindingAdapters
{
    @BindingAdapter("app:hideIfZero")
        fun hideIfZero(view: View, number: Int)
        {
            view.visibility = if (number == 0) View.GONE else View.VISIBLE
        }
}