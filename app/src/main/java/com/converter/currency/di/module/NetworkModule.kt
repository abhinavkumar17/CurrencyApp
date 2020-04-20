package com.converter.currency.di.module

import android.util.Log
import com.converter.currency.ui.CurrencyRatesUseCase
import com.converter.currency.usecase.GetLatestCurrencyRates
import com.converter.currency.utils.Constants.MAIN_APPLICATION
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

@Module
object NetworkModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun loggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.i(MAIN_APPLICATION, message)
            }
        })
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        return interceptor
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun okHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun getConverterFragmentRepository(getLatestCurrencyRates: GetLatestCurrencyRates): CurrencyRatesUseCase {
        return CurrencyRatesUseCase(getLatestCurrencyRates)
    }
}