package com.converter.currency.ui.adapter.view

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

    private val viewModel by viewModels<CurrencyRatesViewModel>
    { getViewModelFactory(mCurrencyRatesUseCase) }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getPresentationComponent()?.inject(this)
        mCurrencyRatesView = mViewFactory.newInstance(CurrencyRatesView::class.java, inflater, container)
        return mCurrencyRatesView.getRoot()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mCurrencyRatesView.registerListener(this)
        mCurrencyRatesView.showProgressIndication()
    }

    override fun onStart() {
        super.onStart()
        viewModel.registerListener(this)
        viewModel.getData()
    }

    override fun onFetchProductSecessAndNotify(currencyRates: ArrayList<Currency>) {
        mCurrencyRatesView.updateItems(currencyRates)
    }

    override fun onFetchProductFailAndNotify() {
        TODO("Not yet implemented")
    }
}