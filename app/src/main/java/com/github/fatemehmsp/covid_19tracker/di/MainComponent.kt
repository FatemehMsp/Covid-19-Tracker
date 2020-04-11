package com.github.fatemehmsp.covid_19tracker.di

import com.github.fatemehmsp.covid_19tracker.App
import com.github.fatemehmsp.covid_19tracker.view.HomeFragment
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent

/**
 * Created by Fatemeh Movassaghpour on 4/8/2020.
 */
@MainScope
@Subcomponent(modules = [MainViewModelModule::class])
interface MainComponent {

    // Factory to create instances of RegistrationComponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(homeFragment: HomeFragment)

}