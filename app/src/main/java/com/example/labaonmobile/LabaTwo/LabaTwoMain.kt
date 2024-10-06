package com.example.labaonmobile.LabaTwo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.labaonmobile.R

class LabaTwoMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laba_two_main)

        val btn: Button = findViewById(R.id.btnvoati)

        btn.setOnClickListener {
            val intent = Intent(this, LabaTwoSecondPlace::class.java)
            startActivity(intent)
        }
    }
}