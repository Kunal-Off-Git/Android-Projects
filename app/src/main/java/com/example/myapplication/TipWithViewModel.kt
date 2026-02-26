package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.theme.MyApplicationTheme


class TipViewModel : ViewModel(){
    var amount by mutableStateOf("")
    var tipPercentage by mutableStateOf(15.0)

    val activeColor = Color.Green
    val disableColor = Color.Gray

    val tip : String
        get() {
            val value = amount.toDoubleOrNull()?:0.00
            return CalculateTipValue(value,tipPercentage)
        }

    fun updateAmount(newValue : String){
        amount = newValue
    }
    fun updateTipPercentage(newPercentage : Double){
        tipPercentage = newPercentage
    }

}

@Composable
fun CalculateTipWithViewModel(viewModel : TipViewModel = viewModel(),modifier : Modifier = Modifier){

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Card (
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {

            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly) {
                Text(
                    text = "Calculate Tip",
                    modifier = Modifier
                        .align(alignment = Alignment.Start)
                        .padding(bottom = 20.dp, top = 20.dp),
                    style = MaterialTheme.typography.headlineLarge
                )
                OutlinedTextField(
                    viewModel.amount,
                    onValueChange = { newValue -> viewModel.updateAmount(newValue) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp)
                        .testTag("amountValue")
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(onClick = { viewModel.updateTipPercentage(5.0) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if(viewModel.tipPercentage==5.0){
                                                viewModel.activeColor
                                            }else
                                                viewModel.disableColor

                        )) {
                        Text(text = "5%")
                    }
                    Button(onClick = { viewModel.updateTipPercentage(10.0) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if(viewModel.tipPercentage==10.0){
                                viewModel.activeColor
                            }else
                                viewModel.disableColor

                        )) {
                        Text(text = "10%")
                    }
                    Button(onClick = { viewModel.updateTipPercentage(15.0) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if(viewModel.tipPercentage==15.0){
                                viewModel.activeColor
                            }else
                                viewModel.disableColor

                        )) {
                        Text(text = "15%")
                    }
                    Button(onClick = { viewModel.updateTipPercentage(20.0) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if(viewModel.tipPercentage==20.0){
                                viewModel.activeColor
                            }else
                                viewModel.disableColor

                        )) {
                        Text(text = "20%")
                    }
                }

                Column(Modifier.padding(bottom = 20.dp)) {
                    Text(
                        text = "Tip Amount",
                        style = MaterialTheme.typography.labelLarge
                    )

                    Text(
                        text = viewModel.tip,
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CalculateTipWithViewModelPreview(modifier : Modifier = Modifier){
    MyApplicationTheme{
        Surface(modifier = Modifier.fillMaxSize()) {
            CalculateTipWithViewModel( modifier = Modifier.fillMaxSize())
        }
    }
}