package com.aemerse.attributions

import android.content.Context
import com.aemerse.attributor.entities.Attribution
import com.aemerse.attributor.entities.Library
import com.aemerse.attributor.entities.License
import com.aemerse.attributor.listeners.OnAttributionClickListener
import com.aemerse.attributor.listeners.OnLicenseClickListener
import com.aemerse.attributor.Attributor

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