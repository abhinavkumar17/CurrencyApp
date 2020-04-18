package com.converter.currency.model

data class LatestCurrencies(
    val baseCurrencySymbol: String,
    val currencyRates: ArrayList<Currency>
)