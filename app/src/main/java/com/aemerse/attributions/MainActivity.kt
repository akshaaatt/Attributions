package com.aemerse.attributions

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.aemerse.attributions.AttributionPresenterCreator.create
import com.aemerse.attributions.sample.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val attributionHelper = create(this)

        val openDialog = findViewById<View>(R.id.openDialog)

        openDialog.setOnClickListener {
            attributionHelper.showDialog(getString(R.string.attributions))
        }

        val openActivity = findViewById<View>(R.id.openActivity)
        openActivity.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
        val openDarkActivity = findViewById<View>(R.id.openDarkActivity)
        openDarkActivity.setOnClickListener {
            val intent = Intent(this, DarkListActivity::class.java)
            startActivity(intent)
        }
        val openCustomActivity = findViewById<View>(R.id.openCustomActivity)
        openCustomActivity.setOnClickListener {
            val intent = Intent(this, CustomListActivity::class.java)
            startActivity(intent)
        }
    }
}