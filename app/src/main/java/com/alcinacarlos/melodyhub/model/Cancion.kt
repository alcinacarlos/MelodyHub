package com.alcinacarlos.melodyhub.model

data class Cancion(
    val titulo: String,
    val duracion: Int,
    val artista: String,
    val album: Album,
    val genero: String
)
