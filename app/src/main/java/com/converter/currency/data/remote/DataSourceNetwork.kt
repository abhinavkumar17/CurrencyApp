package com.converter.currency.data.remote

import com.converter.currency.data.DataSource
import com.converter.currency.data.BaseResponse
import io.reactivex.Observable
import javax.inject.Inject

class DataSourceNetwork @Inject constructor(private val dataService: DataService) :
    DataSource {
    override fun getLatestCurrencyRates(base: String): Observable<BaseResponse> {
        return dataService.getLatestCurrencyRates(base)
    }
}