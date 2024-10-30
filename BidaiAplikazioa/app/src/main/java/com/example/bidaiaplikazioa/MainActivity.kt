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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
fun paginaPrincipal(modifier: Modifier = Modifier, onCitySelected: (String) -> Unit) {
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
                .padding(vertical = 100.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // TOLOSA
            Row(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.cream))
                    .width(390.dp)
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
                        ElevatedButton(onClick = { onCitySelected("Tolosa") }) {
                            Text(text = "Viajar")
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            // DONOSTI
            Row(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.cream))
                    .width(390.dp)
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
                        ElevatedButton(onClick = { onCitySelected("Donosti") }) {
                            Text(text = "Viajar")
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            // ZUMARRAGA
            Row(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.cream))
                    .width(390.dp)
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
                        ElevatedButton(onClick = { onCitySelected("Zumarraga") }) {
                            Text(text = "Viajar")
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            // BILBAO
            Row(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.cream))
                    .width(390.dp)
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
                        ElevatedButton(onClick = { onCitySelected("Bilbao") }) {
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

    Surface(modifier) {
        when {
            mostrarAlPrincipio -> pantallaIniciarSesion(onContinueClicked = { mostrarAlPrincipio = false })
            ciudadSeleccionada != null -> {
                when (ciudadSeleccionada) {
                    "Tolosa" -> Tolosa()
                }
            }
            else -> paginaPrincipal(onCitySelected = { ciudadSeleccionada = it })
        }

        when {
            mostrarAlPrincipio -> pantallaIniciarSesion(onContinueClicked = { mostrarAlPrincipio = false })
            ciudadSeleccionada != null -> {
                when (ciudadSeleccionada) {
                    "Donosti" -> Donosti()
                }
            }
            else -> paginaPrincipal(onCitySelected = { ciudadSeleccionada = it })
        }

        when {
            mostrarAlPrincipio -> pantallaIniciarSesion(onContinueClicked = { mostrarAlPrincipio = false })
            ciudadSeleccionada != null -> {
                when (ciudadSeleccionada) {
                    "Zumarraga" -> Zumarraga()
                }
            }
            else -> paginaPrincipal(onCitySelected = { ciudadSeleccionada = it })
        }

        when {
            mostrarAlPrincipio -> pantallaIniciarSesion(onContinueClicked = { mostrarAlPrincipio = false })
            ciudadSeleccionada != null -> {
                when (ciudadSeleccionada) {
                    "Bilbao" -> Bilbau()
                }
            }
            else -> paginaPrincipal(onCitySelected = { ciudadSeleccionada = it })
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

            Button(
                onClick = { /* ir a la otra pagina */ },
                modifier = Modifier
                    .padding(top = 8.dp, start = 7.dp) // espacio pa arriba
                    .height(40.dp) // anchura d arriba abajo del boton
                    .align(alignment= Alignment.Start) // lo d a q este full izq
                //.padding(end = 80.dp) // espacio pa arriba
            ) {
                Text(text = "ATRAS")
            }
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

@Composable
fun Donosti(modifier: Modifier = Modifier) {
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

            Button(
                onClick = { /* ir a la otra pagina */ },
                modifier = Modifier
                    .padding(top = 8.dp, start = 7.dp) // espacio pa arriba
                    .height(40.dp) // anchura d arriba abajo del boton
                    .align(alignment= Alignment.Start) // lo d a q este full izq
                //.padding(end = 80.dp) // espacio pa arriba
            ) {
                Text(text = "ATRAS")
            }
            Text(
                text = "Kaixo Donostira!", // Titulo
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


@Composable
fun Zumarraga(modifier: Modifier = Modifier) {
    Surface( // un fondo y estilo
        modifier = modifier.fillMaxSize(), // ocupa todo
        color = colorResource(id = R.color.white) // fondo blanco
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 50.dp) // padding
                .fillMaxSize(), // todo
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Button(
                onClick = { /* ir a la otra pagina */ },
                modifier = Modifier
                    .padding(top = 8.dp, start = 7.dp) // espacio pa arriba
                    .height(40.dp) // anchura d arriba abajo del boton
                    .align(alignment= Alignment.Start) // lo d a q este full izq
                //.padding(end = 80.dp) // espacio pa arriba
            ) {
                Text(text = "ATRAS")
            }
            

            Text(
                text = "Kaixo Zumarragara!", // Titulo
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


@Composable
fun Bilbau(modifier: Modifier = Modifier) {
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
            Button(
                onClick = { /* ir a la otra pagina */ },
                modifier = Modifier
                    .padding(top = 8.dp, start = 7.dp) // espacio pa arriba
                    .height(40.dp) // anchura d arriba abajo del boton
                    .align(alignment= Alignment.Start) // lo d a q este full izq
                    //.padding(end = 80.dp) // espacio pa arriba
            ) {
                Text(text = "ATRAS")
            }
            Text(
                text = "Kaixo Bilbaura!", // Titulo
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
fun previewPantallaPrincipak() {
    paginaPrincipal(onCitySelected = { city ->
    })
}

// para ver Tolosa
@Preview(showBackground = true)
@Composable
fun previewTolosa(){
    Tolosa()
}


// para ver Donosti
@Preview(showBackground = true)
@Composable
fun previewDonosti(){
    Donosti()
}

// para ver Zumarraga
@Preview(showBackground = true)
@Composable
fun previewZumarraga(){
    Zumarraga()
}

// para ver Bilbau
@Preview(showBackground = true)
@Composable
fun previewBilbau(){
    Bilbau()
}