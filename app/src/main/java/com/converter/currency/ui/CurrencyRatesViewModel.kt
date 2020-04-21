package com.converter.currency.ui

import androidx.lifecycle.ViewModel
import com.converter.currency.model.Currency
import javax.inject.Inject

class CurrencyRatesViewModel @Inject constructor(
    var mCurrencyRatesUseCase: CurrencyRatesUseCase) : ViewModel(),
     CurrencyRatesUseCase.Listener {

    init {
        mCurrencyRatesUseCase.registerListener(this)
    }


    interface Listener{
        fun onFetchCurrencySucessAndNotify(currencyRates: ArrayList<Currency>)
        fun onFetchCurrencyFailAndNotify()
    }

    override fun onCleared() {
        super.onCleared()
        mCurrencyRatesUseCase.unregisterListener(this)
    }

    val mListeners = mutableSetOf<Listener>()

    fun registerListener(listener: Listener) {
        mListeners.add(listener)
    }

    fun getData(){
        mCurrencyRatesUseCase.getLatestCurrencyRates()
    }

    fun unregisterListener(listener: Listener) {
        mListeners.remove(listener)
    }

    override fun onFetchCurrencytSucessAndNotify(currencyRates: ArrayList<Currency>) {
        for (listener in mListeners) {
            listener.onFetchCurrencySucessAndNotify(currencyRates)
        }
    }

    override fun onFetchCurrencyFailed() {
        for (listener in mListeners) {
            listener.onFetchCurrencyFailAndNotify()
        }
    }

}