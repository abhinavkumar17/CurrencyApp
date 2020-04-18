package com.converter.currency.ui

import com.converter.currency.model.Currency

interface ConverterContract {

    interface View {

        fun updateValues(value: ArrayList<Currency>)
    }

    interface Presenter {

        fun attachView(view: View)

        fun detachView()
    }
}