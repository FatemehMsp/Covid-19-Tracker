package com.github.fatemehmsp.covid_19tracker.network

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Fatemeh Movassaghpour on 4/7/2020.
 */
interface ApiService {

    @GET("/api/v1/cases/countries-search")
    fun getCountryList(
        @Query("limit") limit: Int,
        @Query("page") page: Int
    ): Deferred<ApiResponse>

}