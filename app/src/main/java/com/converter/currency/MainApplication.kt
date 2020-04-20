package com.converter.currency

import android.app.Activity
import android.app.Application
import com.akaita.java.rxjava2debug.RxJava2Debug
import com.converter.currency.di.component.ApplicationComponent
import com.converter.currency.di.component.DaggerApplicationComponent

class MainApplication: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        RxJava2Debug.enableRxJava2AssemblyTracking()

        component = DaggerApplicationComponent.builder().build()
        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

    companion object {
        fun getApplication(activity: Activity) = activity.application as MainApplication
    }
}