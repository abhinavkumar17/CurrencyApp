package com.converter.currency.usecase

import com.converter.currency.data.BaseResponse
import io.reactivex.Observable
import javax.inject.Inject

class GetLatestCurrencyRates @Inject constructor(
    private val repository: CurrencyRatesRepository
) : ObservableUseCase<BaseResponse, String>() {

    override fun buildUseCaseObservable(params: String?): Observable<BaseResponse> {
        val baseCurrency = params ?: return Observable.just(null)
        return repository.getLatestCurrencyRates(baseCurrency)
    }
}