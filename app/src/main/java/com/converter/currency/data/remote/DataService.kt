package com.converter.currency.data.remote

import com.converter.currency.data.BaseResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface DataService {
    @GET("latest")
    fun getLatestCurrencyRates(@Query("base") baseCurrencyCode: String): Observable<BaseResponse>
}