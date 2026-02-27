package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gd_app.BusinessCard
import com.example.gd_app.DiceRoller
import com.example.myapplication.Counter
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "Home"){
                        composable("Home"){
                            HomeScreen(navController)
                        }
                        composable("Counter"){
                            Counter("Kunal",navController)
                        }
                        composable("HappyBirthDay"){
                            HappyBirthdayText(message = "Happy BirthDay", from = "K.",navController)
                        }
                        composable("BusinessCard"){
                            BusinessCard(name = "Kunal", title = "Developer", phone = "+999 999 9999",
                                email = "iamKunal@gmail.com", socialMedia = "KunalisaDev",navController)
                        }
                        composable("DiceRoller"){
                            DiceRoller(navController)
                        }
                        composable("DogBreed"){
                            DogsBreed(navController)
                        }
                        composable("CalculateTip"){
                            CalculateTipWithViewModel(navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}