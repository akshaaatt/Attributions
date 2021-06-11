package com.limerse.attributor

import android.app.Dialog
import android.content.Context
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import com.limerse.attributions.R
import com.limerse.attributor.entities.Attribution
import com.limerse.attributor.entities.Library
import com.limerse.attributor.listeners.OnAttributionClickListener
import com.limerse.attributor.listeners.OnLicenseClickListener
import java.util.*

/**
 * Class to present a view to show license attributions.
 */
class AttributionPresenter private constructor(
    private val context: Context,
    private val attributions: SortedSet<Attribution>,
    @LayoutRes itemLayout: Int,
    @LayoutRes licenseLayout: Int,
    onAttributionClickListener: OnAttributionClickListener?,
    onLicenseClickListener: OnLicenseClickListener?
) {
    private val itemLayout: Int
    private val licenseLayout: Int
    private val onAttributionClickListener: OnAttributionClickListener?
    private val onLicenseClickListener: OnLicenseClickListener?
    private var attributionAdapter: AttributionAdapter? = null

    /**
     * Show a dialog with the configured attributions.
     *
     * @param title optional title of the dialog
     * @return the dialog itself
     */
    fun showDialog(title: String?): Dialog {
        return AlertDialog.Builder(context)
            .setTitle(title)
            .setAdapter(adapter, null)
            .show()
    }

    /**
     * Gets the adapter used to show the attributions on a ListView.
     *
     * @return
     */
    val adapter: AttributionAdapter
        get() {
            if (attributionAdapter == null) {
                attributionAdapter = AttributionAdapter(
                    attributions,
                    itemLayout,
                    licenseLayout,
                    onAttributionClickListener,
                    onLicenseClickListener
                )
            }
            return attributionAdapter!!
        }

    class Builder(private val context: Context) {
        private val attributions: SortedSet<Attribution>

        @LayoutRes
        private var itemLayout = 0

        @LayoutRes
        private var licenseLayout = 0
        private var onAttributionClickListener: OnAttributionClickListener? = null
        private var onLicenseClickListener: OnLicenseClickListener? = null
        fun addAttributions(vararg attributions: Attribution?): Builder {
            this.attributions.addAll(Arrays.asList(*attributions))
            return this
        }

        fun addAttributions(vararg libraries: Library): Builder {
            for (library in libraries) {
                attributions.add(library.attribution)
            }
            return this
        }

        /**
         * Sets an optional custom layout for the attribution item.
         *
         *
         * The layout must contain all of the following views:
         *
         *  * a TextView with android:id="@+id/name"
         *  * a TextView with android:id="@+id/copyrightNotices"
         *  * a ViewGroup descendant with android:id="@+id/licensesLayout"
         *
         *
         * @param itemLayoutResId the layout file to be used
         * @return
         */
        fun setItemLayout(@LayoutRes itemLayoutResId: Int): Builder {
            itemLayout = itemLayoutResId
            return this
        }

        /**
         * Sets an optional custom layout for the licenses names
         *
         *
         * The layout must contain a TextView with android:id="@+id/licenseInfo"
         *
         * @param licenseLayoutResId the layout file to be used
         * @return
         */
        fun setLicenseLayout(@LayoutRes licenseLayoutResId: Int): Builder {
            licenseLayout = licenseLayoutResId
            return this
        }

        fun setOnAttributionClickListener(onAttributionClickListener: OnAttributionClickListener?): Builder {
            this.onAttributionClickListener = onAttributionClickListener
            return this
        }

        fun setOnLicenseClickListener(onLicenseClickListener: OnLicenseClickListener?): Builder {
            this.onLicenseClickListener = onLicenseClickListener
            return this
        }

        fun build(): AttributionPresenter {
            return AttributionPresenter(
                context,
                attributions,
                itemLayout,
                licenseLayout,
                onAttributionClickListener,
                onLicenseClickListener
            )
        }

        init {
            attributions = TreeSet()
        }
    }

    init {
        this.itemLayout = if (itemLayout == 0) R.layout.default_item_attribution else itemLayout
        this.licenseLayout =
            if (licenseLayout == 0) R.layout.default_license_text else licenseLayout
        this.onAttributionClickListener = onAttributionClickListener
        this.onLicenseClickListener = onLicenseClickListener
    }
}