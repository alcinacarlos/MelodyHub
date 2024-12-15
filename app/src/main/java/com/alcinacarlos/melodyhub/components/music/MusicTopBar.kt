package com.alcinacarlos.melodyhub.components.music

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.alcinacarlos.melodyhub.R

@Composable
fun MusicTopBar() {
    val selectedItemIndex = remember { mutableIntStateOf(0) }
    println(selectedItemIndex)
    Row(
        modifier = Modifier.padding(15.dp),
        horizontalArrangement = Arrangement.spacedBy(7.dp)
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
            onClick = {
                selectedItemIndex.intValue = 0
            },
            colors = if (selectedItemIndex.intValue == 0) colorhabilitado() else colordeshabilitado()
        ) {
            Text("Todo")
        }
        Button(
            onClick = {
                selectedItemIndex.intValue = 1
            },
            colors = if (selectedItemIndex.intValue == 1) colorhabilitado() else colordeshabilitado()
        ) {
            Text("Musica")
        }
        Button(
            onClick = {
                selectedItemIndex.intValue = 2
            },
            colors = if (selectedItemIndex.intValue == 2) colorhabilitado() else colordeshabilitado()
        ) {
            Text("Podcasts")
        }
    }
}

@Composable
private fun colorhabilitado() = ButtonDefaults.buttonColors(
    containerColor = colorResource(R.color.naranja),
    contentColor = colorResource(R.color.white)
)
@Composable
private fun colordeshabilitado() = ButtonDefaults.buttonColors(
    containerColor = colorResource(R.color.grayblack),
    contentColor = colorResource(R.color.white)
)