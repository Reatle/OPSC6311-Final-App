package com.example.bytebalanceapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var db: Database
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnBack: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_activiy)

        db = Database(this)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnBack = findViewById(R.id.btnBack)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
            } else {
                val isValid = db.checkUser(username, password)
                if (isValid) {
                    // ✅ Correct: pass the username here
                    trackLoginAndReward(username)

                    Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, DashBoard::class.java)
                    intent.putExtra("username", username)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnBack.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun trackLoginAndReward(username: String) {
        val prefs = getSharedPreferences("userPrefs", MODE_PRIVATE)
        val today = java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault()).format(java.util.Date())

        val lastLoginKey = "${username}_lastLoginDate"
        val loginCountKey = "${username}_loginCount"
        val badgeAwardedKey = "${username}_badgeAwardedDate"

        val lastLoginDate = prefs.getString(lastLoginKey, "")
        var loginCount = prefs.getInt(loginCountKey, 0)
        val badgeAwardedDate = prefs.getString(badgeAwardedKey, "")

        if (lastLoginDate == today) {
            loginCount++
        } else {
            loginCount = 1
        }

        prefs.edit()
            .putString(lastLoginKey, today)
            .putInt(loginCountKey, loginCount)
            .apply()

        if (loginCount >= 3 && badgeAwardedDate != today) {
            showRewardBadge()
            prefs.edit().putString(badgeAwardedKey, today).apply()
        }
    }

    private fun showRewardBadge() {
        Toast.makeText(
            this,
            "🎉 Congrats! You've earned a reward badge for logging in 3 times today!",
            Toast.LENGTH_LONG
        ).show()
    }
}
