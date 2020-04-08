package com.github.fatemehmsp.covid_19tracker.di

import android.content.Context
import com.github.fatemehmsp.covid_19tracker.App
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Fatemeh Movassaghpour on 4/8/2020.
 */
@Singleton
@Component(modules = [AppModule::class, SubAppComponent::class])
interface AppComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun mainComponent(): MainComponent.Factory
}