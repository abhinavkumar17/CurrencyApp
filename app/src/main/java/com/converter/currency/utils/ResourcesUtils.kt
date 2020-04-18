package com.converter.currency.utils

import android.content.Context
import com.converter.currency.utils.Constants.CURRENCY_FLAG
import com.converter.currency.utils.Constants.CURRENCY_NAME
import com.converter.currency.utils.Constants.DRAWABLE
import com.converter.currency.utils.Constants.STRING
import java.util.*

object ResourcesUtils {

    fun getCurrencyNameId(context: Context, symbol: String) =
        context.resources.getIdentifier(
            CURRENCY_NAME + symbol.toLowerCase(Locale.ROOT), STRING, context.packageName
        )

    fun getCurrencyFlagId(context: Context, symbol: String) =
        context.resources.getIdentifier(
            CURRENCY_FLAG + symbol.toLowerCase(Locale.ROOT), DRAWABLE, context.packageName
        )
}