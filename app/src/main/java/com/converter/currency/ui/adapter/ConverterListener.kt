package com.converter.currency.ui.adapter

import com.converter.currency.model.Currency

interface ConverterListener {
    fun onSymbolChanged(currency: Currency)
}