package com.github.fatemehmsp.covid_19tracker.repository

import com.github.fatemehmsp.covid_19tracker.network.ApiResponse
import com.github.fatemehmsp.covid_19tracker.util.Output

/**
 * Created by Fatemeh Movassaghpour on 4/7/2020.
 */
interface CountryRepository {
    suspend fun getAllCountry(limit: Int, page: Int): Output<ApiResponse>
}