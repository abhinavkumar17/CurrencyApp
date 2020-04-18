package com.converter.currency.di.component

import com.converter.currency.MainActivity
import com.converter.currency.di.module.ActivityModule
import dagger.Component

@Component(modules = [ActivityModule::class])
interface ActivityComponent {
    fun injectMainActivity(mainActivity: MainActivity)
}