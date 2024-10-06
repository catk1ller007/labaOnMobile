package com.example.labaonmobile.LabaTwo

import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.labaonmobile.R

class Summik : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summik)

        val buttonOpenDialog = findViewById<Button>(R.id.button_open_dialog)
        buttonOpenDialog.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Сложить числа")

        val view = layoutInflater.inflate(R.layout.dialog_layout, null)
        val editTextNumber1 = view.findViewById<EditText>(R.id.editTextNumber1)
        val editTextNumber2 = view.findViewById<EditText>(R.id.editTextNumber2)
        editTextNumber1.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_SIGNED
        editTextNumber2.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_SIGNED

        builder.setView(view)

        builder.setPositiveButton("Сложить", null)
        builder.setNegativeButton("Отмена") { dialog, _ -> dialog.dismiss() }

        val dialog = builder.create()

        dialog.setOnShowListener {
            val button = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
            button.setOnClickListener {
                val num1 = editTextNumber1.text.toString().toIntOrNull()
                val num2 = editTextNumber2.text.toString().toIntOrNull()

                if (num1 != null && num2 != null) {
                    val sum = num1 + num2
                    Toast.makeText(this, "Результат: $sum", Toast.LENGTH_SHORT).show()
                    Log.d("Sum", "Результат: $sum")
                    dialog.dismiss()
                } else {
                    Toast.makeText(this, "Введите корректные числа!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        dialog.show()
    }

}