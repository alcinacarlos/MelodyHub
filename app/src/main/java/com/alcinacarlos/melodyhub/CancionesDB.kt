package com.alcinacarlos.melodyhub

import androidx.compose.ui.modifier.modifierLocalMapOf
import com.alcinacarlos.melodyhub.model.Album
import com.alcinacarlos.melodyhub.model.Cancion

object CancionesDB {
    val albums = listOf(
        Album(
            titulo = "The Bends",
            fechaLanzamiento = "1995-03-13",
            genero = "Alternative Rock",
            foto = R.drawable.creep,
            grupo = "Radiohead"
        ),
        Album(
            titulo = "Master of Puppets",
            fechaLanzamiento = "1986-03-03",
            genero = "Heavy Metal",
            foto = R.drawable.master_puppets,
            grupo = "Metallica"
        ),
        Album(
            titulo = "Breakfast in America",
            fechaLanzamiento = "1979-03-29",
            genero = "Rock",
            foto = R.drawable.supertrump,
            grupo = "Supertramp"
        ),
        Album(
            titulo = "The Queen Is Dead",
            fechaLanzamiento = "1986-06-16",
            genero = "Alternative Rock",
            foto = R.drawable.thequeenisdead,
            grupo = "The Smiths"
        ),
        Album(
            titulo = "Franz Ferdinand",
            fechaLanzamiento = "2004-02-09",
            genero = "Indie Rock",
            foto = R.drawable.thisfire,
            grupo = "Franz Ferdinand"
        )
    )

    val canciones = listOf(
        Cancion(
            id = 0,
            titulo = "Creep",
            duracion = 239,
            artista = "Radiohead",
            album = albums[0],
            genero = "Alternative Rock",
            ruta = "creep"
        ),
        Cancion(
            id = 1,
            titulo = "Master of Puppets",
            duracion = 516,
            artista = "Metallica",
            album = albums[1],
            genero = "Heavy Metal",
            ruta = "master_puppets"
        ),
        Cancion(
            id = 2,
            titulo = "Goodbye Stranger",
            duracion = 296,
            artista = "Supertramp",
            album = albums[2],
            genero = "Rock",
            ruta = "goodbyestranger"
        ),
        Cancion(
            id = 3,
            titulo = "I Know It's Over",
            duracion = 271,
            artista = "The Smiths",
            album = albums[3],
            genero = "Alternative Rock",
            ruta = "iknowitsover"
        ),
        Cancion(
            id = 4,
            titulo = "There Is a Light That Never Goes Out",
            duracion = 243,
            artista = "The Smiths",
            album = albums[3],
            genero = "Alternative Rock",
            ruta = "there_is_a_light"
        ),
        Cancion(
            id = 5,
            titulo = "Gone Hollywood",
            duracion = 309,
            artista = "Supertramp",
            album = albums[2],
            genero = "Rock",
            ruta = "gonehollywood"
        ),
        Cancion(
            id = 6,
            titulo = "This Fire",
            duracion = 233,
            artista = "Franz Ferdinand",
            album = albums[4],
            genero = "Indie Rock",
            ruta = "thisfire"
        ),
        Cancion(
            id = 7,
            titulo = "Welcome Home",
            duracion = 376,
            artista = "Metallica",
            album = albums[1],
            genero = "Heavy Metal",
            ruta = "master_puppets"
        ),
    )
}
