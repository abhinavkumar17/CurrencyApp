package com.converter.currency.usecase

import com.converter.currency.data.RevolutBaseResponse
import io.reactivex.Observable
import javax.inject.Inject

class GetLatestCurrencyRates @Inject constructor(
    private val repository: RevolutRepository
) : ObservableUseCase<RevolutBaseResponse, String>() {

    override fun buildUseCaseObservable(params: String?): Observable<RevolutBaseResponse> {
        val baseCurrency = params ?: return Observable.just(null)
        return repository.getLatestCurrencyRates(baseCurrency)
    }
}