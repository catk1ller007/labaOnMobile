package com.example.labaonmobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LabaOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd: Button = findViewById(R.id.addBtn)
        val btnMinus:Button = findViewById(R.id.minusBtn)
        var currentNumber = 0

        val text: TextView = findViewById(R.id.result)

        btnAdd.setOnClickListener {
            currentNumber++
            text.text = currentNumber.toString()
        }

        btnMinus.setOnClickListener {
            currentNumber--
            text.text = currentNumber.toString()
        }
    }
}