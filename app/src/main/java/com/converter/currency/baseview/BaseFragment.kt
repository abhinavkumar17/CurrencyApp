package com.converter.currency.baseview

import android.app.Activity
import androidx.fragment.app.Fragment
import com.converter.currency.MainApplication
import com.converter.currency.di.component.ApplicationComponent
import com.converter.currency.di.component.DaggerFragmentComponent
import com.converter.currency.di.component.FragmentComponent

abstract class BaseFragment : Fragment(){

    protected open fun getPresentationComponent(): FragmentComponent? {
       return DaggerFragmentComponent
            .builder()
            .applicationComponent(
                MainApplication
                    .getApplication(activity as Activity)
                    .getApplicationComponent()
            )
            .build()
    }
}