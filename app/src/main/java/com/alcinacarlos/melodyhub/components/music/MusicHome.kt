package com.alcinacarlos.melodyhub.components.music

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alcinacarlos.melodyhub.CancionesDB
import com.alcinacarlos.melodyhub.R

@Composable
fun MusicHome(onSelectSong: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        MusicTopBar()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CancionList(CancionesDB.canciones.subList(0,4)) { onSelectSong(it)}
            CancionList(CancionesDB.canciones.subList(4,8)) { onSelectSong(it)}
        }
        Text(
            modifier = Modifier.padding(top = 10.dp, start = 20.dp),
            text = stringResource(R.string.vuelve),
            fontWeight = FontWeight.SemiBold,
            fontSize = 23.sp,
            color = colorResource(R.color.white)
        )
        CancionRow(CancionesDB.canciones) { onSelectSong(it)}

    }
}

