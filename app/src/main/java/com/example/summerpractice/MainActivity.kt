package com.example.summerpractice

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var height: EditText
    private lateinit var weight: EditText
    private lateinit var age: EditText

    private var result = 0

    private var clickButton: Button? = null


    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name)
        height = findViewById(R.id.height)
        weight = findViewById(R.id.weight)
        age = findViewById(R.id.age)
        val stringResult = findViewById<TextView>(R.id.result)

        fun correctData(name : String, myHeight : Int, myWeight : Double, myAge : Int): Boolean {
            return name.length < 50 && myHeight in 0..250 && myWeight in 0.0..250.0 && myAge in 0..150
        }

        clickButton = findViewById(R.id.button)
        clickButton?.setOnClickListener {
            if (name.text.isEmpty() || height.text.isEmpty() || weight.text.isEmpty() || age.text.isEmpty()) {
                stringResult.text = "Data entered incorrectly"
            } else {
                val myHeight = height.text.toString().toInt()
                val myWeight = weight.text.toString().toDouble()
                val myAge = age.text.toString().toInt()

                if (correctData(name.text.toString(), myHeight, myWeight, myAge)) {
                    result = (myWeight * 10).roundToInt() + (myHeight * 6.25).roundToInt() - myAge * 5 - 161
                    stringResult.text = "Your ideal calorie count: $result"
                } else {
                    stringResult.text = "Data entered incorrectly"
                }
            }
        }
    }
}