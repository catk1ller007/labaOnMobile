package com.example.labaonmobile.LabaTwo

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.labaonmobile.R

class SumCheck : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sum_check)

        val square: View = findViewById(R.id.blackSquare1)

        val moveAnimation = ObjectAnimator.ofFloat(square, "translationY", 200f, 1000f)
        val scaleAnimationX = ObjectAnimator.ofFloat(square, "scaleX", 1f, 2f)
        val scaleAnimationY = ObjectAnimator.ofFloat(square, "scaleY", 1f, 2f)

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(moveAnimation, scaleAnimationX, scaleAnimationY)
        animatorSet.duration = 2000
        animatorSet.start()
    }
}