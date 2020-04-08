package com.github.fatemehmsp.covid_19tracker.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.github.fatemehmsp.covid_19tracker.di.CoroutineScropeIO
import com.github.fatemehmsp.covid_19tracker.model.CountryModel
import com.github.fatemehmsp.covid_19tracker.repository.CountryDataSource
import com.github.fatemehmsp.covid_19tracker.repository.CountryDataSourceFactory
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
    val loadingProgressBar: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>(false) }


/*    init {
        Log.i(TAG,"startttttttt")
        getData()
    }*/

    fun getData() {
        Log.i("123456asd", "startttttttt")
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setPageSize(CountryDataSource.LIMIT)
            .build()
        countries = LivePagedListBuilder(countryDataSourceFactory, pagedListConfig)
            .build()
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }

}
