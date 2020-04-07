package com.github.fatemehmsp.covid_19tracker.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/**
 * Created by Fatemeh Movassaghpour on 4/7/2020.
 */
abstract class BaseViewModel : ViewModel(), CoroutineScope {

    protected val job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}