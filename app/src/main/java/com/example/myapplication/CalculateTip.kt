package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
//import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.MyApplicationTheme
//import com.example.gd_app.ui.theme.GD_appTheme
import java.text.NumberFormat

@Composable
fun CalculateTip(modifier : androidx.compose.ui.Modifier = Modifier){
    var amountValue by remember { mutableStateOf("0.00") }

    var amount = amountValue.toDoubleOrNull()?:0.00
    var tip = CalculateTipValue(amount)

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Card (
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {

            Text(
                text = "Calculate Tip",
                modifier = Modifier
                    .align(alignment = Alignment.Start)
                    .padding(bottom = 20.dp, top = 20.dp),
                style = MaterialTheme.typography.headlineLarge
            )
            OutlinedTextField(
                amountValue,
                onValueChange = { amountValue = it },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
            )

            Column (Modifier.padding(bottom = 20.dp)){
                Text(
                    text = "Tip Amount",
                    style = MaterialTheme.typography.labelLarge
                )

                Text(
                    text = tip,
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}



@Composable
fun EditValue(amountValue : String,
              onValueChanged : (String) -> Unit,
              modifier : Modifier,
              ){
    TextField(value = amountValue, onValueChange = onValueChanged, singleLine = true)
}

fun CalculateTipValue(amount: Double) : String{
    val tip = 15.0 / 100 * amount
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CalculateTipPreview(){
    MyApplicationTheme{
        Surface(modifier = Modifier.fillMaxSize()) {
            CalculateTip( modifier = Modifier.fillMaxSize())
        }
    }
}