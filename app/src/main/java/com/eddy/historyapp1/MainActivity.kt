package com.eddy.historyapp1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //declaring variables
    lateinit var resultTextView: TextView
    lateinit var ageInput: EditText
    lateinit var clearbutton:Button
    lateinit var Searchbutton: Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

 // initialising buttons
        Searchbutton= findViewById(R.id.searchButton)
        clearbutton= findViewById(R.id.clearbutton)
        ageInput = findViewById(R.id.ageInput)
        resultTextView = findViewById(R.id.resultTextView)


        //enabling button to be clicked on
        Searchbutton.setOnClickListener {
            //create variable of age to get value from user
            val age = ageInput.text.toString().toIntOrNull()

            //since ages range are between 20 and 100
            if (age != null && age in 20..100) {
                //when age 58 displays Whitney Houston when 45 displays Chadwick Boseman ..etc

                val celebrityName = when (age) {
                    58 -> "Whitney Housten"
                    50 -> "Micheal Jackson"
                    95 -> "Nelson Mandela"
                    34 -> "Ricky Rick"
                    27 -> "Amy Whinehouse"
                    92 -> "Queen Elizabeth"
                    86 -> "Elvis Presely"
                    75 -> "Freddie Mercury"
                    92 -> "Martin Luther King,Jr"
                    else -> null
                }
                val message = if (celebrityName != null) "$celebrityName"
                else "Your value is invalid , there are no celebs under this age"
                resultTextView.text = message.toString()

            } else {

                resultTextView.text = "Invaild ageInput"
            }
            clearbutton.setOnClickListener {
                ageInput.text.clear()
                resultTextView.text = ""

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}}}