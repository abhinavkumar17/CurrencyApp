package com.converter.currency.testdata

import com.converter.currency.model.Currency
import java.util.*

object CurrencyTestData {

     fun getCurrency(): ArrayList<Currency> {
        val list: ArrayList<Currency> = ArrayList()
        list.add(Currency("AUD",1.607))
        list.add(Currency("BGN",1.981))
        list.add(Currency("BRL",4.182))
        list.add(Currency("CAD",1.512))
        return list
    }
}