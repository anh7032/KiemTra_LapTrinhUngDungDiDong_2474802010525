package com.example.kiemtra_laptrinhungdungdidong_2474802010525

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvHeader: TextView
    private lateinit var tvEmail: TextView
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvHeader = findViewById(R.id.tvHeader)
        tvEmail = findViewById(R.id.tvEmail)
        btnLogout = findViewById(R.id.btnLogout)

        val email = intent.getStringExtra(LoginActivity.EXTRA_EMAIL)
        tvEmail.text = "Email: $email"

        btnLogout.setOnClickListener { finish() }
    }
}
