package com.example.stickyheader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContactPhone
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HeaderRecyclerView()
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HeaderRecyclerView() {
    val contactos: Map<String, List<Model>> = getContactos().groupBy { it.titulo.first().toString() }

    Box(modifier = Modifier.fillMaxSize().background(Color(0xFFFAF3E0))
        .systemBarsPadding()) {

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp), contentPadding = PaddingValues(8.dp)) {

            contactos.forEach { (marca, contactos) ->

                stickyHeader {
                    Text(
                        marca,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFF00796B))
                            .padding(8.dp),
                        style = MaterialTheme.typography.bodyLarge.copy(color = Color.White),
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    )
                }

                items(contactos) { contacto ->
                    ItemDeContacto(contacto) { }
                }
            }
        }
    }
}

@Composable
fun ItemDeContacto(modelo: Model, alSeleccionarItem: (Model) -> Unit) {
    Card(
        border = BorderStroke(1.dp, Color(0xFF00796B)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .clickable { alSeleccionarItem(modelo) }
            .shadow(2.dp, shape = MaterialTheme.shapes.medium),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Filled.ContactPhone,
                contentDescription = modelo.titulo,
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 8.dp),
                tint = Color(0xFF00796B)
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    modelo.titulo,
                    style = MaterialTheme.typography.bodyLarge.copy(color = Color.Black),
                    fontSize = 17.sp
                )
                Text(
                    modelo.telefono.toString(),
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color(0xFF616161)),
                    fontSize = 15.sp
                )
            }
        }
    }
}
