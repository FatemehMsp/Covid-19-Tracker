package com.github.fatemehmsp.covid_19tracker.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.github.fatemehmsp.covid_19tracker.model.CountryModel
import com.github.fatemehmsp.covid_19tracker.network.ApiResponse
import com.github.fatemehmsp.covid_19tracker.repository.CountryRepositoryImp
import com.github.fatemehmsp.covid_19tracker.util.Output
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Fatemeh Movassaghpour on 4/7/2020.
 */
class HomeViewModel @Inject constructor(private val countryRepositoryImp: CountryRepositoryImp) :
    BaseViewModel() {

    private val TAG: String = HomeViewModel::class.java.simpleName

    val countries: MutableLiveData<MutableList<CountryModel>> by lazy { MutableLiveData<MutableList<CountryModel>>() }
    val loadingProgressBar: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>(false) }


    suspend fun getCountryList() {
        loadingProgressBar.postValue(true)
        val result = withContext(Dispatchers.IO) {
            countryRepositoryImp.getAllCountry(
                LIMIT,
                PAGE
            )
        }
        showResult(result)
    }

    private fun showResult(result: Output<ApiResponse>) {
        when (result) {
            is Output.Success -> {
                loadingProgressBar.postValue(false)
                countries.postValue(result.output.data?.rows)
            }
            is Output.Error ->
                Log.i(TAG, result.exception.message)
        }
    }

    companion object {
        const val PAGE = 1
        const val LIMIT = 10
    }
}
