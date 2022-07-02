package com.example.boardgamesboji.model

import com.google.gson.annotations.SerializedName

data class BoardGameModelo (

    override val id: Int,
    @SerializedName("name") override val nombre:String,
    @SerializedName("image") override val imagen:String,
    @SerializedName("price") override val precio:String,
    @SerializedName("players") override val jugadores:String,
    @SerializedName("age") override val edad:String,
    @SerializedName("year") override val anno:Int,
    @SerializedName("playing_time") override val tiempoDeJuego:String,
    @SerializedName("description") override val descripcion:String,
    @SerializedName("official_link") override val linkOficial:String,
    @SerializedName("Designer") override val disennador:String,
    @SerializedName("Artist") override val artista:String,
    @SerializedName("Publisher") override val editorial:String
    ): BoardGame

