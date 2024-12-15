package com.alcinacarlos.melodyhub.model

data class Album(
    val titulo: String,
    val fechaLanzamiento: String,
    val genero: String,
    val foto: Int,
    val canciones: List<Cancion> = emptyList(),
    val grupo: String
)
