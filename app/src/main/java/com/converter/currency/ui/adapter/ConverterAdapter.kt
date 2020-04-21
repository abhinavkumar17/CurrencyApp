package com.converter.currency.ui.adapter

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.converter.currency.R
import com.converter.currency.model.Currency
import com.converter.currency.utils.Constants.BASE_CURRENCY_EURO
import com.converter.currency.utils.ResourcesUtils

class ConverterAdapter() :
    RecyclerView.Adapter<CurrencyViewHolder>() {

    enum class PayLoad {
        VALUE
    }

    private var mTtems: ArrayList<Currency>? = null
    var mCurrentBaseSymbol = BASE_CURRENCY_EURO
    var mCurrentBaseValue = 100.0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_rate, parent, false)
        return CurrencyViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return mTtems?.size ?: 0
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val currency = mTtems?.get(position) ?: return
        val symbol = currency.symbol
        holder.imageCurrencyFlag.setImageResource(
            ResourcesUtils.getCurrencyFlagId(
                holder.currencyValue.context,
                symbol
            )
        )
        holder.textCurrencyCode.text = symbol
        holder.textCurrencyName.setText(
            ResourcesUtils.getCurrencyNameId(
                holder.currencyValue.context,
                symbol
            )
        )

        holder.currencyValue.setText(String.format("%.2f", currency.value))

        holder.view.setOnClickListener {
            holder.currencyValue.requestFocus()
        }

        holder.currencyValue.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) return@setOnFocusChangeListener
            moveItem(position)
        }

        if (position == 0) {
            mCurrentBaseSymbol = currency.symbol
            mCurrentBaseValue = currency.value
            holder.setIsRecyclable(false)
        } else {
            holder.setIsRecyclable(true)
        }

        holder.currencyValue.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.isNullOrEmpty() || (currency.symbol != mCurrentBaseSymbol) || position != 0 || !holder.currencyValue.isFocused) return
                mCurrentBaseValue = p0.toString().toDouble()
            }
        })
    }

    fun updateItems(list: ArrayList<Currency>) {
        if (mTtems.isNullOrEmpty()) {
            mTtems = list
            mTtems?.add(0, Currency(mCurrentBaseSymbol, mCurrentBaseValue))
        } else {
            mTtems?.forEach { currency ->
                val symbol = currency.symbol
                var value = mCurrentBaseValue
                list.forEach {
                    if (symbol == it.symbol) {
                        value = it.value * mCurrentBaseValue
                    }
                }
                currency.value = value
            }
        }
        notifyItemRangeChanged(1, itemCount - 1, PayLoad.VALUE)
    }

    private fun moveItem(fromPosition: Int) {
        if (fromPosition == 0) return

        mTtems?.removeAt(fromPosition).also {
            val currency = it ?: return@also
            mTtems?.add(0, currency)
            //listener.onSymbolChanged(currency)
        }

        notifyItemMoved(fromPosition, 0)
        notifyItemChanged(0)
    }
}