package com.aemerse.attributor.entities

import java.util.*

/**
 * Class that contain information needed to comply with library licenses.
 */
class Attribution private constructor(
    val name: String,
    val copyrightNotices: List<String>,
    val licensesInfo: List<LicenseInfo>,
    val website: String
) : Comparable<Attribution> {

    val formattedCopyrightNotices: String
        get() {
            val builder = StringBuilder()
            for (copyrightNotice in copyrightNotices) {
                builder.append("\n").append(copyrightNotice)
            }
            return builder.toString().replaceFirst("\n".toRegex(), "")
        }

    override fun compareTo(other: Attribution): Int {
        return name.compareTo(other.name, ignoreCase = true)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Attribution) return false
        if (name != other.name) return false
        for (copyrightNotice in copyrightNotices) {
            if (!other.copyrightNotices.contains(copyrightNotice)) return false
        }
        for (licenseInfo in licensesInfo) {
            if (!other.licensesInfo.contains(licenseInfo)) return false
        }
        return website == other.website
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + copyrightNotices.hashCode()
        result = 31 * result + licensesInfo.hashCode()
        result = 31 * result + website.hashCode()
        return result
    }

    class Builder(private val name: String) {
        private val copyrightNotices: MutableList<String>
        private val licenseInfos: MutableList<LicenseInfo>
        private var website: String
        fun addCopyrightNotice(notice: String): Builder {
            copyrightNotices.add(notice)
            return this
        }

        fun addCopyrightNotice(copyrightHolder: String, year: String): Builder {
            copyrightNotices.add("Copyright $year $copyrightHolder")
            return this
        }

        fun addLicense(name: String?, textUrl: String?): Builder {
            licenseInfos.add(LicenseInfo(name!!, textUrl!!))
            return this
        }

        fun addLicense(license: License): Builder {
            licenseInfos.add(license.licenseInfo)
            return this
        }

        fun setWebsite(website: String): Builder {
            this.website = website
            return this
        }

        fun build(): Attribution {
            return Attribution(name, copyrightNotices, licenseInfos, website)
        }

        init {
            copyrightNotices = ArrayList()
            licenseInfos = ArrayList()
            website = ""
        }
    }
}