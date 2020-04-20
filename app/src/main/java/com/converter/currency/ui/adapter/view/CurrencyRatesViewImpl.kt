package com.converter.currency.ui.adapter.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.converter.currency.baseview.BaseView
import com.converter.currency.databinding.FragmentConverterBinding
import com.converter.currency.model.Currency
import com.converter.currency.ui.adapter.ConverterAdapter

class CurrencyRatesViewImpl constructor() : BaseView<CurrencyRatesView.Listener>(), CurrencyRatesView {

    private lateinit var viewDataBinding: FragmentConverterBinding
    private lateinit var mConverterAdapter: ConverterAdapter

    constructor(inflater: LayoutInflater, container: ViewGroup?) : this() {
        viewDataBinding = FragmentConverterBinding.inflate(inflater)
        setRootView(viewDataBinding.root)
        mConverterAdapter = ConverterAdapter()
        viewDataBinding.recyclerView.layoutManager = LinearLayoutManager(getContext())
        viewDataBinding.recyclerView.adapter = mConverterAdapter
    }


    override fun showProgressIndication() {
        viewDataBinding.progressbar.visibility = View.GONE
    }

    override fun hideProgressIndication() {
        viewDataBinding.progressbar.visibility = View.GONE
    }

    override fun updateItems(currencyRates: ArrayList<Currency>) {
        mConverterAdapter.updateItems(currencyRates)
    }

}