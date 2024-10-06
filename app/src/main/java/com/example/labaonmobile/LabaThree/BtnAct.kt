package com.example.labaonmobile.LabaThree

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.view.MotionEvent
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.labaonmobile.R
import java.util.Calendar

class BtnAct : AppCompatActivity() {
    private var isToggleOn = false

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_btn)

        val text: TextView = findViewById(R.id.textView2)
        val btn: Button = findViewById(R.id.buttonTouch)

        btn.setOnTouchListener { _, event ->
            when(event.action) {
                MotionEvent.ACTION_DOWN -> {
                    text.text = "Нажата"
                }
                MotionEvent.ACTION_UP -> {
                    text.text = "Отпущена"
                }
            }
            true
        }

        val btnCounter: Button = findViewById(R.id.button)
        var counter: Int = 0;
        btnCounter.setOnClickListener {
            counter ++
            btnCounter.text = counter.toString();
        }

        val btnSelectDate = findViewById<Button>(R.id.btn_select_date)

        // 1. Селектор даты
        btnSelectDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                Log.d("DateSelected", "Выбранная дата: $selectedDay/${selectedMonth + 1}/$selectedYear")
            }, year, month, day)

            datePickerDialog.show()
        }

        val btnSelectTime = findViewById<Button>(R.id.btn_select_time)

        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val tvSliderValue = findViewById<TextView>(R.id.counterSeekBar)
        var hourchik: Int = 0
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvSliderValue.text = "Значение: $progress"
                hourchik = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Обработка начала взаимодействия с ползунком
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Обработка окончания взаимодействия с ползунком
            }
        })

        // 2. Селектор времени
        btnSelectTime.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
                Log.d("TimeSelected", "Выбранное время: $selectedHour:$selectedMinute")
            }, hourchik, minute, true)

            timePickerDialog.show()
        }

        // 3. Выпадающий список
        val spinner = findViewById<Spinner>(R.id.spinner)
        val items = listOf("Элемент 1", "Элемент 2", "Элемент 3")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : android.widget.AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: android.widget.AdapterView<*>, view: android.view.View, position: Int, id: Long) {
                Log.d("SpinnerSelected", "Выбранный элемент: ${items[position]}")
            }

            override fun onNothingSelected(parent: android.widget.AdapterView<*>) {
                // Ничего не выбрано
            }
        }

        val btnChecked = findViewById<Button>(R.id.btn_checked)

        btnChecked.setOnClickListener {
            isToggleOn = !isToggleOn

            if(isToggleOn){
                btnChecked.text = "Включен"
            }
            else {
                btnChecked.text = "Выключен"
            }
        }
    }
}