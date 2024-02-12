package com.example.lb

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val textView: TextView = findViewById(R.id.textTimer1)

        // Запускаємо таймер на 3 секунди з кроком 1 секунда
        object : CountDownTimer(4000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // Виводимо відлік на екран
                textView.text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                // Виводимо повідомлення "Вітаємо" після закінчення таймера
                textView.text = "Вітаємо!"
            }
        }.start()
    }
}