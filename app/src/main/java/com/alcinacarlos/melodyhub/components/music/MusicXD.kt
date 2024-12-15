package com.alcinacarlos.melodyhub.components.music

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Pause
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.alcinacarlos.melodyhub.R
import com.alcinacarlos.melodyhub.model.Cancion
import kotlinx.coroutines.delay


@Composable
fun MusicPlayer(player: ExoPlayer, canciones: List<Cancion>, currentSong: Int) {
    val cancion = canciones[currentSong]
    val uri = Uri.parse(stringResource(R.string.urihardcodeado) + cancion.ruta)

    var isPlaying by remember { mutableStateOf(player.isPlaying) }
    var currentPosition by remember { mutableLongStateOf(0L) }
    val duration = player.duration

    // Prepara la canción actual si no está cargada
    LaunchedEffect(currentSong) {
        player.clearMediaItems()
        val mediaItem = MediaItem.fromUri(uri)
        player.setMediaItem(mediaItem)
        player.prepare()
        player.playWhenReady = true
        isPlaying = true
    }

    // Actualiza la posición mientras la canción está reproduciéndose
    LaunchedEffect(isPlaying) {
        while (isPlaying) {
            currentPosition = player.currentPosition
            delay(1000L)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(colorResource(R.color.grayblack2))
        ) {
            Image(
                painter = painterResource(id = cancion.album.foto),
                contentDescription = cancion.album.titulo,
                modifier = Modifier.size(60.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp)
            ) {
                Text(
                    text = cancion.titulo,
                    fontSize = 18.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(R.color.white)
                )
                Text(
                    text = cancion.artista,
                    fontSize = 15.sp,
                    overflow = TextOverflow.Ellipsis,
                    color = colorResource(R.color.white)
                )
            }

            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {
                    if (isPlaying) {
                        player.pause()
                    } else {
                        player.play()
                    }
                    isPlaying = !isPlaying
                }
            ) {
                Icon(
                    imageVector = if (isPlaying) Icons.Rounded.Pause else Icons.Rounded.PlayArrow,
                    contentDescription = "PlayPause",
                    tint = colorResource(R.color.white)
                )
            }
        }
    }
}


@SuppressLint("DefaultLocale")
fun formatTime(milliseconds: Long): String {
    val minutes = (milliseconds / 1000) / 60
    val seconds = (milliseconds / 1000) % 60
    return String.format("%02d:%02d", minutes, seconds)
}