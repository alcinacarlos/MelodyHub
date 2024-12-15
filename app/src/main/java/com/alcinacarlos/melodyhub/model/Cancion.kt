package com.alcinacarlos.melodyhub.model

data class Cancion(
    val id: Int,
    val titulo: String,
    val duracion: Int,
    val artista: String,
    val album: Album,
    val genero: String,
    val ruta: String
)
