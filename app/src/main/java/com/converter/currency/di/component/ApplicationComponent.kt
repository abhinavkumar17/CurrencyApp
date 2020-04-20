package com.converter.currency.di.component

import com.converter.currency.MainApplication
import com.converter.currency.di.module.ApplicationModule
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(mainApplication: MainApplication)
}