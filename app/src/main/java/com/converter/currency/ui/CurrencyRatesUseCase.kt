package com.converter.currency.ui

import android.util.Log
import com.converter.currency.baseview.BaseObservable
import com.converter.currency.mapper.LatestCurrenciesMapper
import com.converter.currency.model.Currency
import com.converter.currency.model.LatestCurrencies
import com.converter.currency.usecase.GetLatestCurrencyRates
import com.converter.currency.utils.Constants
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CurrencyRatesUseCase @Inject constructor(private val getLatestCurrencyRates: GetLatestCurrencyRates) :
    BaseObservable<CurrencyRatesUseCase.Listener>() {

    interface Listener{
        fun onFetchCurrencytSucessAndNotify(currencyRates: ArrayList<Currency>)
        fun onFetchCurrencyFailed()
    }

    private var mCompositeDisposable = CompositeDisposable()
    var mCurrentBaseCurrency = Constants.BASE_CURRENCY_EURO

    fun getLatestCurrencyRates() {
        Observable.interval(1000, TimeUnit.MILLISECONDS)
            .flatMap {
                getLatestCurrencyRates.getUseCaseObservable(mCurrentBaseCurrency)
            }.flatMap {
                Observable.just(LatestCurrenciesMapper().mapToEntity(it))
            }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<LatestCurrencies> {
                override fun onSubscribe(d: Disposable) {
                    mCompositeDisposable.add(d)
                }

                override fun onNext(values: LatestCurrencies) {
                   // view.updateValues(values.currencyRates)
                    for (listener in getListeners()) {
                        listener.onFetchCurrencytSucessAndNotify(values.currencyRates)
                    }
                }

                override fun onComplete() {

                }

                override fun onError(e: Throwable) {
                    for (listener in getListeners()) {
                        listener.onFetchCurrencyFailed()
                    }
                    val localizedMessage = e.localizedMessage ?: return
                    Log.i(Constants.MAIN_APPLICATION, localizedMessage)
                }
            })
    }

}