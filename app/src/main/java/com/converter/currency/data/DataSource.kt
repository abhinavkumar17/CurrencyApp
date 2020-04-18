package com.converter.currency.data

import io.reactivex.Observable

interface DataSource {

    fun getLatestCurrencyRates(base: String): Observable<RevolutBaseResponse>
}