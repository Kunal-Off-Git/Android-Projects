package com.example.myapplication

import android.graphics.fonts.FontStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

data class AttributeData(
    val body : String
)
data class Facts(
    val id : String,
    val type : String,
    val attributes : AttributeData
)

data class FactsResponse(
    val data : List<Facts>
)
interface DogsBreedInterface{
    @GET("facts")
    suspend fun getFacts(): Response<FactsResponse>
}
class DogsBreedData : ViewModel(){
    val retrofit = Retrofit.Builder()
        .baseUrl("https://dogapi.dog/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(DogsBreedInterface::class.java)

    val facts = mutableStateOf<List<Facts>>(emptyList())

//    private val _facts = mutableStateOf<List<Facts>>(emptyList())
//    val facts: State<List<Facts>> = _facts

    init {
        fetchData()
    }

    fun fetchData(){
        viewModelScope.launch {
            val response = api.getFacts()
            if (response.isSuccessful) {
                facts.value = response.body()?.data?: emptyList()
            } else {
                println("Error: ${response.code()}")
            }
        }
    }
}

@Composable
fun DogsBreed(navController: NavController,viewModel : DogsBreedData = viewModel(), modifier: Modifier = Modifier.fillMaxSize()){
    val facts = viewModel.facts.value
    Log.d("App started", "Welcome to App")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        Text(text = "Here's A Random Woof!!", modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 40.sp)
        facts.forEach {
            Log.d("DOG_FACT", it.attributes.body)
            Text(text = it.attributes.body,
                modifier = Modifier.fillMaxWidth(0.9f).padding(vertical = 20.dp),
                fontWeight = FontWeight.Medium)
        }

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Go Back")
        }
    }
}