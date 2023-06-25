package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    private lateinit var matrixInput: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        matrixInput = findViewById(R.id.matrixInput)
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val matrixString = matrixInput.text.toString()
            val matrixValues = matrixString.split(",").map { it.trim().toInt() }.toIntArray()

            val matrixSize = Math.sqrt(matrixValues.size.toDouble()).toInt()
            val matrix = Array(matrixSize) { IntArray(matrixSize) }

            var index = 0
            for (i in 0 until matrixSize) {
                for (j in 0 until matrixSize) {
                    matrix[i][j] = matrixValues[index]
                    index++
                }
            }

            setZeroes(matrix)

            resultTextView.text = "Result: ${matrix.contentDeepToString()}"
        }
    }

    private fun setZeroes(matrix: Array<IntArray>) {
        val m = matrix.size
        val n = matrix[0].size
        var r0 = false
        var c0 = false

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == 0) {
                    if (i == 0) r0 = true
                    if (j == 0) c0 = true
                    matrix[i][0] = 0
                    matrix[0][j] = 0
                }
            }
        }

        for (i in 1 until m) {
            for (j in 1 until n) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0
                }
            }
        }

        if (r0) {
            for (i in 0 until n) {
                matrix[0][i] = 0
            }
        }

        if (c0) {
            for (i in 0 until m) {
                matrix[i][0] = 0
            }
        }
    }
}