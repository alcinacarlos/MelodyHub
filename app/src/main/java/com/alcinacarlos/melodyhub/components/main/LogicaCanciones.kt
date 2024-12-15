package com.alcinacarlos.melodyhub.components.main


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.alcinacarlos.melodyhub.model.Cancion

@Composable
fun CancionList(canciones: List<Cancion>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(canciones) { cancion ->
            GastoItem(cancion)
            HorizontalDivider()
        }
    }
}

@Composable
fun GastoItem(cancion: Cancion) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = cancion.album.foto),
            contentDescription = cancion.album.titulo,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = cancion.titulo,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = cancion.artista,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}