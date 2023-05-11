package com.example.aston_intensiv_2

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class HelloActivity : AppCompatActivity() {

    private val countTextView by lazy { getTextView(R.id.count_TextView) }

    private fun getTextView(idTextView: Int): TextView = findViewById(idTextView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setOrientation()

        getData()
    }

    @SuppressLint("SwitchIntDef")
    private fun setOrientation(): Any {
        return when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> setContentView(R.layout.activity_new)
            Configuration.ORIENTATION_LANDSCAPE -> setContentView(R.layout.activity_new_landscape)
            Configuration.SCREENLAYOUT_SIZE_XLARGE -> setContentView(R.layout.activity_new_xlarge)
            else -> { Log.d("LOGTAG", "orientation not found")}
        }
    }

    private fun getData(){
        val value = intent.getStringExtra("name")
        countTextView.text = value
    }
}