package com.limerse.attributions

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.limerse.attributions.AttributionPresenterCreator.create
import com.limerse.attributions.sample.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val attributionHelper = create(this)

        val openDialog = findViewById<View>(R.id.openDialog) as Button

        openDialog.setOnClickListener {
            attributionHelper.showDialog(getString(R.string.attributions))
        }

        val openActivity = findViewById<View>(R.id.openActivity) as Button
        openActivity.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
        val openDarkActivity = findViewById<View>(R.id.openDarkActivity) as Button
        openDarkActivity.setOnClickListener {
            val intent = Intent(this, DarkListActivity::class.java)
            startActivity(intent)
        }
        val openCustomActivity = findViewById<View>(R.id.openCustomActivity) as Button
        openCustomActivity.setOnClickListener {
            val intent = Intent(this, CustomListActivity::class.java)
            startActivity(intent)
        }
    }
}