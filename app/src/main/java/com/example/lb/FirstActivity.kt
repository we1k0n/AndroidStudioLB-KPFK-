package com.example.lb

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView1)
        val textData: TextView = findViewById(R.id.ShowText)

        imageView.setOnClickListener{
            val text = textData.text.toString().trim()
            if(text == "Вітаю в лабораторній роботі №1")
                // Toast.makeText(this, "Так! Ющенко", Toast.LENGTH_SHORT).show()
                textData.text = "Так! Ющенко"
        }

        textData.setOnClickListener {
            val text = textData.text.toString().trim()
            val intent = Intent(this, SecondActivity::class.java)
            if(text == "Так! Ющенко")
                //Toast.makeText(this, "Так! Ющенко", Toast.LENGTH_SHORT).show()
                startActivity(intent)
        }

    }
}