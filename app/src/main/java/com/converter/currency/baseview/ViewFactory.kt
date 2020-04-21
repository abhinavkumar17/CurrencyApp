package com.converter.currency.baseview

import android.view.LayoutInflater
import android.view.ViewGroup
import com.converter.currency.ui.view.CurrencyRatesView
import com.converter.currency.ui.view.CurrencyRatesViewImpl
import javax.inject.Inject

class ViewFactory @Inject constructor(){

    fun <T : ViewRoot?> newInstance(
        mvcViewClass: Class<T>,
        inflater: LayoutInflater,
        container: ViewGroup?
    ): T {
        val viewMvc: ViewRoot
        if (mvcViewClass == CurrencyRatesView::class.java) {
            viewMvc = CurrencyRatesViewImpl(inflater, container)
        } else {
            throw IllegalArgumentException("unsupported MVC view class $mvcViewClass")
        }
        return viewMvc as T
    }
}