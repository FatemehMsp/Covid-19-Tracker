package com.github.fatemehmsp.covid_19tracker.di.component

import com.github.fatemehmsp.covid_19tracker.di.module.MainViewModelModule
import com.github.fatemehmsp.covid_19tracker.di.scope.MainScope
import com.github.fatemehmsp.covid_19tracker.view.fragment.HomeFragment
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