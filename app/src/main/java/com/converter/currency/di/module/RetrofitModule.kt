package com.converter.currency.di.module

import com.converter.currency.baseview.ViewFactory
import com.converter.currency.data.remote.DataService
import com.converter.currency.utils.Constants
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
object RetrofitModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun gSon() = Gson()

    @Provides
    @Reusable
    @JvmStatic
    internal fun retrofit(okHttpClient: OkHttpClient, gson: Gson) =
        Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient).build()


    @Provides
    @Reusable
    @JvmStatic
    internal fun dataService(retrofit: Retrofit) =
        retrofit.create(DataService::class.java)

    @Provides
    @Reusable
    @JvmStatic
    internal fun getViewFactory() = {
          ViewFactory()
    }
}