package com.converter.currency.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.converter.currency.baseview.BaseFragment
import com.converter.currency.baseview.ViewFactory
import com.converter.currency.model.Currency
import com.converter.currency.ui.CurrencyRatesUseCase
import com.converter.currency.ui.CurrencyRatesViewModel
import com.converter.currency.utils.getViewModelFactory
import javax.inject.Inject

class CurrencyRatesFragment : BaseFragment(), CurrencyRatesView.Listener,
    CurrencyRatesViewModel.Listener {

    @Inject
    lateinit var mCurrencyRatesUseCase: CurrencyRatesUseCase

    @Inject
    lateinit var mViewFactory: ViewFactory

    lateinit var mCurrencyRatesView: CurrencyRatesView

    val viewModel by viewModels<CurrencyRatesViewModel>
    { getViewModelFactory(mCurrencyRatesUseCase) }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getPresentationComponent()?.inject(this)
        mCurrencyRatesView = mViewFactory.newInstance(CurrencyRatesView::class.java, inflater, container)
        return mCurrencyRatesView.getRoot()
    }

    override fun onStart() {
        super.onStart()
        mCurrencyRatesView.registerListener(this)
        mCurrencyRatesView.showProgressIndication()
        viewModel.registerListener(this)
        viewModel.getData()
    }

    override fun onStop() {
        super.onStop()
        viewModel.unregisterListener(this)
        mCurrencyRatesView.unregisterListener(this)
    }

    override fun onFetchCurrencySucessAndNotify(currencyRates: ArrayList<Currency>) {
        mCurrencyRatesView.hideProgressIndication()
        mCurrencyRatesView.updateItems(currencyRates)
    }

    override fun onFetchCurrencyFailAndNotify() {
        mCurrencyRatesView.hideProgressIndication()
    }
}