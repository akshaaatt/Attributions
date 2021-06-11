package com.limerse.attributor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
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
    @Nullable onAttributionClickListener: OnAttributionClickListener?,
    @Nullable onLicenseClickListener: OnLicenseClickListener?
) :
    BaseAdapter() {
    private val items: MutableList<Attribution>

    @LayoutRes
    private val itemLayout: Int

    @LayoutRes
    private val licenseLayout: Int

    @Nullable
    private val onAttributionClickListener: OnAttributionClickListener?

    @Nullable
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

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var convertView = convertView
        val holder: ViewHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.context).inflate(itemLayout, parent, false)
            holder = ViewHolder()
            holder.name = convertView.findViewById<View>(R.id.name) as TextView
            holder.copyrightNotices =
                convertView.findViewById<View>(R.id.copyrightNotices) as TextView
            holder.licensesLayout = convertView.findViewById<View>(R.id.licensesLayout) as ViewGroup
            check(!(holder.name == null || holder.copyrightNotices == null || holder.licensesLayout == null)) {
                """Item layout must contain all of the following required views:
  - TextView with android:id="@+id/name"
  - TextView with android:id="@+id/copyrightNotices"
  - ViewGroup descendant with android:id="@+id/licensesLayout""""
            }
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        val attribution = getItem(position)
        holder.name!!.text = attribution.name
        holder.copyrightNotices!!.text = attribution.formattedCopyrightNotices
        holder.licensesLayout!!.removeAllViews()
        for (licenseInfo in attribution.licensesInfo) {
            addLicense(parent.context, holder.licensesLayout, licenseInfo)
        }
        convertView!!.setOnClickListener {
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
            if (onLicenseClickListener == null ||
                !onLicenseClickListener.onLicenseClick(licenseInfo)
            ) {
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