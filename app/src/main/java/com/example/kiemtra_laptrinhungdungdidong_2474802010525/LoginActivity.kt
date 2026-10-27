package com.example.kiemtra_laptrinhungdungdidong_2474802010525

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class LoginActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvStatus = findViewById(R.id.tvStatus)

        btnLogin.setOnClickListener { validate() }
    }

    private fun validate() {
        val email = edtEmail.text.toString().trim()
        val password = edtPassword.text.toString()

        val error = when {
            email.isEmpty() && password.isEmpty() -> "Error: Email and Password must not be empty!"
            email.isEmpty() -> "Error: Email must not be empty!"
            password.isEmpty() -> "Error: Password must not be empty!"
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Error: Invalid email format!"
            password.length < 6 -> "Error: Password must be at least 6 characters!"
            else -> null
        }

        if (error != null) {
            tvStatus.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
            tvStatus.text = error
        } else {
            tvStatus.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark))
            tvStatus.text = "Validation Successful!"

            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra(EXTRA_EMAIL, email)
            startActivity(intent)
        }
    }

    companion object {
        const val EXTRA_EMAIL = "EXTRA_EMAIL"
    }
}
