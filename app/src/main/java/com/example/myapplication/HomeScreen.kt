package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController,modifier: Modifier = Modifier){

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        Box(modifier = Modifier){
            Text(text = "Welcome To The App", modifier = Modifier, fontSize = 30.sp)
        }
        createButton(navController = navController, route = "HappyBirthDay", text = "Happy BirthDay")
        createButton(navController = navController, route = "CalculateTip", text = "Calculate Tip")
        createButton(navController = navController, route = "DiceRoller", text = "Dice Roller")
        createButton(navController = navController, route = "BusinessCard", text = "Business Card")
        createButton(navController = navController, route = "Counter", text = "Counter")
        createButton(navController = navController, route = "DogBreed", text = "Dogs Breed")

    }
}

@Composable
fun createButton(navController: NavController,route:String,text:String){
    Button(onClick = { navController.navigate(route) }) {
        Text(text = text)
    }
}