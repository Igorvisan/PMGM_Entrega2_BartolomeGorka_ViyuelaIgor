package com.example.bidaiaplikazioa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bidaiaplikazioa.ui.theme.BidaiAplikazioaTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BidaiAplikazioaTheme {
                }
            }
        }
    }

@Composable
fun pantallaIniciarSesion(modifier: Modifier = Modifier){
    var mostrarAlPrincipio by remember { mutableStateOf(true) }
    Surface(modifier){
        Column (
            modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Text("Bienvenido a nuestra aplicación de viajes")
            Button(
                onClick = {mostrarAlPrincipio = false},
                modifier.padding(vertical = 24.dp)
            ) {
                Text("Iniciar Sesion")
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
    BidaiAplikazioaTheme {
        Greeting("Android")
    }
}

@Preview
@Composable
fun myAppPreviewr(){
    pantallaIniciarSesion()
}