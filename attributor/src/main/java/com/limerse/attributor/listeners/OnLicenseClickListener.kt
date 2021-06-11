package com.limerse.attributor.listeners

import com.limerse.attributor.entities.LicenseInfo

/**
 * Interface definition for a callback to be invoked when a license view is clicked.
 */
interface OnLicenseClickListener {
    /**
     * Called when a license view is clicked.
     * @param licenseInfo object representing the clicked view
     * @return true if the event has been consumed, false otherwise
     */
    fun onLicenseClick(licenseInfo: LicenseInfo?): Boolean
}