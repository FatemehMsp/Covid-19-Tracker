package com.github.fatemehmsp.covid_19tracker.di.component

import com.github.fatemehmsp.covid_19tracker.di.scope.MainScope
import com.github.fatemehmsp.covid_19tracker.view.fragment.HomeFragment
import dagger.Subcomponent

/**
 * Created by Fatemeh Movassaghpour on 4/8/2020.
 */
@MainScope
@Subcomponent
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainComponent
    }

    fun inject(homeFragment: HomeFragment)

}