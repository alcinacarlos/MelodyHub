package com.alcinacarlos.melodyhub.components.music


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alcinacarlos.melodyhub.R
import com.alcinacarlos.melodyhub.model.Cancion

@Composable
fun CancionList(canciones: List<Cancion>, selectSong: (Int) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .width(180.dp)
    ) {
        items(canciones) { cancion ->
            GastoItem(cancion){ selectSong(it)}
        }
    }
}

@Composable
fun GastoItem(cancion: Cancion, onSelectSong: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(colorResource(R.color.grayblack2))
            .clickable { onSelectSong(cancion.id) }
    ) {
        Image(
            painter = painterResource(id = cancion.album.foto),
            contentDescription = cancion.album.titulo,
            modifier = Modifier.size(48.dp)
        )
        Column(
            modifier = Modifier.weight(1f).padding(start = 6.dp, end = 5.dp)
        ) {
            Text(
                text = cancion.titulo,
                fontSize = 15.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(R.color.white)
            )
            Text(
                text = cancion.artista,
                fontSize = 13.sp,
                overflow = TextOverflow.Ellipsis,
                color = colorResource(R.color.white)
            )
        }
    }
}