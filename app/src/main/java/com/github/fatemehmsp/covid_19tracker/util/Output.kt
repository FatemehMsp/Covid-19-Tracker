package com.github.fatemehmsp.covid_19tracker.util

import java.lang.Exception
import java.text.Annotation

/**
 * Created by Fatemeh Movassaghpour on 4/7/2020.
 */
sealed class Output<out T : Any> {

    data class Success<out T : Any>(val output: T) : Output<T>()
    data class Error(val exception: Exception) : Output<Nothing>()

}