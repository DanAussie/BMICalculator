package com.example.myfirstproject

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassification = findViewById<TextView>(R.id.textview_classification)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)


        tvResult.text = result.toString()

        var classification = ""

        if (result < 18.5) {
            classification = "UNDERWEIGHT"
        } else if (result in 18.5f..24.9f) {
            classification = "NORMAL WEIGHT"
        } else if (result in 25f..29.9f) {
            classification = "OVERWEIGHT"
        } else if (result in 30f..34.9f) {
            classification = "GRADE I OBESITY"
        } else if (result in 35f..39.9f) {
            classification = "GRADE II OBESITY"
        } else if (result >= 40f) {
            classification = "GRADE III OBESITY"

        }
        tvClassification.text = getString(R.string.message_classification, classification)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

    }