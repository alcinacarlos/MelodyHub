package com.alcinacarlos.melodyhub.components.music


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
fun CancionRow(canciones: List<Cancion>, selectSong: (Int) -> Unit) {
    LazyRow(
        modifier = Modifier.fillMaxWidth().padding(20.dp).height(260.dp)
    ) {
        items(canciones) { cancion ->
            CancionItemRow(cancion){ selectSong(it)}
        }
    }
}

@Composable
fun CancionItemRow(cancion: Cancion, onSelectSong: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(5.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(colorResource(R.color.grayblack2))
            .clickable { onSelectSong(cancion.id) }
    ) {
        Image(
            painter = painterResource(id = cancion.album.foto),
            contentDescription = cancion.album.titulo,
            modifier = Modifier.size(180.dp)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 10.dp, top = 10.dp)
                .widthIn(30.dp,180.dp)
        ) {
            Text(
                text = cancion.titulo,
                fontSize = 20.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(R.color.white)
            )
            Text(
                text = cancion.artista,
                fontSize = 16.sp,
                overflow = TextOverflow.Ellipsis,
                color = colorResource(R.color.white)
            )
        }
    }
}

@Composable
fun CancionList(canciones: List<Cancion>, selectSong: (Int) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .width(180.dp)
    ) {
        items(canciones) { cancion ->
            CancionItem(cancion){ selectSong(it)}
        }
    }
}

@Composable
fun CancionItem(cancion: Cancion, onSelectSong: (Int) -> Unit) {
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