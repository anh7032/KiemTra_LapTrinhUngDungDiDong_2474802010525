package com.example.kiemtra_laptrinhungdungdidong_2474802010525

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvHeader: TextView
    private lateinit var tvEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var lvSubjects: ListView

    private val subjects = listOf(
        "Kotlin Programming",
        "XML Layout Design",
        "Git/GitHub Management",
        "Intent Processing",
        "Android Architecture",
        "ListView & Adapter"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvHeader = findViewById(R.id.tvHeader)
        tvEmail = findViewById(R.id.tvEmail)
        btnLogout = findViewById(R.id.btnLogout)
        lvSubjects = findViewById(R.id.lvSubjects)

        val email = intent.getStringExtra(LoginActivity.EXTRA_EMAIL)
        tvEmail.text = "Email: $email"

        btnLogout.setOnClickListener { finish() }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, subjects)
        lvSubjects.adapter = adapter

        lvSubjects.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "Selected: ${subjects[position]}", Toast.LENGTH_SHORT).show()
        }
    }
}
