package com.github.fatemehmsp.covid_19tracker.repository

import android.util.Log
import retrofit2.Response

/**
 * Created by Fatemeh Movassaghpour on 4/8/2020.
 */
abstract class BaseDataSource {

    private val TAG = BaseDataSource::class.java.simpleName

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Resource.Success(
                    body
                )
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Resource<T> {
        Log.e(TAG, message)
        return Resource.Error("Network call has failed for a following reason: $message")
    }
}