package com.example.tp2_pt1_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

const val MESSAGE = "com.example.tp2_pt1_2.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener {
            val message = findViewById<EditText>(R.id.message).text.toString()
            val intent = Intent(this, ShowMessageActivity::class.java).apply {
                putExtra(MESSAGE, message)
            }
            startActivity(intent)
        }
    }
}