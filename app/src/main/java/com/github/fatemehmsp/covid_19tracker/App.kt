package com.github.fatemehmsp.covid_19tracker

import android.app.Application
import com.github.fatemehmsp.covid_19tracker.di.AppComponent
import com.github.fatemehmsp.covid_19tracker.di.DaggerAppComponent

/**
 * Created by Fatemeh Movassaghpour on 4/8/2020.
 */
class App : Application() {

    private lateinit var applicationComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerAppComponent.factory().create(applicationContext)
    }

    fun getApplicationComponent() = applicationComponent
}