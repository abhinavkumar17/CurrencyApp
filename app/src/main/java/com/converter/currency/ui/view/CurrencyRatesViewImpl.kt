package com.converter.currency.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.converter.currency.baseview.BaseView
import com.converter.currency.databinding.FragmentConverterBinding
import com.converter.currency.model.Currency
import com.converter.currency.ui.adapter.ConverterAdapter

class CurrencyRatesViewImpl constructor() : BaseView<CurrencyRatesView.Listener>(), CurrencyRatesView {

    private lateinit var mViewDataBinding: FragmentConverterBinding
    private lateinit var mConverterAdapter: ConverterAdapter

    constructor(inflater: LayoutInflater, container: ViewGroup?) : this() {
        mViewDataBinding = FragmentConverterBinding.inflate(inflater)
        setRootView(mViewDataBinding.root)
        mConverterAdapter = ConverterAdapter()
        mViewDataBinding.recyclerView.layoutManager = LinearLayoutManager(getContext())
        mViewDataBinding.recyclerView.adapter = mConverterAdapter
    }


    override fun showProgressIndication() {
        mViewDataBinding.progressbar.visibility = View.VISIBLE
    }

    override fun hideProgressIndication() {
        mViewDataBinding.progressbar.visibility = View.GONE
    }

    override fun updateItems(currencyRates: ArrayList<Currency>) {
        mViewDataBinding.textView.visibility = View.VISIBLE
        mConverterAdapter.updateItems(currencyRates)
    }

}