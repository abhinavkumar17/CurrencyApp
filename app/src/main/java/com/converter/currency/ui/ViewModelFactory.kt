package com.converter.currency.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(val currencyRatesUseCase : CurrencyRatesUseCase)
    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            if (isAssignableFrom(CurrencyRatesViewModel::class.java)) {
                CurrencyRatesViewModel(currencyRatesUseCase)
            } else {
                throw IllegalArgumentException("Unable to construct ${modelClass.name}")
            }
        } as T
}