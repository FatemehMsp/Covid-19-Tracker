package com.github.fatemehmsp.covid_19tracker.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.github.fatemehmsp.covid_19tracker.databinding.RowCountryListBinding
import com.github.fatemehmsp.covid_19tracker.model.CountryModel

/**
 * Created by Fatemeh Movassaghpour on 4/11/2020.
 */
class CountryListAdapter :
    PagedListAdapter<CountryModel, CountryListAdapter.ViewHolder>(COUNTRY_COMPARATOR) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RowCountryListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            getItem(position)?.let {
                holder.onBind(it)
            }
    }

    private fun loadImage(flag: AppCompatImageView, url: String) {
        Glide
            .with(flag.context)
            .load(url)
            .into(flag)
    }

    inner class ViewHolder(private val binding: RowCountryListBinding) :
        BaseViewHolder<CountryModel>(binding) {

        override fun onBind(country: CountryModel) {
            binding.countryName.text = country.country
            binding.countryNewCase.text = country.newCase
            loadImage(binding.countryFlag, country.flag)
        }
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