package com.limerse.attributor

import android.content.Context
import androidx.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.limerse.attributions.R
import com.limerse.attributor.entities.Attribution
import com.limerse.attributor.entities.LicenseInfo
import com.limerse.attributor.listeners.OnAttributionClickListener
import com.limerse.attributor.listeners.OnLicenseClickListener
import com.limerse.attributor.util.BrowserOpener.open
import java.util.*

/**
 * Adapter used to show attributions on a ListView.
 */
class AttributionAdapter internal constructor(
    attributions: Collection<Attribution>,
    @LayoutRes itemLayout: Int,
    @LayoutRes licenseLayout: Int,
    onAttributionClickListener: OnAttributionClickListener?,
    onLicenseClickListener: OnLicenseClickListener?
) : BaseAdapter() {
    private val items: MutableList<Attribution>

    @LayoutRes
    private val itemLayout: Int

    @LayoutRes
    private val licenseLayout: Int
    private val onAttributionClickListener: OnAttributionClickListener?
    private val onLicenseClickListener: OnLicenseClickListener?
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Attribution {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
        val holder: ViewHolder = convertView.tag as ViewHolder
        val attribution = getItem(position)
        holder.name!!.text = attribution.name
        holder.copyrightNotices!!.text = attribution.formattedCopyrightNotices
        holder.licensesLayout!!.removeAllViews()
        for (licenseInfo in attribution.licensesInfo) {
            addLicense(parent.context, holder.licensesLayout, licenseInfo)
        }
        convertView.setOnClickListener {
            if (onAttributionClickListener == null ||
                !onAttributionClickListener.onAttributionClick(attribution)
            ) {
                open(parent.context, attribution.website)
            }
        }
        return convertView
    }

    private fun addLicense(context: Context, licensesLayout: ViewGroup?, licenseInfo: LicenseInfo) {
        val inflatedView =
            LayoutInflater.from(context).inflate(licenseLayout, licensesLayout, false)
        val licenseTextView = inflatedView.findViewById<View>(R.id.license) as TextView
            ?: throw IllegalStateException("LicenseInfo layout does not contain a required TextView with android:id=\"@+id/licenseInfo\"")
        licenseTextView.text = licenseInfo.name
        licenseTextView.setOnClickListener {
            if (onLicenseClickListener == null || !onLicenseClickListener.onLicenseClick(licenseInfo)) {
                open(context, licenseInfo.textUrl)
            }
        }
        licensesLayout!!.addView(inflatedView)
    }

    private class ViewHolder {
        var name: TextView? = null
        var copyrightNotices: TextView? = null
        var licensesLayout: ViewGroup? = null
    }

    init {
        items = ArrayList(attributions.size)
        items.addAll(attributions)
        this.itemLayout = itemLayout
        this.licenseLayout = licenseLayout
        this.onAttributionClickListener = onAttributionClickListener
        this.onLicenseClickListener = onLicenseClickListener
    }
}