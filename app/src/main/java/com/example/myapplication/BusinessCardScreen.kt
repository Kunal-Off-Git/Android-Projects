package com.example.gd_app

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.MyApplicationTheme

//import com.example.gd_app.ui.theme.GD_appTheme
//import androidx.compose.material3.Icons
//import androidx.compose.material.icons.filled.Email
//import androidx.compose.material3.Icon

@Composable
fun BusinessCard(name: String,title:String,phone:String,email:String,socialMedia:String,modifier: Modifier = Modifier){
    Column (modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = painterResource(R.drawable.pikachu2),
            contentDescription = "image",
            modifier = Modifier.padding(bottom = 10.dp)
            )
        Text(text = name,
            fontSize = 48.sp,
            fontWeight = FontWeight.W800)
        Text(text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.W400)
    }
    Column(modifier = Modifier.padding(bottom = 30.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally) {
        ContactRow(Icons.Filled.Call,phone)
        ContactRow(Icons.Filled.Email,email)
        ContactRow(Icons.Filled.Email,"@$socialMedia")
//        Row (modifier = Modifier.padding(bottom = 10.dp)){
//            Icon(imageVector = Icons.Filled.Call, contentDescription = "Call Icon")
//            Text(text = "+91 999 999 9990", fontSize = 20.sp, lineHeight = 20.sp)
//        }
//        Row (modifier = Modifier.padding(bottom = 10.dp)){
//            Icon(imageVector = Icons.Filled.Email, contentDescription = "Call Icon")
//            Text(text = "iamkunal@gmail.com", fontSize = 20.sp, lineHeight = 20.sp)
//        }
//        Row (modifier = Modifier.padding(bottom = 10.dp)){
//            Icon(imageVector = Icons.Filled.AlternateEmail, contentDescription = "Call Icon")
//            Text(text = "@kunalisadev", fontSize = 20.sp, lineHeight = 20.sp)
//        }
    }
}

@Composable
fun ContactRow(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.8f) // same width for all rows
            .height(50.dp)      // same height
            .padding(bottom = 10.dp, start = 50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = text,
            fontSize = 20.sp,
            lineHeight = 20.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BusinessCardPreview(){
    MyApplicationTheme{
        Surface(modifier = Modifier.fillMaxSize()) {
            BusinessCard("Kunal", "Developer", "+91 999 999 9999","iamKunal@gmail.com","@kunalisaDEV" ,modifier = Modifier.fillMaxSize())
        }
    }
}