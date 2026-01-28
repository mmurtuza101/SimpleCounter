package com.example.simplecounter

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var count = 0
    private var incrementValue = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val counterTextView: TextView = findViewById(R.id.counterTextView)
        val incrementButton: ImageButton = findViewById(R.id.incrementButton)
        val upgradeButton: Button = findViewById(R.id.upgradeButton)

        incrementButton.setOnClickListener {
            count += incrementValue
            counterTextView.text = count.toString()

            if (count >= 100 && incrementValue == 1) {
                upgradeButton.visibility = View.VISIBLE
            }
        }

        upgradeButton.setOnClickListener {
            incrementValue = 2
            // Hide the upgrade button after it's clicked
            upgradeButton.visibility = View.GONE
        }
    }
}