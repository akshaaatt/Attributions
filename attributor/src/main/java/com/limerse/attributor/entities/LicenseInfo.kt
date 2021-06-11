package com.limerse.attributor.entities

class LicenseInfo constructor(val name: String, val textUrl: String) {
    override fun toString(): String {
        return name
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is LicenseInfo) return false
        return if (name != other.name) false else textUrl == other.textUrl
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + textUrl.hashCode()
        return result
    }
}