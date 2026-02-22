package com.example.simplecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input1 = findViewById(R.id.input1)
        input2 = findViewById(R.id.input2)
        result = findViewById(R.id.result)

        findViewById<Button>(R.id.addButton).setOnClickListener { performOperation('+') }
        findViewById<Button>(R.id.subtractButton).setOnClickListener { performOperation('-') }
        findViewById<Button>(R.id.multiplyButton).setOnClickListener { performOperation('*') }
        findViewById<Button>(R.id.divideButton).setOnClickListener { performOperation('/') }
    }

    private fun performOperation(operator: Char) {
        val num1 = input1.text.toString().toDoubleOrNull()
        val num2 = input2.text.toString().toDoubleOrNull()

        if (num1 == null || num2 == null) {
            result.text = "Invalid Input"
            return
        }

        val calcResult = when (operator) {
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            '/' -> {
                if (num2 == 0.0) "Error: Division by zero" else num1 / num2
            }
            else -> 0.0
        }

        result.text = calcResult.toString()
    }
}