package com.example.tp2_p1_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener {
            var number1 = 0; var number2 = 0;
            val n1 = findViewById<EditText>(R.id.number1).text.toString().trim()
            val n2 = findViewById<EditText>(R.id.number2).text.toString().trim()

            if (n1.isNotBlank()) {
                number1 = n1.toInt()
            }
            if (n2.isNotBlank()) {
                number2 = n2.toInt()
            }

            val sum = (number1 + number2).toString()
            val result = findViewById<TextView>(R.id.result)
            result.text = sum
        }
    }
}