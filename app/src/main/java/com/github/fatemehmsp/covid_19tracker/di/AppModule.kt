package com.github.fatemehmsp.covid_19tracker.di

import com.github.fatemehmsp.covid_19tracker.network.ApiService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Fatemeh Movassaghpour on 4/8/2020.
 */
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(
        moshiConverterFactory: MoshiConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(moshiConverterFactory)
            //.addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideMoshiConverterFactory() = MoshiConverterFactory.create()

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        //create okHttp client
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit) =
        retrofit.create(ApiService::class.java)

    @CoroutineScropeIO
    @Provides
    fun provideCoroutineScope() = CoroutineScope(Dispatchers.IO)


    companion object {
        val BASE_URL = "https://corona-virus-stats.herokuapp.com"

        // timeouts
        val CONNECT_TIMEOUT: Long = 20
        val READ_TIMEOUT: Long = 40
        val WRITE_TIMEOUT: Long = 120
    }
}