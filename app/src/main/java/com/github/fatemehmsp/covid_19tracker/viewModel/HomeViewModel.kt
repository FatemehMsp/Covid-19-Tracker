package com.github.fatemehmsp.covid_19tracker.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.github.fatemehmsp.covid_19tracker.di.scope.CoroutineScropeIO
import com.github.fatemehmsp.covid_19tracker.model.CountryModel
import com.github.fatemehmsp.covid_19tracker.network.ApiResponse
import com.github.fatemehmsp.covid_19tracker.repository.Resource
import com.github.fatemehmsp.covid_19tracker.repository.country.CountryDataSource
import com.github.fatemehmsp.covid_19tracker.repository.country.CountryDataSourceFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import javax.inject.Inject

/**
 * Created by Fatemeh Movassaghpour on 4/7/2020.
 */
class HomeViewModel @Inject constructor(
    private val countryDataSourceFactory: CountryDataSourceFactory
    , @CoroutineScropeIO private val scope: CoroutineScope
) :
    ViewModel() {

    private val TAG: String = HomeViewModel::class.java.simpleName

    var countries: LiveData<PagedList<CountryModel>>? = null
    var networkState: LiveData<Resource<ApiResponse>>? =null


    init {
        getData()
    }

    private fun getData() {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setPageSize(PAGE_SIZE)
            .build()
       countries =  LivePagedListBuilder(countryDataSourceFactory, pagedListConfig)
            .build()

        networkState = Transformations.switchMap(
            countryDataSourceFactory.countryDataSourceLiveData,
            CountryDataSource::networkState)
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }

    companion object {
        const val PAGE_SIZE = 10
    }
}
