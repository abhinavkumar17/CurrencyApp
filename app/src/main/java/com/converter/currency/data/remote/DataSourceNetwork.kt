package com.converter.currency.data.remote

import com.converter.currency.data.DataSource
import com.converter.currency.data.RevolutBaseResponse
import io.reactivex.Observable
import javax.inject.Inject

class DataSourceNetwork @Inject constructor(private val revolutService: RevolutService) :
    DataSource {
    override fun getLatestCurrencyRates(base: String): Observable<RevolutBaseResponse> {
        return revolutService.getLatestCurrencyRates(base)
    }
}