package com.limerse.attributions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.ListView
import android.widget.Toast
import com.limerse.attributor.entities.Attribution
import com.limerse.attributor.entities.LicenseInfo
import com.limerse.attributor.listeners.OnAttributionClickListener
import com.limerse.attributor.listeners.OnLicenseClickListener
import com.limerse.attributions.AttributionPresenterCreator.create
import com.limerse.attributions.sample.R

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val list = findViewById<View>(R.id.list) as ListView

        list.adapter = create(this,
            object : OnAttributionClickListener {
                override fun onAttributionClick(attribution: Attribution?): Boolean {
                    Toast.makeText(
                        applicationContext,
                        "Attribution click: " + attribution!!.name,
                        Toast.LENGTH_SHORT
                    ).show()
                    return false
                }
            },
            object : OnLicenseClickListener {
                override fun onLicenseClick(licenseInfo: LicenseInfo?): Boolean {
                    Toast.makeText(
                        applicationContext,
                        "License click: " + licenseInfo!!.name,
                        Toast.LENGTH_SHORT
                    ).show()
                    return true
                }
            }).adapter
    }
}