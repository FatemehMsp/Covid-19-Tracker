package com.github.fatemehmsp.covid_19tracker.repository

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.github.fatemehmsp.covid_19tracker.di.CoroutineScropeIO
import com.github.fatemehmsp.covid_19tracker.model.CountryModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Fatemeh Movassaghpour on 4/7/2020.
 */
class CountryDataSource @Inject constructor(
    private val countryRepositoryImp: CountryRepositoryImp,
    @CoroutineScropeIO private val scope: CoroutineScope
) : PageKeyedDataSource<Int, CountryModel>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, CountryModel>
    ) {
        fetchData(PAGE) {
            callback.onResult(
                it,
                PAGE, PAGE + 1
            )
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, CountryModel>) {
        fetchData(params.key) {
            callback.onResult(it, params.key + 1)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CountryModel>) {}

    private fun fetchData(page: Int, callback: (List<CountryModel>) -> Unit) {
        scope.launch {
            val response = countryRepositoryImp.getAllCountry(
                LIMIT,
                page
            )
            when (response) {
                is Resource.Success ->
                    callback(response.data?.data?.rows!!)
                is Resource.Error ->
                    postError(response.message!!)

            }
        }
    }

    private fun postError(message: String) {
        Log.e("An error happened: ", message)
        // TODO network error handling
        //networkState.postValue(NetworkState.FAILED)
    }

    companion object {
        const val PAGE = 1
        const val LIMIT = 10
    }
}