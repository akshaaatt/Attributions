package com.limerse.attributions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView
import com.limerse.attributions.AttributionPresenterCreator.create
import com.limerse.attributions.sample.R

class CustomListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val list = findViewById<ListView>(R.id.list)
        list.adapter = create(
            this,
            R.layout.custom_item_attribution,
            R.layout.custom_license_text
        ).adapter
    }
}