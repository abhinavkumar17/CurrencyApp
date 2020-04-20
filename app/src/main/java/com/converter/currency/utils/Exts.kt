package com.converter.currency.utils

import android.widget.EditText
import androidx.fragment.app.Fragment
import com.converter.currency.ui.CurrencyRatesUseCase
import com.converter.currency.ui.ViewModelFactory

fun Fragment.getViewModelFactory(currencyRatesUseCase : CurrencyRatesUseCase): ViewModelFactory {
    return ViewModelFactory(currencyRatesUseCase)
}

fun EditText.placeCursorToProperDigitPosition() {
    this.setSelection(this.text.split(".")[0].length)
}