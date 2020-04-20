package com.converter.currency.usecase

import com.converter.currency.data.BaseResponse
import com.converter.currency.data.remote.DataSourceNetwork
import io.reactivex.Observable
import javax.inject.Inject

class CurrencyRatesRepository @Inject constructor(private val dataSourceNetwork: DataSourceNetwork) {

    fun getLatestCurrencyRates(baseRate: String): Observable<BaseResponse> {
        return dataSourceNetwork.getLatestCurrencyRates(baseRate)
    }
}