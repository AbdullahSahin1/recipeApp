package com.example.recipeapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var appLogoImageView: ImageView
    private lateinit var welcomeTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var startButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
        startAnimations()
        setupClickListeners()
    }

    private fun initializeViews() {
        appLogoImageView = findViewById(R.id.appLogoImageView)
        welcomeTextView = findViewById(R.id.welcomeTextView)
        descriptionTextView = findViewById(R.id.descriptionTextView)
        startButton = findViewById(R.id.startButton)

        // Başlangıçta görünmez yap
        welcomeTextView.alpha = 0f
        descriptionTextView.alpha = 0f
        startButton.alpha = 0f
    }

    private fun startAnimations() {
        // Logo animasyonu
        val fadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        fadeIn.duration = 1000
        appLogoImageView.startAnimation(fadeIn)

        // Hoş geldiniz yazısı animasyonu
        Handler(Looper.getMainLooper()).postDelayed({
            welcomeTextView.animate()
                .alpha(1f)
                .setDuration(1000)
                .start()
        }, 500)

        // Açıklama yazısı animasyonu
        Handler(Looper.getMainLooper()).postDelayed({
            descriptionTextView.animate()
                .alpha(1f)
                .setDuration(1000)
                .start()
        }, 1000)

        // Başla butonu animasyonu
        Handler(Looper.getMainLooper()).postDelayed({
            startButton.animate()
                .alpha(1f)
                .setDuration(1000)
                .start()
        }, 1500)
    }

    private fun setupClickListeners() {
        startButton.setOnClickListener {
            val intent = Intent(this, CategorySelectionActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}