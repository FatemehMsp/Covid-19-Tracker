package com.github.fatemehmsp.covid_19tracker.viewModel

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Provider


inline fun <reified VM : ViewModel> Fragment.viewModels(crossinline producer: () -> Provider<VM>): Lazy<VM> =
    viewModels {
        object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(c: Class<T>) = producer().get() as T
        }
    }