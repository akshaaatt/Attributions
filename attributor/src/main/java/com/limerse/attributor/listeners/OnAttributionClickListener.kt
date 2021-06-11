package com.limerse.attributor.listeners

import com.limerse.attributor.entities.Attribution

/**
 * Interface definition for a callback to be invoked when the attribution item is clicked.
 */
interface OnAttributionClickListener {
    /**
     * Called when the attribution item is clicked.
     * @param attribution object representing the clicked item
     * @return true if the event has been consumed, false otherwise
     */
    fun onAttributionClick(attribution: Attribution?): Boolean
}