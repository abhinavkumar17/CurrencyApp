package com.converter.currency.ui.view

import com.converter.currency.baseview.ObservableView
import com.converter.currency.model.Currency

interface CurrencyRatesView : ObservableView<CurrencyRatesView.Listener> {
    interface Listener {

    }

    fun showProgressIndication()
    fun hideProgressIndication()
    fun updateItems(currencyRates: ArrayList<Currency>)
    fun setServerError()
}