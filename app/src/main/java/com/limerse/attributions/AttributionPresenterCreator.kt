package com.limerse.attributions

import android.content.Context
import com.limerse.attributor.entities.Attribution
import com.limerse.attributor.entities.Library
import com.limerse.attributor.entities.License
import com.limerse.attributor.listeners.OnAttributionClickListener
import com.limerse.attributor.listeners.OnLicenseClickListener
import com.limerse.attributor.Attributor

object AttributionPresenterCreator {

    private fun createBaseAttributions(context: Context): Attributor.Builder {
        return Attributor.Builder(context)
            .addAttributions(
                Attribution.Builder("AttributionPresenter")
                    .addCopyrightNotice("Copyright 2017 Francisco José Montiel Navarro")
                    .addLicense(License.APACHE)
                    .setWebsite("https://github.com/franmontiel/AttributionPresenter")
                    .build()
            )
            .addAttributions(
                Library.GLIDE,
                Library.DAGGER_2,
                Library.GSON,
            )
    }

    fun create(context: Context): Attributor {
        return createBaseAttributions(context).build()
    }

    fun create(context: Context, onAttributionClickListener: OnAttributionClickListener?, onLicenseClickListener: OnLicenseClickListener?): Attributor {
        return createBaseAttributions(context)
            .setOnAttributionClickListener(onAttributionClickListener)
            .setOnLicenseClickListener(onLicenseClickListener)
            .build()
    }

    fun create(context: Context, itemLayout: Int, licenseLayout: Int): Attributor {
        return createBaseAttributions(context)
            .setItemLayout(itemLayout)
            .setLicenseLayout(licenseLayout)
            .build()
    }
}