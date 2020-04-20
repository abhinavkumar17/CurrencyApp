package com.converter.currency.mapper

import com.converter.currency.data.BaseResponse
import com.converter.currency.model.Currency
import com.converter.currency.model.LatestCurrencies
import com.converter.currency.utils.Constants.BASE_CURRENCY_EURO

class LatestCurrenciesMapper : Mapper<BaseResponse, LatestCurrencies> {
    override fun mapToEntity(response: BaseResponse): LatestCurrencies {
        val currencyRates = ArrayList<Currency>()

        val base = response.base ?: BASE_CURRENCY_EURO
        val rates = response.rates
        rates?.forEach {
            currencyRates.add(Currency(it.key, it.value))
        }
        return LatestCurrencies(base, currencyRates)
    }
}