package com.limerse.attributions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.ListView
import com.limerse.attributions.AttributionPresenterCreator.create
import com.limerse.attributions.sample.R

class DarkListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val list = findViewById<View>(R.id.list) as ListView
        list.adapter = create(this).adapter
    }
}