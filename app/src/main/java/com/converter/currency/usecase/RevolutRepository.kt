package com.converter.currency.usecase

import com.converter.currency.data.RevolutBaseResponse
import com.converter.currency.data.remote.DataSourceNetwork
import io.reactivex.Observable
import javax.inject.Inject

class RevolutRepository @Inject constructor(private val dataSourceNetwork: DataSourceNetwork) {

    fun getLatestCurrencyRates(baseRate: String): Observable<RevolutBaseResponse> {
        return dataSourceNetwork.getLatestCurrencyRates(baseRate)
    }
}