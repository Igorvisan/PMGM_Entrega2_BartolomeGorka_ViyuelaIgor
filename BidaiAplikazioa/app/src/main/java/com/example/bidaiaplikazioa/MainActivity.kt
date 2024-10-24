package com.example.bidaiaplikazioa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.IntegerRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bidaiaplikazioa.R.color.black
import com.example.bidaiaplikazioa.ui.theme.BidaiAplikazioaTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BidaiAplikazioaTheme {
                myAppPreviewr()
                }
            }
        }
    }

@Composable
fun pantallaIniciarSesion(modifier: Modifier = Modifier){
    var mostrarAlPrincipio by remember { mutableStateOf(true) }
    var text by remember { mutableStateOf("") }
    Surface(
        modifier,
        color = colorResource(id = R.color.cream)
    ){
        Column (
            modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Text(
                "Welcome to our booking application!"
            )
            OutlinedTextField(
                value = text,
                onValueChange = {text = it}, //onValueChange = { text = it }: Cada vez que el usuario escriba algo,
                // el contenido del campo de texto cambiará y actualizará el valor de text
                label = { Text("Name") },
                placeholder = {Text("Enter Name")},
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.padding(vertical = 18.dp),
            )
            Button(
                onClick = {mostrarAlPrincipio = false},
                modifier.padding(vertical = 24.dp),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.black)),
            ) {
                Text("Enter")
            }
        }
    }
}

@Composable
fun paginaPrincipal(modifier: Modifier = Modifier){
    
}


@Preview(showBackground = true)
@Composable
fun myAppPreviewr(){
    pantallaIniciarSesion()
}