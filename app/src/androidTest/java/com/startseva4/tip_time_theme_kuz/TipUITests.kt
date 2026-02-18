package com.startseva4.tip_time_theme_kuz

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import android.icu.text.NumberFormat
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.startseva4.tip_time_theme_kuz.ui.theme.Tip_Time_Theme_KuzTheme
import org.junit.Rule
import org.junit.Test

class TipUITests {
    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            Tip_Time_Theme_KuzTheme {
                Surface(modifier = Modifier.fillMaxSize()){
                    TipTimeLayout()
                }

            }
        }
        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")
        composeTestRule.onNodeWithText("Tip Percentage")
            .performTextInput("20")
        val expectedTip= NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
            "No node with text was found."
        )
    }
}