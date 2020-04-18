package com.converter.currency.di.component

import com.converter.currency.di.module.NetworkModule
import com.converter.currency.di.module.RetrofitModule
import com.converter.currency.ui.ConverterFragment
import dagger.Component

@Component(
    modules = [RetrofitModule::class, NetworkModule::class],
    dependencies = [ApplicationComponent::class]
)
interface FragmentComponent {

    fun injectConverterFragment(converterFragment: ConverterFragment)
}