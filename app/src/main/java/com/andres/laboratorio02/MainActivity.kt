package com.andres.laboratorio02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import java.util.SplittableRandom
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

     lateinit var weightData: EditText
    private lateinit var heightData: EditText
    private lateinit var button: Button
    private lateinit var resultView: TextView
    private lateinit var condition: TextView
    private lateinit var informationText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        addListener()
    }

    private fun bind() {
        weightData = findViewById(R.id.weight_edit_text)
        heightData = findViewById(R.id.height_edit_text)
        button = findViewById(R.id.button_action)
        resultView = findViewById(R.id.result_ibm_text)
        condition = findViewById(R.id.result_condition_text)
        informationText = findViewById(R.id.information_text)
    }

    private fun addListener(){
        button.setOnClickListener{
            val weight = weightData.text.toString()
            val height = heightData.text.toString()

            if (!validateImput(height,weight)) {
                clearFocus()
                return@setOnClickListener
            }

            val bmi = calculateBmi(weight.toFloat(), height.toFloat())
            val bmiTwoDigits = String.format("%.2f",bmi).toFloat()

            displayResult(bmiTwoDigits)
        }
    }

        private fun validateImput(height: String?, weight: String?): Boolean {
            when {
                height.isNullOrEmpty() -> {
                    Toast.makeText(this, "Height is empty!!", Toast.LENGTH_SHORT).show()
                    return false
                }
                weight.isNullOrEmpty() -> {
                    Toast.makeText(this, "Weight is empty!!", Toast.LENGTH_SHORT).show()
                    return false
                }
            }

            return true
        }
            private fun calculateBmi(weight: Float, height: Float):Float{
                return weight / ((height/100)*(height/100))
            }

            private fun displayResult(bmi:Float){
                resultView.text=bmi.toString()
                condition.text="(Normal range is 18.5 - 24.9)"

                var informationResult=""
                var color = 0

                when {
                    bmi < 18.50 ->{
                        informationResult = "Underweight"
                        color = R.color.under_weight
                    }
                    bmi in 18.50..24.99 ->{
                        informationResult = "Healthy"
                        color = R.color.normal_weight
                    }
                    bmi in 25.00..29.99 ->{
                        informationResult = "Overweight"
                        color = R.color.over_weight
                    }
                    bmi > 30 ->{
                        informationResult = "Obese"
                        color = R.color.obese
                    }
                }

                condition.text = informationResult
                condition.setTextColor(ContextCompat.getColor(this, color))
            }

    private fun clearFocus() {
        weightData.clearFocus()
        heightData.clearFocus()
    }
}