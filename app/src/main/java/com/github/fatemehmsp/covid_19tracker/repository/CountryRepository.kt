package com.github.fatemehmsp.covid_19tracker.repository

import com.github.fatemehmsp.covid_19tracker.network.ApiResponse

/**
 * Created by Fatemeh Movassaghpour on 4/7/2020.
 */
interface CountryRepository {
    suspend fun getAllCountry(limit: Int, page: Int): Resource<ApiResponse>
}