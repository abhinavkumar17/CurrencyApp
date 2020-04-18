package com.converter.currency.baseview

import java.util.*
import java.util.concurrent.ConcurrentHashMap

open class BaseObservable<LISTENER_CLASS> {
    // thread-safe set of listeners
    private val mListeners =
        Collections.newSetFromMap(
            ConcurrentHashMap<LISTENER_CLASS, Boolean>(1)
        )


    fun registerListener(listener: LISTENER_CLASS) {
        mListeners.add(listener)
    }

    fun unregisterListener(listener: LISTENER_CLASS) {
        mListeners.remove(listener)
    }

    /**
     * Get a reference to the unmodifiable set containing all the registered listeners.
     */
    protected fun getListeners(): Set<LISTENER_CLASS> {
        return Collections.unmodifiableSet(mListeners)
    }
}