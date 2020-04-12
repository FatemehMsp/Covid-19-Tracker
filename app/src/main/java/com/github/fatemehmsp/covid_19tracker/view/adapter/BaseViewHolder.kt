package com.github.fatemehmsp.covid_19tracker.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Created by Fatemeh Movassaghpour on 12/28/2019.
 */
abstract class BaseViewHolder<T>(binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun onBind(t: T)
}