package com.limerse.attributor.entities

/**
 * An enumeration of the most common open source licenses.
 */
enum class License(name: String, textUrl: String) {
    APACHE(
        "Apache License 2.0",
        "http://www.apache.org/licenses/LICENSE-2.0"
    ),
    BSD_2("BSD-2-Clause", "https://opensource.org/licenses/BSD-2-Clause"), BSD_3(
        "BSD-3-Clause",
        "https://opensource.org/licenses/BSD-3-Clause"
    ),
    GPL_2(
        "GPL-2.0",
        "http://www.gnu.org/licenses/old-licenses/gpl-2.0-standalone.html"
    ),
    GPL_3("GPL-3.0", "http://www.gnu.org/licenses/gpl-3.0-standalone.html"), LGPL_2_1(
        "LGPL-2.1",
        "http://www.gnu.org/licenses/old-licenses/lgpl-2.1-standalone.html"
    ),
    LGPL_3("LGPL-3.0", "http://www.gnu.org/licenses/lgpl-3.0-standalone.html"), MIT(
        "MIT License",
        "https://opensource.org/licenses/MIT"
    );

    val licenseInfo: LicenseInfo = LicenseInfo(name, textUrl)
}