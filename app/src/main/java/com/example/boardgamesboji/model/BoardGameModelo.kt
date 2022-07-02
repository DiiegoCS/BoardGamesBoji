package com.example.boardgamesboji.model

import com.google.gson.annotations.SerializedName

data class BoardGameModelo (

    val id: Int,
    @SerializedName("name") val nombre:String,
    @SerializedName("image") val imagen:String,
    @SerializedName("price") val precio:String,
    @SerializedName("players") val jugadores:String,
    @SerializedName("age") val edad:String,
    @SerializedName("year") val anno:Int,
    @SerializedName("playing_time") val tiempoDeJuego:String,
    @SerializedName("description") val descripcion:String,
    @SerializedName("official_link") val linkOficial:String,
    @SerializedName("Designer") val disennador:String,
    @SerializedName("Artist") val artista:String,
    @SerializedName("Publisher") val editorial:String,
    @SerializedName("classification") val clasificacion:Classification,
    )

data class Classification(
    @SerializedName("category")val categoria: String,
    @SerializedName("mechanisms")val mecanicas: String
)