package com.converter.currency.di.module

import com.converter.currency.MainApplication
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val mainApplication: MainApplication) {

    @Provides
    fun providesRevolutDemoApplication(): MainApplication = mainApplication
}