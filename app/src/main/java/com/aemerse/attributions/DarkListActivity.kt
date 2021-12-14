package com.aemerse.attributions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.ListView
import com.aemerse.attributions.AttributionPresenterCreator.create
import com.aemerse.attributions.sample.R

class DarkListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val list = findViewById<View>(R.id.list) as ListView
        list.adapter = create(this).adapter
    }
}