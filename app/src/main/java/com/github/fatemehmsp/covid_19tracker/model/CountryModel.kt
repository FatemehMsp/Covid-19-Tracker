package com.github.fatemehmsp.covid_19tracker.model

import com.squareup.moshi.Json

/**
 * Created by Fatemeh Movassaghpour on 4/7/2020.
 */
data class CountryModel(
    var country: String,
    @Json(name = "total_cases")
    var totalCase: String,
    @Json(name = "new_cases")
    var newCase: String,
    @Json(name = "total_deaths")
    var totalDeaths: String,
    @Json(name = "new_deaths")
    var newDeaths: String,
    @Json(name = "total_recovered")
    var totalRecovered: String,
    @Json(name = "active_cases")
    var activeCase: String,
    @Json(name = "serious_critical")
    var seriousCritical: String,
    @Json(name = "cases_per_mill_pop")
    var casesPerMillPop: String,
    var flag: String
)