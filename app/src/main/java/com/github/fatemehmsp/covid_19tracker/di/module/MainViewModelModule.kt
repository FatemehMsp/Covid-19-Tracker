package com.github.fatemehmsp.covid_19tracker.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.fatemehmsp.covid_19tracker.di.ViewModelKey
import com.github.fatemehmsp.covid_19tracker.viewModel.HomeViewModel
import com.github.fatemehmsp.covid_19tracker.viewModel.MainViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Fatemeh Movassaghpour on 4/8/2020.
 */
@Module
interface MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    abstract fun bindMainViewModelFactory(viewModelFactory: MainViewModelFactory): ViewModelProvider.Factory
}