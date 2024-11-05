package com.example.bidaiaplikazioa.uiElements

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.createBitmap
import com.example.bidaiaplikazioa.R

@Composable
fun confirmarReserva(
    onDismiss: () -> Unit
) {
    AlertDialog(
        confirmButton = {},
        onDismissRequest = onDismiss,
        modifier =  Modifier
            .height(250.dp),

        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Reserva",
                    modifier = Modifier.size(27.dp)
                )
                Text(text = "Esta ha sido tu reserva",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold                )
            }
        },

        text = {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .width(180.dp)
                        .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.black))
                ) {
                    Text(
                        text = "Aceptar",
                    )
                }
            }
        }
    )
}

