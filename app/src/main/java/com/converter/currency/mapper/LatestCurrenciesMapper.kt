package com.converter.currency.mapper

import com.converter.currency.data.RevolutBaseResponse
import com.converter.currency.model.Currency
import com.converter.currency.model.LatestCurrencies
import com.converter.currency.utils.Constants.BASE_CURRENCY_EURO

class LatestCurrenciesMapper : Mapper<RevolutBaseResponse, LatestCurrencies> {
    override fun mapToEntity(response: RevolutBaseResponse): LatestCurrencies {
        val currencyRates = ArrayList<Currency>()

        val base = response.base ?: BASE_CURRENCY_EURO
        val rates = response.rates
        rates?.forEach {
            currencyRates.add(Currency(it.key, it.value))
        }
        return LatestCurrencies(base, currencyRates)
    }
}