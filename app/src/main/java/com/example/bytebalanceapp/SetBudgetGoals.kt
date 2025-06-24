package com.example.bytebalanceapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SetBudgetGoals : AppCompatActivity() {

    private lateinit var username: String  // Get username from intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_budget_goals)

        username = intent.getStringExtra("username") ?: ""

        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        val btnSaveGoals = findViewById<Button>(R.id.btnSaveGoals)
        val spinnerMonth = findViewById<Spinner>(R.id.spinnerMonth)
        val etMinGoal = findViewById<EditText>(R.id.etMinGoal)
        val etMaxGoal = findViewById<EditText>(R.id.etMaxGoal)

        // Populate Spinner with months
        val months = listOf(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, months)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMonth.adapter = adapter

        btnBack.setOnClickListener {
            val intent = Intent(this, DashBoard::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
            finish()
        }

        btnSaveGoals.setOnClickListener {
            val minGoal = etMinGoal.text.toString().toDoubleOrNull()
            val maxGoal = etMaxGoal.text.toString().toDoubleOrNull()
            val selectedMonth = spinnerMonth.selectedItem.toString()

            if (minGoal == null || maxGoal == null || minGoal <= 0 || maxGoal <= 0) {
                Toast.makeText(this, "Please enter valid goals", Toast.LENGTH_SHORT).show()
            } else if (minGoal > maxGoal) {
                Toast.makeText(this, "Minimum goal cannot be greater than maximum goal", Toast.LENGTH_SHORT).show()
            } else {
                val db = Database(this)
                val success = db.insertBudgetGoal(username, selectedMonth, minGoal, maxGoal)

                if (success) {
                    Toast.makeText(this, "Budget goals saved for $selectedMonth", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Failed to save budget goals", Toast.LENGTH_SHORT).show()
                }

                val intent = Intent(this, DashBoard::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
                finish()
            }
        }
    }
}
