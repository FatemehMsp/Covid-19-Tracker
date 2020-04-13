package com.github.fatemehmsp.covid_19tracker.repository.country

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.github.fatemehmsp.covid_19tracker.model.CountryModel
import com.github.fatemehmsp.covid_19tracker.repository.country.CountryDataSource
import javax.inject.Inject

/**
 * Created by Fatemeh Movassaghpour on 4/7/2020.
 */
class CountryDataSourceFactory @Inject constructor(private val countryDataSource: CountryDataSource) :
    DataSource.Factory<Int, CountryModel>() {

    val countryDataSourceLiveData: MutableLiveData<CountryDataSource> by lazy { MutableLiveData<CountryDataSource>() }

    override fun create(): DataSource<Int, CountryModel> {
        countryDataSourceLiveData.postValue(countryDataSource)
        return countryDataSource
    }
}