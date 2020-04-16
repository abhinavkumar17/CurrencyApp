package com.converter.currency

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class CurrencyFragment:Fragment()  {

    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.rootView = inflater.inflate(R.layout.fragment_currency,container)
        return rootView
    }

    override fun onStart() {
        super.onStart()
    }

}