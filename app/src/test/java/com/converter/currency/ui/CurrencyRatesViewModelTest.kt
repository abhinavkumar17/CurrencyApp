package com.converter.currency.ui

import com.converter.currency.model.Currency
import com.converter.currency.testdata.CurrencyTestData
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CurrencyRatesViewModelTest {

    // region constants ----------------------------------------------------------------------------
    private val PRODUCT_DETAILS: ArrayList<Currency> = CurrencyTestData.getCurrency()
    // endregion constants -------------------------------------------------------------------------

    @Mock
    lateinit var mListener1: CurrencyRatesViewModel.Listener

    @Mock
    lateinit var mListener2: CurrencyRatesViewModel.Listener

    @Mock
    lateinit var mFetchCurrencyRatesUseCase: CurrencyRatesUseCase

    lateinit var SUT: CurrencyRatesViewModel


    @Before
    @Throws(Exception::class)
    fun setUp() {
        SUT = CurrencyRatesViewModel(mFetchCurrencyRatesUseCase)
        SUT.registerListener(mListener1)
        SUT.registerListener(mListener2)
    }

    @Test
    @Throws(Exception::class)
    fun fetchCurrencySecessAndNotify_success_listenersNotifiedWithCorrectData() {
        // Arrange
        // Act
        SUT.onFetchCurrencytSucessAndNotify(PRODUCT_DETAILS)
        // Assert
        Mockito.verify(mListener1).onFetchCurrencySucessAndNotify(PRODUCT_DETAILS)
    }

    @Test
    @Throws(Exception::class)
    fun fetchCurrencyFailAndNotify_fail_listenersNotified() {
        // Arrange

        // Act
        SUT.onFetchCurrencyFailed()
        // Assert
        Mockito.verify(mListener1).onFetchCurrencyFailAndNotify()
    }

    @Test
    @Throws(Exception::class)
    fun fetchProduct_sucess_add_to_compositable_true() {
        // Arrange
        // Act
        SUT.getData()
        // Assert
        Mockito.verify(mFetchCurrencyRatesUseCase).getLatestCurrencyRates()
    }
}