package com.example.myapplication

class MatrixHelper {
    fun setZeroes(matrix: Array<IntArray>) {
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
