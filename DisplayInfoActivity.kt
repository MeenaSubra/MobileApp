package com.example.ps2intent

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_info)

        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")
        val visitType = intent.getStringExtra("visitType")
        val country = intent.getStringExtra("country")

        findViewById<TextView>(R.id.textViewFirstNameValue).text = firstName
        findViewById<TextView>(R.id.textViewLastNameValue).text = lastName
        findViewById<TextView>(R.id.textViewVisitTypeValue).text = visitType
        findViewById<TextView>(R.id.textViewCountryValue).text = country
    }
}
