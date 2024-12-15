package com.alcinacarlos.melodyhub.components.music

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material.icons.filled.RepeatOne
import androidx.compose.material.icons.rounded.Pause
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.SkipNext
import androidx.compose.material.icons.rounded.SkipPrevious
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.zIndex
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.alcinacarlos.melodyhub.R
import com.alcinacarlos.melodyhub.model.Cancion
import kotlinx.coroutines.delay


@Composable
fun MusicPlayer(player: ExoPlayer, canciones: List<Cancion>, currentSong: Int, onSongChanged: (Int) -> Unit) {
    val cancion = canciones[currentSong]
    val uriHardcodeado = stringResource(R.string.urihardcodeado)
    var isPlaying by remember { mutableStateOf(player.isPlaying) }
    var currentPosition by remember { mutableLongStateOf(0L) }
    var repeatMode by remember { mutableIntStateOf(Player.REPEAT_MODE_ALL) }
    var currenSongState by remember { mutableIntStateOf(currentSong) }
    val duration = player.duration


    DisposableEffect(player) {
        val listener = object : Player.Listener {
            override fun onMediaItemTransition(mediaItem: MediaItem?, reason: Int) {
                val newIndex = player.currentMediaItemIndex
                if (newIndex != currenSongState) {
                    currenSongState = newIndex
                    onSongChanged(newIndex)
                }
            }
        }

        player.addListener(listener)

        onDispose {
            player.removeListener(listener)
        }
    }

    LaunchedEffect(canciones) {
        player.clearMediaItems()

        canciones.forEach{ song ->
            val urisongs = Uri.parse( uriHardcodeado + song.ruta)
            val mediasong = MediaItem.fromUri(urisongs)
            player.addMediaItem(mediasong)
        }

        player.prepare()
        player.playWhenReady = true
        isPlaying = true
    }
    LaunchedEffect(currentSong) {
        if (currentSong != currenSongState) {
            player.seekTo(currentSong, 0L)
            currenSongState = currentSong
            onSongChanged(currentSong)
        }
    }

    LaunchedEffect(repeatMode) {
        player.repeatMode = repeatMode
    }

    LaunchedEffect(isPlaying) {
        while (isPlaying) {
            currentPosition = player.currentPosition
            delay(1000L)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .zIndex(2f),
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
            Row(
                modifier = Modifier.weight(1f).padding(5.dp)
            ) {
                IconButton(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        if (currentSong != 0){
                            onSongChanged(currentSong - 1)
                            player.seekToPrevious()
                        }
                    }
                ) {
                    Icon(
                        imageVector =  Icons.Rounded.SkipPrevious,
                        contentDescription = "PlayPause",
                        tint = colorResource(R.color.white)
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
                IconButton(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        if (currentSong != canciones.size -1){
                            onSongChanged(currentSong + 1)
                            player.seekToNext()
                        }else{
                            onSongChanged(0)
                            player.seekToNext()
                        }

                    }
                ) {
                    Icon(
                        imageVector =  Icons.Rounded.SkipNext,
                        contentDescription = "PlayPause",
                        tint = colorResource(R.color.white)
                    )
                }
                IconButton(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        repeatMode = when (repeatMode) {
                            Player.REPEAT_MODE_OFF -> Player.REPEAT_MODE_ONE
                            Player.REPEAT_MODE_ONE -> Player.REPEAT_MODE_ALL
                            else -> Player.REPEAT_MODE_OFF
                        }
                    }
                ) {
                    Icon(
                        imageVector = when (repeatMode) {
                            Player.REPEAT_MODE_ONE -> Icons.Filled.RepeatOne
                            else -> Icons.Filled.Repeat
                        },
                        contentDescription = "Repeat Mode",
                        tint = when (repeatMode) {
                            Player.REPEAT_MODE_OFF -> colorResource(R.color.white)
                            else -> colorResource(R.color.naranja)
                        }
                    )
                }
            }


        }
    }
}
