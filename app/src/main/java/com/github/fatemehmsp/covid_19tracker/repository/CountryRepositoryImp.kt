package com.github.fatemehmsp.covid_19tracker.repository

import com.github.fatemehmsp.covid_19tracker.network.ApiResponse
import com.github.fatemehmsp.covid_19tracker.network.ApiService
import javax.inject.Inject

/**
 * Created by Fatemeh Movassaghpour on 4/7/2020.
 */
class CountryRepositoryImp @Inject constructor(private val apiService: ApiService) :
    CountryRepository, BaseDataSource() {

    override suspend fun getAllCountry(limit: Int, page: Int): Resource<ApiResponse> =
        getResult { apiService.getCountryList(limit, page) }
}