package com.example.myapplication

import org.junit.Assert
import org.junit.Test

class MatrixHelperTest {

    @Test
    fun testSetzeroes(){

        val matrixHelper = MatrixHelper()

        // Test case 1: Non-zero matrix
        val matrix1 = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        matrixHelper.setZeroes(matrix1)
        val expected1 = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        Assert.assertArrayEquals(expected1, matrix1)

        // Test case 2: Matrix with zeros
        val matrix2 = arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(3, 4, 5),
            intArrayOf(6, 7, 0)
        )
        matrixHelper.setZeroes(matrix2)
        val expected2 = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 4, 0),
            intArrayOf(0, 0, 0)
        )
        Assert.assertArrayEquals(expected2, matrix2)

        // Test case 3: Matrix with zeros and non-zeros
        val matrix3 = arrayOf(
            intArrayOf(1, 0, 3),
            intArrayOf(0, 5, 6),
            intArrayOf(7, 8, 9)
        )
        matrixHelper.setZeroes(matrix3)
        val expected3 = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 9)
        )
        Assert.assertArrayEquals(expected3, matrix3)
    }
}