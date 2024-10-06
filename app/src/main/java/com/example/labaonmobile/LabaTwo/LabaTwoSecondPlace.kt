package com.example.labaonmobile.LabaTwo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.labaonmobile.R

class LabaTwoSecondPlace : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laba_two_second_place)

        val btn: Button = findViewById(R.id.btnvoati)

        btn.setOnClickListener {
            val intent = Intent(this, SumCheck::class.java)
            startActivity(intent)
        }
    }
}