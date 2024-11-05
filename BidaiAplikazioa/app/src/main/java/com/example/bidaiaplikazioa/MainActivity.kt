package com.example.bidaiaplikazioa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                "Bienvenido a nuestra aplicación de reservas!"
            )
            OutlinedTextField(
                value = text,
                onValueChange = {text = it}, //onValueChange = { text = it }: Cada vez que el usuario escriba algo,
                // el contenido del campo de texto cambiará y actualizará el valor de text
                label = { Text("Nombre") },
                placeholder = {Text("Pon tu nombre")},
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.padding(vertical = 18.dp),
            )
            Button(
                onClick = onContinueClicked,
                modifier.padding(vertical = 24.dp),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.black)),
            ) {
                Text("Entrar")
            }
        }
    }
}

@Composable
fun paginaPrincipal(modifier: Modifier = Modifier, botonDeSelecionarCiudad: (String) -> Unit) {
    val tolosaImage = painterResource(R.drawable.tolosa)
    val donostiImage = painterResource(R.drawable.san_sebastian_3)
    val zumarragaImage = painterResource(R.drawable.zumarraga)
    val bilbaoImage = painterResource(R.drawable.bilbao)

    Surface(
        modifier = modifier,
        color = colorResource(id = R.color.white)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .clip(shape = RoundedCornerShape(20.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            // TOLOSA
            Row(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.cream))
                    .width(360.dp)
                    .height(240.dp)
            ) {
                Column(modifier = Modifier.fillMaxHeight().width(200.dp)) {
                    Row(
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "TOLOSA",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.offset(x = (-10).dp)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxHeight().fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Tolosa, un destino lleno de historia y tradiciones vascas.",
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W200
                        )
                    }
                }
                Column(modifier = Modifier.fillMaxWidth().width(200.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth().height(150.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = tolosaImage,
                            contentDescription = null,
                            modifier = Modifier.width(180.dp).height(150.dp)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        ElevatedButton(onClick = { botonDeSelecionarCiudad("Tolosa") }) {
                            Text(text = "Viajar")
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(40.dp))

            // DONOSTI
            Row(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.cream))
                    .width(360.dp)
                    .height(240.dp)
            ) {
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .width(200.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "DONOSTI",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.offset(x = (-10).dp)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxHeight().fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Descubre Donosti, la joya del País Vasco, conocida por su hermosa Bahía de la Concha",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.W200,
                            fontSize = 20.sp
                        )
                    }
                }
                Column(modifier = Modifier.fillMaxWidth().width(200.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth().height(150.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = donostiImage,
                            contentDescription = null,
                            modifier = Modifier.width(180.dp).height(150.dp)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        ElevatedButton(onClick = { botonDeSelecionarCiudad("Donosti") }) {
                            Text(text = "Viajar")
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(40.dp))

            // ZUMARRAGA
            Row(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.cream))
                    .width(360.dp)
                    .height(240.dp)
            ) {
                Column(modifier = Modifier.fillMaxHeight().width(200.dp)) {
                    Row(
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "ZUMARRAGA",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.offset(x = (-10).dp)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxHeight().fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Zumarraga, un rincón acogedor de Gipuzkoa, es conocido por su entorno natural.",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.W200,
                            fontSize = 18.sp
                        )
                    }
                }
                Column(modifier = Modifier.fillMaxWidth().width(200.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth().height(150.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = zumarragaImage,
                            contentDescription = null,
                            modifier = Modifier.width(180.dp).height(150.dp)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        ElevatedButton(onClick = { botonDeSelecionarCiudad("Zumarraga") }) {
                            Text(text = "Viajar")
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(40.dp))

            // BILBAO
            Row(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.cream))
                    .width(360.dp)
                    .height(240.dp)
            ) {
                Column(modifier = Modifier.fillMaxHeight().width(200.dp)) {
                    Row(
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "BILBAO",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.offset(x = (-10).dp)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxHeight().fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Bilbao, ciudad moderna y cosmopolita, combina su esencia industrial con arte y arquitectura innovadora",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.W200,
                            fontSize = 17.sp
                        )
                    }
                }
                Column(modifier = Modifier.fillMaxWidth().width(200.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth().height(150.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = bilbaoImage,
                            contentDescription = null,
                            modifier = Modifier.width(180.dp).height(150.dp)
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        ElevatedButton(onClick = { botonDeSelecionarCiudad("Bilbao") }) {
                            Text(text = "Viajar")
                        }
                    }
                }
            }
        }
    }
}



@Composable
fun ShowApp(modifier: Modifier = Modifier) {
    var mostrarAlPrincipio by remember { mutableStateOf(true) }
    var ciudadSeleccionada by remember { mutableStateOf<String?>(null) }
    var mostrarActividades by remember { mutableStateOf(false) }
    var mostrarGastronomia by remember { mutableStateOf(false) }
    var mostrarHoteles by remember { mutableStateOf(false) }


        Surface(modifier) { // resumido d lo d antes
            when {
                mostrarAlPrincipio -> pantallaIniciarSesion(onContinueClicked = { mostrarAlPrincipio = false })
                mostrarActividades -> actividadesTolosa(irAtras = {mostrarActividades = false})
                mostrarGastronomia -> gastronomiaTolosa(irAtras = {mostrarGastronomia = false})
                mostrarHoteles -> hotelesTolosa(irAtras = {mostrarHoteles = false})
                ciudadSeleccionada != null -> {
                    when (ciudadSeleccionada) {
                        "Tolosa" -> Tolosa(
                            botonDeAtras = { ciudadSeleccionada = null },
                            botonActividades = {mostrarActividades = true},
                            irGastronomia = {mostrarGastronomia = true},
                            irHoteles = { mostrarHoteles = true}
                        )
                        "Donosti" -> Donosti(botonDeAtras = { ciudadSeleccionada = null })
                        "Zumarraga" -> Zumarraga(botonDeAtras = { ciudadSeleccionada = null })
                        "Bilbao" -> Bilbau(botonDeAtras = { ciudadSeleccionada = null })
                    }
                }
                else -> paginaPrincipal(botonDeSelecionarCiudad = { ciudadSeleccionada = it }) // f
            }
        }
    }


@Composable
fun Tolosa(modifier: Modifier = Modifier, botonDeAtras: () -> Unit,
           botonActividades: () -> Unit, irGastronomia: () -> Unit,
           irHoteles: () -> Unit) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = colorResource(id = R.color.white)
    )
    {
        Column(
            modifier = Modifier
                .background(color = colorResource(id = R.color.white))
                .fillMaxHeight()
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Row(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.cream))
                    .fillMaxWidth() // Asegúrate de que llene el ancho del contenedor
                    .height(140.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ){
                Column(
                    modifier = Modifier

                        .fillMaxHeight()
                        .background(color = colorResource(R.color.cream))
                        .width(80.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

                )
                {
                    IconButton(
                        onClick = botonDeAtras
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            modifier = Modifier
                                .size(27.dp)
                        )
                    }
                }
                Spacer(modifier.width(60.dp))
                Text(
                    text = "TOLOSA",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier.height(60.dp)) // entre tolosa y lo d abajo

            // Columna 1
            Column(
            modifier = Modifier
                .background(color = colorResource(id = R.color.cream)) // color d la columna
                .width(350.dp) // lo ancho d cada columna
                .padding(16.dp) // el espacio d dentroç
                .fillMaxSize(), // todo
            ) {
                Row(
                   verticalAlignment = Alignment.CenterVertically, // lo centro
                    modifier = Modifier.fillMaxWidth() // ocupa todo

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.actividad), // foto
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
                        onClick = botonActividades,
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
                        painter = painterResource(id = R.drawable.gastronomia),
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
                        onClick = irGastronomia,
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
                        painter = painterResource(id = R.drawable.hotel),
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
                        onClick = irHoteles,
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

@Composable
fun Donosti(modifier: Modifier = Modifier, botonDeAtras: () -> Unit) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = colorResource(id = R.color.white)
    )
    {
        Column(
            modifier = Modifier
                .background(color = colorResource(id = R.color.white))
                .fillMaxHeight()
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Row(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.cream))
                    .fillMaxWidth() // Asegúrate de que llene el ancho del contenedor
                    .height(140.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ){
                Column(
                    modifier = Modifier

                        .fillMaxHeight()
                        .background(color = colorResource(R.color.cream))
                        .width(80.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

                )
                {
                    IconButton(
                        onClick = botonDeAtras
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            modifier = Modifier
                                .size(27.dp)
                        )
                    }
                }
                Spacer(modifier.width(60.dp))
                Text(
                    text = "DONOSTI",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier.height(60.dp)) // entre tolosa y lo d abajo


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
                        painter = painterResource(id = R.drawable.actividad), // foto
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
                        painter = painterResource(id = R.drawable.gastronomia),
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
                        painter = painterResource(id = R.drawable.hotel),
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


@Composable
fun Zumarraga(modifier: Modifier = Modifier, botonDeAtras: () -> Unit) {
    Surface( // fondo y estilo
        modifier = modifier.fillMaxSize(), // ocupa todo el espacio
        color = colorResource(id = R.color.white) // fondo blanco
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Row(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.cream))
                    .fillMaxWidth() // Asegura que llene el ancho
                    .height(140.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .background(color = colorResource(id = R.color.cream))
                        .width(80.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(
                        onClick = botonDeAtras // Accion al hacer clic
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            modifier = Modifier.size(27.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(60.dp))
                Text(
                    text = "ZUMARRAGA",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Espaciador inferior
            Spacer(modifier = Modifier.height(60.dp))

            // Columna 1
            Column(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.cream))
                    .width(350.dp)
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.actividad),
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                            .padding(end = 16.dp)
                    )
                    Text(
                        text = "Actividades",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        onClick = { /* Navegar a otra página */ },
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .height(40.dp)
                    ) {
                        Text(text = "IR")
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Columna 2
            Column(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.cream))
                    .width(350.dp)
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.gastronomia),
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                            .padding(end = 16.dp)
                    )
                    Text(
                        text = "Gastronomia",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        onClick = { /* Navegar a otra página */ },
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
                    .background(color = colorResource(id = R.color.cream))
                    .width(350.dp)
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.hotel),
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                            .padding(end = 16.dp)
                    )
                    Text(
                        text = "Hotel",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        onClick = { /* Navegar a otra página */ },
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


@Composable
fun Bilbau(modifier: Modifier = Modifier, botonDeAtras: () -> Unit) {
    Surface( // fondo y estilo
        modifier = modifier.fillMaxSize(), // ocupa todo el espacio
        color = colorResource(id = R.color.white) // fondo blanco
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            // Fila personalizada con el botón de retroceso y el título
            Row(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.cream))
                    .fillMaxWidth() // Asegura que llene el ancho
                    .height(140.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .background(color = colorResource(id = R.color.cream))
                        .width(80.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(
                        onClick = botonDeAtras // Accion al hacer clic
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            modifier = Modifier.size(27.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(60.dp))
                Text(
                    text = "BILBAO",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Espaciador inferior
            Spacer(modifier = Modifier.height(60.dp))

            // Columna 1
            Column(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.cream))
                    .width(350.dp)
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.actividad),
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                            .padding(end = 16.dp)
                    )
                    Text(
                        text = "Actividades",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        onClick = { /* Navegar a otra página */ },
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .height(40.dp)
                    ) {
                        Text(text = "IR")
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Columna 2
            Column(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.cream))
                    .width(350.dp)
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.gastronomia),
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                            .padding(end = 16.dp)
                    )
                    Text(
                        text = "Gastronomia",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        onClick = { /* Navegar a otra página */ },
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
                    .background(color = colorResource(id = R.color.cream))
                    .width(350.dp)
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.hotel),
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                            .padding(end = 16.dp)
                    )
                    Text(
                        text = "Hotel",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        onClick = { /* Navegar a otra página */ },
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


@Composable
fun actividadesTolosa(modifier: Modifier = Modifier, irAtras: () -> Unit){
    Surface(
        modifier = modifier.fillMaxSize(),
        color = colorResource(id = R.color.white)
    )
    {
        Column(
            modifier = Modifier
                .background(color = colorResource(id = R.color.white))
                .fillMaxHeight()
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        )
        {Row(
            modifier = Modifier
                .background(color = colorResource(id = R.color.cream))
                .fillMaxWidth()
                .height(140.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = irAtras,
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier.size(27.dp)
                )
            }

            Text(
                text = "Actividades Tolosa",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            Spacer(modifier = Modifier.width(48.dp))
        }

            Spacer(modifier.height(60.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .background(color = colorResource(id = R.color.white)),
                contentAlignment = Alignment.Center
            ){
                Card (
                    modifier = Modifier
                        .width(270.dp)
                        .fillMaxHeight(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                )
                {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ){
                        Image(
                            contentDescription = null,
                            painter = painterResource(id = R.drawable.cascoantiguo)
                        )
                        Text(
                            text = "Casco Viejo",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .padding(10.dp)
                        )
                        Text(
                            text = "Pasea por las estrechas calles medievales, observa las casas señoriales y " +
                                    "la arquitectura histórica como la Casa Consistorial y las plazas Triángulo y Euskal Herria.",
                            fontSize = 13.sp,
                            modifier = Modifier
                                .padding(6.dp),
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.Gray
                        )
                    }
                }
            }
            //Nuevas actividades
            Spacer(modifier.height(60.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .background(color = colorResource(id = R.color.white)),
                contentAlignment = Alignment.Center
            ){
                Card(
                    modifier = Modifier
                        .width(270.dp)
                        .fillMaxHeight(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Image(
                            contentDescription = null,
                            painter = painterResource(id = R.drawable.interior_museo_gorrotxategi)
                        )
                        Text(
                            text = "Museo de la Confitería Gorrotxategi",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(10.dp)
                        )
                        Text(
                            text = "Conoce la historia de la repostería en Tolosa, famosa por sus tejas y cigarrillos de Tolosa.",
                            fontSize = 13.sp,
                            modifier = Modifier
                                .padding(6.dp),
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.Gray
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(60.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .background(color = colorResource(id = R.color.white)),
                contentAlignment = Alignment.Center
            ){
                Card(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(270.dp)
                        .background(color = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white))
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Image(
                            contentDescription = null,
                            painter = painterResource(id = R.drawable.azoka_2_1)
                        )
                        Text(
                            text = "Mercado de Tolosa",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(10.dp)
                        )
                        Text(
                            text = "Mercado del Sábado: Famoso en toda la región, con productos frescos, artesanías y delicias locales. Especialmente recomendable para disfrutar de la gastronomía vasca.",
                            fontSize = 13.sp,
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.Gray,
                            modifier = Modifier.padding(6.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}

@Composable
fun gastronomiaTolosa(modifier: Modifier = Modifier, irAtras: () -> Unit){
    Surface(
        modifier = modifier.fillMaxSize(),
        color = colorResource(id = R.color.white)
    ) {
        Column(
            modifier = Modifier
                .background(color = colorResource(id = R.color.white))
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ){
            Row(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.cream))
                    .fillMaxWidth()
                    .height(140.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = irAtras,
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.size(27.dp)
                    )
                }

                Text(
                    text = "Gastronomia Tolosa",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                Spacer(modifier = Modifier.width(48.dp))
            }
            Spacer(modifier.height(60.dp))
            Box(
                modifier = Modifier
                    .height(380.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Card(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(270.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white))
                ){
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            contentDescription = null,
                            painter = painterResource(id = R.drawable.melemele)
                        )
                        Text(
                            text = "Mele-Mele",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .padding(10.dp)
                        )
                        Text(
                            text = "Este restaurante es conocido por sus hamburguesas gourmet y " +
                                    "otros platos de estilo casual con ingredientes de alta calidad. También ofrecen opciones vegetarianas y veganas.",
                            fontSize = 13.sp,
                            modifier = Modifier
                                .padding(6.dp),
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
            Spacer(modifier.height(60.dp))
            Box(
                modifier = Modifier
                    .height(350.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Card(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(270.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white))
                ){
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            contentDescription = null,
                            painter = painterResource(id = R.drawable.casajulian)
                        )
                        Text(
                            text = "Restaurante Casa Julián",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .padding(10.dp)
                        )
                        Text(
                            text = "Conocido por su famoso chuletón a la brasa, Casa Julián es una parada obligatoria para los amantes de la carne.",
                            fontSize = 13.sp,
                            modifier = Modifier
                                .padding(6.dp),
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
            Spacer(modifier.height(60.dp))
            Box(
                modifier = Modifier
                    .height(350.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Card(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(270.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white))
                ){
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            contentDescription = null,
                            painter = painterResource(id = R.drawable.botarrijatetxea)
                        )
                        Text(
                            text = "Restaurante Botarri",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .padding(10.dp)
                        )
                        Text(
                            text = "Ofrece una selección de cocina tradicional vasca con productos locales. " +
                                    "Es conocido por sus menús que incluyen platos como el alubión de Tolosa.",
                            fontSize = 13.sp,
                            modifier = Modifier
                                .padding(6.dp),
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
            Spacer(modifier.height(80.dp))
        }
    }
}

@Composable
fun hotelesTolosa(modifier: Modifier = Modifier, irAtras: () -> Unit){
    Surface(
        modifier = Modifier
            .fillMaxSize(),
            color = colorResource(id = R.color.white)
    ){
        Column(modifier = Modifier
            .background(color = colorResource(id = R.color.white))
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
        ){
            Row(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.cream))
                    .fillMaxWidth()
                    .height(140.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = irAtras,
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.size(27.dp)
                    )
                }

                Text(
                    text = "Hoteles Tolosa",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                Spacer(modifier = Modifier.width(48.dp))
            }
            Spacer(modifier.height(60.dp))
            Box(
                modifier = Modifier
                    .height(380.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Card(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(270.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white))
                ){
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            contentDescription = null,
                            painter = painterResource(id = R.drawable.otel_oria)
                        )
                        Text(
                            text = "Hotel Oria",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .padding(10.dp)
                        )
                        Text(
                            text = "Un hotel acogedor y céntrico, ubicado cerca del casco antiguo y del río Oria.",
                            fontSize = 16.sp,
                            modifier = Modifier
                                .padding(6.dp),
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
            Spacer(modifier.height(60.dp))
            Box(
                modifier = Modifier
                    .height(350.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Card(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(270.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white))
                ){
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            contentDescription = null,
                            painter = painterResource(id = R.drawable.hotelbidebide)
                        )
                        Text(
                            text = "Hotel Bide Bide",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .padding(10.dp)
                        )
                        Text(
                            text = "Un hotel boutique ubicado en pleno centro histórico de Tolosa.",
                            fontSize = 13.sp,
                            modifier = Modifier
                                .padding(6.dp),
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
            Spacer(modifier.height(60.dp))
            Box(
                modifier = Modifier
                    .height(350.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Card(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(270.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white))
                ){
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            contentDescription = null,
                            painter = painterResource(id = R.drawable.casarural_korteta)
                        )
                        Text(
                            text = "Casa Rural Korteta",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .padding(10.dp)
                        )
                        Text(
                            text = "Una casa rural situada a las afueras de Tolosa, ideal para quienes desean un entorno más tranquilo y natural.",
                            fontSize = 13.sp,
                            modifier = Modifier
                                .padding(6.dp),
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
            Spacer(modifier.height(80.dp))
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
fun previewPantallaPrincipak() {
    paginaPrincipal(botonDeSelecionarCiudad = { city ->
    })
}

// Para ver tolosa
@Preview(showBackground = true)
@Composable
fun previewTolosa() {
    Tolosa(botonDeAtras = {}, botonActividades = {},
        irGastronomia = {}, irHoteles = {})
}


// para ver Donosti
@Preview(showBackground = true)
@Composable
fun previewDonosti(){
    Donosti(botonDeAtras = { /* NO TOCAR */ })
}

// para ver Zumarraga
@Preview(showBackground = true)
@Composable
fun previewZumarraga(){
    Zumarraga(botonDeAtras = { /* NO TOCAR */ })
}

// para ver Bilbau
@Preview(showBackground = true)
@Composable
fun previewBilbau(){
    Bilbau(botonDeAtras = { /* NO TOCAR */ })
}

@Preview(showBackground = true)
@Composable
fun previewActividades(){
    actividadesTolosa(irAtras = {})
}

@Preview(showBackground = true)
@Composable
fun previewGastronomiaTolosa(){
    gastronomiaTolosa(irAtras = {})
}

@Preview(showBackground = true)
@Composable
fun previewHotelesTolosa(){
    hotelesTolosa(irAtras = {})
}