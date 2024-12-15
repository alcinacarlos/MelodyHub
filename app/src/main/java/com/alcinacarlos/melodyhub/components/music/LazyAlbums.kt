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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alcinacarlos.melodyhub.R
import com.alcinacarlos.melodyhub.model.Album
import com.alcinacarlos.melodyhub.model.Cancion

@Composable
fun AlbumList(albums: List<Album>) {
    Column(
        modifier = Modifier.padding(bottom = 85.dp)
    ){
        Text(
            text = "Albums",
            fontSize = 25.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(R.color.white),
            modifier = Modifier.padding(20.dp)

        )
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(5.dp)
        ) {
            items(albums) { album ->
                AlbumItem(album)
            }
        }
    }


}

@Composable
fun AlbumItem(album: Album) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(colorResource(R.color.grayblack2))
    ) {
        Image(
            painter = painterResource(id = album.foto),
            contentDescription = album.titulo,
            modifier = Modifier.size(140.dp)
        )
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = album.titulo,
                fontSize = 17.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(R.color.white)
            )
            Column(
                modifier = Modifier.padding(4.dp)
            ) {
                Row(
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text(
                        text = "Artista: ",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        overflow = TextOverflow.Ellipsis,
                        color = colorResource(R.color.white)
                    )
                    Text(
                        text = album.grupo,
                        fontSize = 14.sp,
                        overflow = TextOverflow.Ellipsis,
                        color = colorResource(R.color.white)
                    )
                }
                Row(
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text(
                        text = "Genero: ",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        overflow = TextOverflow.Ellipsis,
                        color = colorResource(R.color.white)
                    )
                    Text(
                        text = album.genero,
                        fontSize = 14.sp,
                        overflow = TextOverflow.Ellipsis,
                        color = colorResource(R.color.white)
                    )
                }
                Row(
                    modifier = Modifier.padding(4.dp)
                ) {
                    Text(
                        text = "Lanzamiento: ",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        overflow = TextOverflow.Ellipsis,
                        color = colorResource(R.color.white)
                    )
                    Text(
                        text = album.fechaLanzamiento,
                        fontSize = 14.sp,
                        overflow = TextOverflow.Ellipsis,
                        color = colorResource(R.color.white)
                    )
                }
            }

        }
    }
}