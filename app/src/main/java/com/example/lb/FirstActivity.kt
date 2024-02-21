package com.example.lb

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView1)
        val textData: TextView = findViewById(R.id.ShowText)
        val inputText = findViewById<TextInputEditText>(R.id.inputText)

        imageView.setOnClickListener {
            val hint = inputText.text.toString().trim()
            val intentCalc = Intent(this, Calc::class.java)
            if (hint == "calc")
                startActivity(intentCalc)
            textData.setOnClickListener {
                val text = textData.text.toString().trim()
                val intent = Intent(this, SecondActivity::class.java)
                if (text == "Так! Ющенко")
                    startActivity(intent)

            }

        }
    }}