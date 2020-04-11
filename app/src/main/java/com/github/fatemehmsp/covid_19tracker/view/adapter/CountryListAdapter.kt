package com.github.fatemehmsp.covid_19tracker.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.fatemehmsp.covid_19tracker.databinding.RowCountryListBinding
import com.github.fatemehmsp.covid_19tracker.model.CountryModel

/**
 * Created by Fatemeh Movassaghpour on 4/11/2020.
 */
class CountryListAdapter :
    PagedListAdapter<CountryModel, CountryListAdapter.ViewHolder>(COUNTRY_COMPARATOR) {

    private lateinit var binding: RowCountryListBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = RowCountryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            getItem(position)?.let {
                name.text = it.country
                newCase.text = it.newCase
                loadImage(flag, it.flag)
            }
        }
    }

    private fun loadImage(flag: AppCompatImageView, url: String) {
        Glide
            .with(flag.context)
            .load(url)
            .into(flag)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val flag: AppCompatImageView = binding.countryFlag
        val name: TextView = binding.countryName
        val newCase: TextView = binding.countryNewCase
    }

    companion object {
        private val COUNTRY_COMPARATOR = object : DiffUtil.ItemCallback<CountryModel>() {
            override fun areItemsTheSame(oldItem: CountryModel, newItem: CountryModel): Boolean =
                oldItem.flag == newItem.flag

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: CountryModel, newItem: CountryModel): Boolean =
                newItem == oldItem
        }
    }


}