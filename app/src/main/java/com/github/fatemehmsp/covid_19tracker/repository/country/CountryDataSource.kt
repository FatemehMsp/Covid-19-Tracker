package com.github.fatemehmsp.covid_19tracker.repository.country

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.github.fatemehmsp.covid_19tracker.di.scope.CoroutineScropeIO
import com.github.fatemehmsp.covid_19tracker.model.CountryModel
import com.github.fatemehmsp.covid_19tracker.network.ApiResponse
import com.github.fatemehmsp.covid_19tracker.repository.Resource
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

    var networkState = MutableLiveData<Resource<ApiResponse>>()

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
        networkState.postValue(Resource.Loading(null))
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
                is Resource.Success ->{
                    networkState.postValue(Resource.Success(ApiResponse()))
                    callback(response.data?.data?.rows!!)
                }
                is Resource.Error ->
                    networkState.postValue(Resource.Error(response.message!!))

            }
        }
    }

    companion object {
        const val PAGE = 1
        const val LIMIT = 15
    }
}