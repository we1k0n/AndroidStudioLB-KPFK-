package com.example.lb

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class Calc : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calc)

        val math_operation = findViewById<TextView>(R.id.math_operation)
        val result_text = findViewById<TextView>(R.id.result_text)

        val btn_0 = findViewById<TextView>(R.id.btn_0)
        val btn_1 = findViewById<TextView>(R.id.btn_1)
        val btn_2 = findViewById<TextView>(R.id.btn_2)
        val btn_3 = findViewById<TextView>(R.id.btn_3)
        val btn_4 = findViewById<TextView>(R.id.btn_4)
        val btn_5 = findViewById<TextView>(R.id.btn_5)
        val btn_6 = findViewById<TextView>(R.id.btn_6)
        val btn_7 = findViewById<TextView>(R.id.btn_7)
        val btn_8 = findViewById<TextView>(R.id.btn_8)
        val btn_9 = findViewById<TextView>(R.id.btn_9)

        val minus_btn = findViewById<TextView>(R.id.minus_btn)
        val plus_btn = findViewById<TextView>(R.id.plus_btn)
        val division_btn = findViewById<TextView>(R.id.division_btn)
        val mult_btn = findViewById<TextView>(R.id.mult_btn)
        val open_bracket_btn = findViewById<TextView>(R.id.open_bracket_btn)
        val close_bracket_btn = findViewById<TextView>(R.id.close_bracket_btn)
        val back_btn = findViewById<TextView>(R.id.back_btn)
        val equal_btn = findViewById<TextView>(R.id.equal_btn)


        btn_0.setOnClickListener { setTextFields("0") }
        btn_1.setOnClickListener { setTextFields("1") }
        btn_2.setOnClickListener { setTextFields("2") }
        btn_3.setOnClickListener { setTextFields("3") }
        btn_4.setOnClickListener { setTextFields("4") }
        btn_5.setOnClickListener { setTextFields("5") }
        btn_6.setOnClickListener { setTextFields("6") }
        btn_7.setOnClickListener { setTextFields("7") }
        btn_8.setOnClickListener { setTextFields("8") }
        btn_9.setOnClickListener { setTextFields("9") }

        minus_btn.setOnClickListener { setTextFields("-") }
        plus_btn.setOnClickListener { setTextFields("+") }
        division_btn.setOnClickListener { setTextFields("/") }
        mult_btn.setOnClickListener { setTextFields("*") }
        open_bracket_btn.setOnClickListener { setTextFields("(") }
        close_bracket_btn.setOnClickListener { setTextFields(")") }

        val clear_btn = findViewById<TextView>(R.id.clear_btn)

        clear_btn.setOnClickListener {
            math_operation.text = ""
            result_text.text = ""
        }

        back_btn.setOnClickListener {
            val str = math_operation.text.toString()
            if(str.isNotEmpty())
                math_operation.text = str.substring(0, str.length - 1)
            result_text.text = ""
        }

        equal_btn.setOnClickListener {
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if(result == longRes.toDouble())
                    result_text.text = longRes.toString()
                else
                    result_text.text = result.toString()

            } catch (e:Exception){
                Log.d("Помилка", "Повідомлення: ${e.message}")
            }
        }
    }

    fun setTextFields(str: String){
        val mathOperationText = findViewById<TextView>(R.id.math_operation)
        val resultText = findViewById<TextView>(R.id.result_text)
        mathOperationText.append(str)
        if (resultText.text != ""){
            mathOperationText.text = resultText.text
            resultText.text = ""
        }
    }
}