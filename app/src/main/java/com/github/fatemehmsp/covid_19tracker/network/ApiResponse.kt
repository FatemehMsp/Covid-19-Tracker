package com.github.fatemehmsp.covid_19tracker.network

import com.github.fatemehmsp.covid_19tracker.model.CountryModel
import com.squareup.moshi.Json

/**
 * Created by Fatemeh Movassaghpour on 4/7/2020.
 */
class ApiResponse {
    var data: Data? = null
    var status: String? = ""
}

class Data {
    @Json(name = "last_update")
    var lastUpdate: String? = ""
    var rows: MutableList<CountryModel>? = arrayListOf()
}