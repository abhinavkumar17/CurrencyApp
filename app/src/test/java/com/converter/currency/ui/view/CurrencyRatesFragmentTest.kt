package com.converter.currency.ui.view

import com.converter.currency.model.Currency
import com.converter.currency.testdata.CurrencyTestData
import com.converter.currency.ui.CurrencyRatesUseCase
import com.converter.currency.ui.CurrencyRatesViewModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CurrencyRatesFragmentTest {

    // region constants ----------------------------------------------------------------------------
    private val PRODUCT_DETAILS: ArrayList<Currency> = CurrencyTestData.getCurrency()
    // endregion constants -------------------------------------------------------------------------

    // endregion constants -------------------------------------------------------------------------

    @InjectMocks
    lateinit var SUT: CurrencyRatesFragment

    @Mock
    lateinit var mProductListView: CurrencyRatesView

    @Mock
    lateinit var mProductListViewModel: CurrencyRatesViewModel

    @Mock
    lateinit var mCurrencyRatesUseCase: CurrencyRatesUseCase

    @Before
    @Throws(Exception::class)
    fun setUp() {
        //MockitoAnnotations.initMocks(this)
        //SUT = CurrencyRatesFragment()
        //mProductListViewModel = CurrencyRatesViewModel(mCurrencyRatesUseCase)
    }

    @Test
    @Throws(Exception::class)
    fun onStart_progressIndicationShown() {
        // Arrange
        // Act
        SUT.onStart()
        // Assert
        Mockito.verify(mProductListView).showProgressIndication()
    }

    @Test
    @Throws(Exception::class)
    fun onStart_register_listener_before_service_call() {
        // Arrange
        // Act
        SUT.onStart()
        // Assert
        Mockito.verify(mProductListView).registerListener(SUT)
        //Mockito.verify(mProductListViewModel).registerListener(SUT)
    }

    @Test
    @Throws(Exception::class)
    fun onStop_unregister_listener_after_service_call() {
        // Arrange
        // Act
        SUT.onStop()
        // Assert
        Mockito.verify(mProductListView).unregisterListener(SUT)
       // Mockito.verify(mProductListViewModel).unregisterListener(SUT)
    }

    @Test
    @Throws(Exception::class)
    fun onService_fail_progressIndicationHide() {
        // Arrange
        // Act
        SUT.onFetchCurrencyFailAndNotify()
        // Assert
        Mockito.verify(mProductListView).hideProgressIndication()
    }

    @Test
    @Throws(Exception::class)
    fun onService_successfulResponse_productBoundToView() {
        // Arrange
        // Act
        SUT.onFetchCurrencySucessAndNotify(PRODUCT_DETAILS)
        // Assert
        Mockito.verify(mProductListView).hideProgressIndication()
        Mockito.verify(mProductListView).updateItems(PRODUCT_DETAILS)
    }

    @Test
    @Throws(Exception::class)
    fun onService_failResponse_errorBoundToView() {
        // Arrange
        // Act
        SUT.onFetchCurrencyFailAndNotify()
        // Assert
         Mockito.verify(mProductListView).setServerError()
    }
}