package com.example.boardgamesboji.mapper

import com.example.boardgamesboji.db.BoardGameEntity
import com.example.boardgamesboji.model.BoardGame

class BgameMapper {

    companion object{
        fun toEntity(boardGame: BoardGame): BoardGameEntity {
            with(boardGame){
                return BoardGameEntity(
                        id, nombre, imagen, precio, jugadores, edad, anno, tiempoDeJuego, descripcion, linkOficial, disennador, artista, editorial
                )
            }
        }
    }
}