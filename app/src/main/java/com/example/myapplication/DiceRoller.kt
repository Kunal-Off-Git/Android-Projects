package com.example.gd_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun DiceRoller(navController: NavController,modifier: Modifier = Modifier){
    var result by remember { mutableStateOf(1) }
    val imageResource = when(result){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = "DiceImage",
            modifier = Modifier.size(200.dp).padding(bottom = 20.dp)
        )
        Button({ result = (1..6).random() },modifier = Modifier.width(300.dp)) {
            Text(text = "Roll")
        }
//        Text(text = result.toString())

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Go Back")
        }
    }
}



//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun DiceRollerPreview(){
//    MyApplicationTheme{
//        Surface(modifier = Modifier.fillMaxSize()) {
//            DiceRoller(navController ,modifier = Modifier.fillMaxSize())
//        }
//    }
//}