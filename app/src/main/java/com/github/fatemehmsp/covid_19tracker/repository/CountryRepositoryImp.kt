package com.github.fatemehmsp.covid_19tracker.repository

import com.github.fatemehmsp.covid_19tracker.network.ApiResponse
import com.github.fatemehmsp.covid_19tracker.network.ApiService
import com.github.fatemehmsp.covid_19tracker.util.Output
import java.lang.Exception
import javax.inject.Inject

/**
 * Created by Fatemeh Movassaghpour on 4/7/2020.
 */
class CountryRepositoryImp @Inject constructor(private val apiService: ApiService) :
    CountryRepository {

    override suspend fun getAllCountry(limit: Int, page: Int): Output<ApiResponse> {
        return try {
            val countries = apiService.getCountryList(limit, page).await()
            Output.Success(countries)
        } catch (e: Exception) {
            Output.Error(e)
        }

    }
}