package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.MatrixHelper

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private lateinit var calculateButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById<TextView>(R.id.resultTextView)
        calculateButton = findViewById<Button>(R.id.calculateButton)

        calculateButton.setOnClickListener {
            // Perform your matrix calculation here
            val matrixHelper = MatrixHelper()
            val matrix = arrayOf(
                intArrayOf(1, 1, 1),
                intArrayOf(1, 0, 1),
                intArrayOf(1, 1, 1)
            )
            matrixHelper.setZeroes(matrix)

            // Update the resultTextView with the calculated result
            resultTextView.text = "Result: ${matrix.contentDeepToString()}"
        }


    }
}