package com.converter.currency.baseview

import android.content.Context
import android.view.View
 abstract class BaseView<ListenerType> : BaseObservable<ListenerType>(),
    ObservableView<ListenerType> {
    private var mRootView: View? = null

    // ---------------------------------------------------------------------------------------------
    // region root View

    // ---------------------------------------------------------------------------------------------
    // region root View

     // ---------------------------------------------------------------------------------------------
     // region root View
     override fun getRoot(): View {
         return this.mRootView!!
     }

     /**
     * Set the root android view of this MVC view
     */
    protected open fun setRootView(rootView: View?) {
        mRootView = rootView
    }

    // endregion root View
    // ---------------------------------------------------------------------------------------------

     /**
      * Convenience method for obtaining reference to [Context]
      * @return instance of [Context] associated with the root [View] of this MVC view
      */
     protected open fun getContext(): Context? {
         return getRoot().getContext()
     }
}