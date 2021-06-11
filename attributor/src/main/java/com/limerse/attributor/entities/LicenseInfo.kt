package com.limerse.attributor.entities

class LicenseInfo constructor(val name: String, val textUrl: String) {
    override fun toString(): String {
        return name
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o !is LicenseInfo) return false
        val that = o
        return if (name != that.name) false else textUrl == that.textUrl
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + textUrl.hashCode()
        return result
    }
}