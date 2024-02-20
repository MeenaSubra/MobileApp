package com.example.ps2intent

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstNameEditText = findViewById<EditText>(R.id.firstNameEditText)
        val lastNameEditText = findViewById<EditText>(R.id.lastNameEditText)
        val visitTypeRadioGroup = findViewById<RadioGroup>(R.id.visitTypeRadioGroup)
        val countrySpinner = findViewById<Spinner>(R.id.countrySpinner)
        val continueButton = findViewById<Button>(R.id.continueButton)
        val cancelButton = findViewById<Button>(R.id.cancelButton)

        // Populate the spinner with country names
        val countries = arrayOf("","India", "USA", "Germany") // Add more countries as needed
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, countries)
        countrySpinner.adapter = adapter

        continueButton.setOnClickListener {
            val firstName = firstNameEditText.text.toString()
            val lastName = lastNameEditText.text.toString()
            val visitType = when (visitTypeRadioGroup.checkedRadioButtonId) {
                R.id.businessRadioButton -> "Business"
                R.id.socialRadioButton -> "Social"
                else -> ""
            }
            val country = countrySpinner.selectedItem.toString()

            if (validateInput(firstName, lastName)) {
                val intent = Intent(this, DisplayInfoActivity::class.java).apply {
                    putExtra("firstName", firstName)
                    putExtra("lastName", lastName)
                    putExtra("visitType", visitType)
                    putExtra("country", country)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid input. Please enter valid names.", Toast.LENGTH_SHORT).show()
            }
        }

        cancelButton.setOnClickListener {
            firstNameEditText.setText("")
            lastNameEditText.setText("")
            visitTypeRadioGroup.clearCheck()
            countrySpinner.setSelection(0)
        }
    }

    private fun validateInput(firstName: String, lastName: String): Boolean {
        val namePattern = Pattern.compile("[a-zA-Z]+")
        return namePattern.matcher(firstName).matches() && namePattern.matcher(lastName).matches()
    }
}
