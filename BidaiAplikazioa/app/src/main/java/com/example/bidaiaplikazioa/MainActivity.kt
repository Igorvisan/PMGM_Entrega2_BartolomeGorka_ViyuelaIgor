package com.example.bidaiaplikazioa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bidaiaplikazioa.ui.theme.BidaiAplikazioaTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BidaiAplikazioaTheme {
                ShowApp(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }

@Composable
fun pantallaIniciarSesion(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
){
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
                onClick = onContinueClicked,
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
    Surface (
        modifier,
        color = colorResource(id = R.color.white)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Column(modifier = Modifier
                .background(color = colorResource(id = R.color.cream))
                .width(350.dp)
                .height(240.dp)
            )
            {

            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(modifier = Modifier
                .background(color = colorResource(id = R.color.cream))
                .width(350.dp)
                .height(240.dp)
            )
            {

            }
        }

    }
}

@Composable
fun ShowApp(modifier: Modifier = Modifier){
    var mostrarAlPrincipio by remember { mutableStateOf(true) }

    Surface(modifier){
        if(mostrarAlPrincipio){
            pantallaIniciarSesion(onContinueClicked = {mostrarAlPrincipio = false})
        }else{
            paginaPrincipal()
        }
    }
}

@Composable
fun Tolosa(modifier: Modifier = Modifier) {
    Surface( // un fondo y estilo
        modifier = modifier.fillMaxSize(), // ocupa todo
        color = colorResource(id = R.color.white) // fondo blanco
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 50.dp) // padding
                .fillMaxSize(), // todo
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Kaixo Tolosara!", // Titulo
                style = MaterialTheme.typography.headlineLarge,// pa q sea grande
                modifier = Modifier.padding(bottom = 20.dp) // pa abajo espacio
            )

            // Columna 1
            Column(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.cream)) // color d la columna
                    .width(350.dp) // lo ancho d cada columna
                    .padding(16.dp) // el espacio d dentro
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically, // lo centro
                    modifier = Modifier.fillMaxWidth() // ocupa todo
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground), // foto
                        contentDescription = null, // no hay nada
                        modifier = Modifier
                            .size(80.dp) // tamañp de la foto
                            .padding(end = 16.dp) // padding pa la derecha
                    )
                    Text(
                        text = "Actividades",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.weight(1f)) // pa q se ponga a la derecha
                    Button(
                        onClick = { /* ir a la otra pagina */ },
                        modifier = Modifier
                            .padding(top = 8.dp) // espacio pa arriba
                            .height(40.dp) // anchura d arriba abajo del boton
                    ) {
                        Text(text = "IR")
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp)) // espacio con el d abajo

            // Columna 2
            Column(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.cream)) // color d la columna
                    .width(350.dp)
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                            .padding(end = 16.dp)
                    )
                    Text(
                        text = "Gastronomia",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.weight(1f)) // pa q se ponga a la derecha
                    Button(
                        onClick = { /* ir a la otra pagina */ },
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .height(40.dp)
                    ) {
                        Text(text = "IR")
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            // Columna 3
            Column(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.cream)) // color d la columna
                    .width(350.dp)
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                            .padding(end = 16.dp)
                    )
                    Text(
                        text = "Hotel",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.weight(1f)) // pa q se ponga a la derecha
                    Button(
                        onClick = { /* ir a la otra pagina */ },
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .height(40.dp)
                    ) {
                        Text(text = "IR")
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))


        }
    }
}


@Preview(showBackground = true)
@Composable
fun myAppPreviewr(){
    pantallaIniciarSesion(onContinueClicked = {})
}

@Preview(showBackground = true)
@Composable
fun previewPantallaPrincipak(){
    paginaPrincipal()
}

// para ver Tolosa
@Preview(showBackground = true)
@Composable
fun previewTolosa(){
    Tolosa()
}