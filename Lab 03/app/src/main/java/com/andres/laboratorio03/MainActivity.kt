package com.andres.laboratorio03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // UI elements
    private lateinit var displayMoney: TextView
    private lateinit var addFiveValue: ImageView
    private lateinit var addTenValue: ImageView
    private lateinit var addTwentyValue: ImageView
    private lateinit var addHundredValue: ImageView

    //DATA elements
    private var finalValue: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        addListener()
    }

    private fun bind() {
        displayMoney = findViewById(R.id.final_money_text_view)
        addFiveValue = findViewById(R.id.money_five_image)
        addTenValue = findViewById(R.id.money_ten_image)
        addTwentyValue = findViewById(R.id.money_twenty_image)
        addHundredValue = findViewById(R.id.money_hundred_image)
    }

    private fun addListener() {
        addFiveValue.setOnClickListener {
            finalValue = finalValue + 0.05
            finalValue = String.format("%.2f", finalValue).toDouble()
            displayMoney.text = finalValue.toString()
        }
        addTenValue.setOnClickListener {
            finalValue = finalValue + 0.10
            finalValue = String.format("%.2f", finalValue).toDouble()
            displayMoney.text = finalValue.toString()
        }
        addTwentyValue.setOnClickListener {
            finalValue = finalValue + 0.25
            finalValue = String.format("%.2f", finalValue).toDouble()
            displayMoney.text = finalValue.toString()
        }
        addHundredValue.setOnClickListener {
            finalValue = finalValue + 1.0
            finalValue = String.format("%.2f", finalValue).toDouble()
            displayMoney.text = finalValue.toString()
        }
    }
}