package com.github.fatemehmsp.covid_19tracker.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.github.fatemehmsp.covid_19tracker.databinding.FragmentCountryDetailBinding
import com.github.fatemehmsp.covid_19tracker.model.CountryModel


/**
 * Created by Fatemeh Movassaghpour on 4/13/2020.
 */
class CountryDetailFragment : Fragment(){

    private var _binding: FragmentCountryDetailBinding? = null
    private val binding
        get() = _binding!!
    private val args : CountryDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCountryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val country = args.countrySelected
        setData(country)

        binding.detailBack.setOnClickListener {}
    }

    private fun setData(country: CountryModel) {
        loadFlag(country.flag)
        binding.detailTotalCase.text = country.totalCase
        binding.detailNewCase.text = country.newCase
        binding.detailTotalDeaths.text = country.totalDeaths
        binding.detailTotalRecovered.text = country.totalRecovered
        binding.detailNewDeath.text = country.newDeaths
        binding.detailSeriousCritical.text = country.seriousCritical
    }

    private fun loadFlag(flag: String) {
        Glide.with(binding.detailFlag)
            .load(flag)
            .into(binding.detailFlag)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}