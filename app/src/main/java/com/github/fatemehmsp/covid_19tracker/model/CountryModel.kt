package com.github.fatemehmsp.covid_19tracker.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by Fatemeh Movassaghpour on 4/7/2020.
 */
data class CountryModel(
    var country: String,
    @SerializedName("total_cases")
    var totalCase: String,
    @SerializedName("new_cases")
    var newCase: String,
    @SerializedName("total_deaths")
    var totalDeaths: String,
    @SerializedName("new_deaths")
    var newDeaths: String,
    @SerializedName("total_recovered")
    var totalRecovered: String,
    @SerializedName("active_cases")
    var activeCase: String,
    @SerializedName("serious_critical")
    var seriousCritical: String,
    @SerializedName("cases_per_mill_pop")
    var casesPerMillPop: String,
    var flag: String
)