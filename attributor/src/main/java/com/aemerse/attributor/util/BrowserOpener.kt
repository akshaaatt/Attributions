package com.aemerse.attributor.util

import android.content.Intent
import android.content.ActivityNotFoundException
import android.content.Context
import android.net.Uri

object BrowserOpener {

    fun open(context: Context, url: String) {
        var url = url
        if (!url.startsWith("http://") && !url.startsWith("https://")){
            url = "https://$url"
        }
        val toBrowser = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        toBrowser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startIntent(context, toBrowser)
    }

    private fun startIntent(context: Context, intent: Intent) {
        try {
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) { }
    }
}