package com.example.myapplication

import org.junit.Assert.*
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculateButton_Click_DisplayResult() {
        // Enter matrix values
        onView(withId(R.id.matrixInput))
            .perform(typeText("1, 2, 3, 4, 5, 6, 7, 8, 9"))

        // Click the calculate button
        onView(withId(R.id.calculateButton))
            .perform(click())

        // Verify the result is displayed correctly
        onView(withId(R.id.resultTextView))
            .check(matches(withText("Result: [[1, 2, 3], [4, 5, 6], [7, 8, 9]]")))
    }
}