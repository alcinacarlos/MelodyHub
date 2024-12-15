package com.alcinacarlos.melodyhub.components.music

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.alcinacarlos.melodyhub.CancionesDB
import com.alcinacarlos.melodyhub.R
import com.alcinacarlos.melodyhub.components.main.CancionList

@Composable
fun MusicHome() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        MusicTopBar()
        Row(
            modifier = Modifier.fillMaxWidth().padding(20.dp)
        ) {
            CancionList(CancionesDB.listaCanciones)
        }
    }
}


@Composable
fun MusicTopBar() {
    Row(
        modifier = Modifier.padding(30.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Foto de perfil",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(50.dp)
                .clip(CircleShape)
        )
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.naranja))
        ) {
            Text("Todo")
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.grayblack))
        ) {
            Text("Musica")
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.grayblack))
        ) {
            Text("Podcasts")
        }
    }
}