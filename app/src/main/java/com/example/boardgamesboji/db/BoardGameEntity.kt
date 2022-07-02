package com.example.boardgamesboji.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.boardgamesboji.model.BoardGame



@Entity(tableName = "bgames")
data class BoardGameEntity (
    @PrimaryKey override val id: Int,
    override val nombre:String,
    override  val imagen:String,
    override  val precio:String,
    override val jugadores:String,
    override val edad:String,
    override val anno:Int,
    override val tiempoDeJuego:String,
    override val descripcion:String,
    override val linkOficial:String,
    override val disennador:String,
    override val artista:String,
    override val editorial:String,
):BoardGame

