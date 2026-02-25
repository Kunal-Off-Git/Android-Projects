package com.example.myapplication

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.gd_app.BusinessCard
import com.example.gd_app.DiceRoller
import com.example.myapplication.Counter

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.myapplication", appContext.packageName)
    }
}

@RunWith(AndroidJUnit4::class)
class CounterScreenTest{
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun counterIncrementButton(){
        composeTestRule.setContent {
            Counter(name = "Kunal")
        }

        composeTestRule.onNodeWithText("Increase").performClick()

        composeTestRule.onNodeWithText("Count : 1").assertIsDisplayed()
    }

    @Test
    fun counterDecrementButton(){
        composeTestRule.setContent {
            Counter("Kunal")
        }

        composeTestRule.onNodeWithText("Decrease").performClick()

        composeTestRule.onNodeWithText("Count : -1").assertIsDisplayed()
    }

    @Test
    fun counterResetButton(){
        composeTestRule.setContent {
            Counter("Kunal")
        }

        composeTestRule.onNodeWithText("Reset").performClick()

        composeTestRule.onNodeWithText("Count : 0").assertIsDisplayed()
    }
}

@RunWith(AndroidJUnit4::class)
class CalculateTipTest{
    @get:Rule
    val composableTestRule = createComposeRule()

    @Test
    fun TipAmountTest(){
        composableTestRule.setContent {
            CalculateTip()
        }

        composableTestRule.onNodeWithTag("amountValue").performTextClearance()
        composableTestRule.onNodeWithTag("amountValue").performTextInput("100.00")

        val txt : String = CalculateTipValue(100.00)
        composableTestRule.onNodeWithText(txt).assertIsDisplayed()
    }

}

@RunWith(AndroidJUnit4::class)
class BusinessCardScreenTest{
    @get:Rule
    val composableTestRule = createComposeRule()

    @Test
    fun imageTest(){
        composableTestRule.setContent {
            BusinessCard("Kunal", "Developer", "+91 999 999 9999","iamKunal@gmail.com","@kunalisaDEV")
        }
        composableTestRule.onNodeWithContentDescription("image").assertIsDisplayed()
    }

}

@RunWith(AndroidJUnit4::class)
class DiceRollerTest{
    @get:Rule
    val composableTestRule = createComposeRule()


    @Test
    fun diceImageTest(){
        composableTestRule.setContent {
            DiceRoller()
        }
        composableTestRule.onNodeWithContentDescription("DiceImage").assertIsDisplayed()
    }

}

@RunWith(AndroidJUnit4::class)
class HappyBirthdayScreenTest{
    @get:Rule
    val composableTestRule = createComposeRule()

    @Test
    fun textTest(){
        composableTestRule.setContent {
            val message = "Happy BirthDay"
            val from = "Kunal"
            HappyBirthdayText(message,from)
        }
        composableTestRule.onNodeWithText("Happy BirthDay").assertIsDisplayed()
        composableTestRule.onNodeWithText("Kunal").assertIsDisplayed()
    }
}