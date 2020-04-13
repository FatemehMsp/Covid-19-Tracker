package com.github.fatemehmsp.covid_19tracker.repository.country

import com.github.fatemehmsp.covid_19tracker.network.ApiResponse
import com.github.fatemehmsp.covid_19tracker.repository.Resource

/**
 * Created by Fatemeh Movassaghpour on 4/7/2020.
 */
interface CountryRepository {
    suspend fun getAllCountry(limit: Int, page: Int): Resource<ApiResponse>
}