package com.converter.currency.baseview
 interface ObservableView<ListenerType> : ViewRoot {

    /**
     * Register a listener that will be notified of any input events performed on this MVC view
     */
    fun registerListener(listener : ListenerType )

    /**
     * Unregister a previously registered listener. Does nothing if the listener wasn't registered.
     */
    fun unregisterListener(listener: ListenerType)
}