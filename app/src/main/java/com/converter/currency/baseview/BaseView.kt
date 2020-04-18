package com.converter.currency.baseview

import android.view.View

open abstract class BaseView<ListenerType> : BaseObservable<ListenerType>(),
    ObservableView<ListenerType> {
    private var mRootView: View? = null

    // ---------------------------------------------------------------------------------------------
    // region root View

    // ---------------------------------------------------------------------------------------------
    // region root View
    open fun getRootView(): View? {
        return mRootView
    }

    /**
     * Set the root android view of this MVC view
     */
    protected open fun setRootView(rootView: View?) {
        mRootView = rootView
    }

    // endregion root View
    // ---------------------------------------------------------------------------------------------
}