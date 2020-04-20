package com.converter.currency.ui

import androidx.lifecycle.ViewModel
import com.converter.currency.model.Currency
import javax.inject.Inject

class CurrencyRatesViewModel @Inject constructor(
    var currencyRatesUseCase: CurrencyRatesUseCase) : ViewModel()
    ,CurrencyRatesUseCase.Listener {

    init {
        currencyRatesUseCase.registerListener(this)
    }


    interface Listener{
        fun onFetchProductSecessAndNotify(currencyRates: ArrayList<Currency>)
        fun onFetchProductFailAndNotify()
    }

    override fun onCleared() {
        super.onCleared()
        currencyRatesUseCase.unregisterListener(this)
    }

    val mListeners = mutableSetOf<Listener>()

    fun registerListener(listener: Listener) {
        mListeners.add(listener)
    }

    fun getData(){
        currencyRatesUseCase.getLatestCurrencyRates()
    }

    fun unregisterListener(listener: Listener) {
        mListeners.remove(listener)
    }

    override fun onFetchProductSecessAndNotify(currencyRates: ArrayList<Currency>) {
        for (listener in mListeners) {
            listener.onFetchProductSecessAndNotify(currencyRates)
        }
    }

    override fun onFetchProductFailed() {
        for (listener in mListeners) {
            listener.onFetchProductFailAndNotify()
        }
    }

}