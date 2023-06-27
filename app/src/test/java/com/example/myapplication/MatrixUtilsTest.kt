package com.example.myapplication

import org.junit.Assert.*
import org.junit.Test

class MatrixUtilsTest{

    @Test
    fun testEmptyMatrix() {
        val matrix = arrayOf<IntArray>()
        setZeroes(matrix)
        assertArrayEquals(arrayOf<IntArray>(), matrix)
    }

    @Test
    fun testSingleRowMatrixNoZeroes() {
        val matrix = arrayOf(intArrayOf(1, 2, 3))
        setZeroes(matrix)
        assertArrayEquals(arrayOf(intArrayOf(1, 2, 3)), matrix)
    }

    @Test
    fun testSingleRowMatrixOneZero() {
        val matrix = arrayOf(intArrayOf(0, 2, 3))
        setZeroes(matrix)
        assertArrayEquals(arrayOf(intArrayOf(0, 0, 0)), matrix)
    }

    @Test
    fun testSingleColumnMatrixNoZeroes() {
        val matrix = arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(3))
        setZeroes(matrix)
        assertArrayEquals(arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(3)), matrix)
    }

    @Test
    fun testSingleColumnMatrixOneZero() {
        val matrix = arrayOf(intArrayOf(0), intArrayOf(2), intArrayOf(3))
        setZeroes(matrix)
        assertArrayEquals(arrayOf(intArrayOf(0), intArrayOf(0), intArrayOf(0)), matrix)
    }

    @Test
    fun testSquareMatrixNoZeroes() {
        val matrix = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        setZeroes(matrix)
        assertArrayEquals(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), matrix)
    }

    @Test
    fun testSquareMatrixOneZero() {
        val matrix = arrayOf(intArrayOf(1, 0), intArrayOf(3, 4))
        setZeroes(matrix)
        assertArrayEquals(arrayOf(intArrayOf(0, 0), intArrayOf(3, 0)), matrix)
    }

    @Test
    fun testSquareMatrixMultipleZeroes() {
        val matrix = arrayOf(intArrayOf(1, 0), intArrayOf(0, 4))
        setZeroes(matrix)
        assertArrayEquals(arrayOf(intArrayOf(0, 0), intArrayOf(0, 0)), matrix)
    }

    @Test
    fun testMatrixNoZeroes() {
        val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
        setZeroes(matrix)
        assertArrayEquals(
            arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)),
            matrix
        )
    }

    @Test
    fun testMatrixOneZero() {
        val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 0, 6), intArrayOf(7, 8, 9))
        setZeroes(matrix)
        assertArrayEquals(
            arrayOf(intArrayOf(1, 0, 3), intArrayOf(0, 0, 0), intArrayOf(7, 0, 9)),
            matrix
        )
    }

    @Test
    fun testMatrixMultipleZeroes() {
        val matrix = arrayOf(intArrayOf(1, 2, 0), intArrayOf(4, 0, 6), intArrayOf(0, 8, 9))
        setZeroes(matrix)
        assertArrayEquals(
            arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 0)),
            matrix
        )
    }

    fun setZeroes(matrix: Array<IntArray>){
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return
        }
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