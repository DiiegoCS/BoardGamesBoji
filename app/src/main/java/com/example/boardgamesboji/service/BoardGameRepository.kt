package com.example.boardgamesboji.service

import com.example.boardgamesboji.db.BgameDao
import com.example.boardgamesboji.mapper.BgameMapper
import com.example.boardgamesboji.model.BoardGame
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BoardGameRepository(
    val boardGameService: boardGameService,
    val bgameDao: BgameDao

) {

    suspend fun findAll(): List<BoardGame> {
        return withContext(Dispatchers.IO) {
            val response = boardGameService.gameList()
            if (response.isSuccessful) {
                val bgames = response.body() ?: emptyList()

                //eliminar cache antigua
                bgameDao.deleteAll()

               //caché en bbdd
                bgames.forEach{ boardGameModelo->
                    bgameDao.insertAll(BgameMapper.toEntity(boardGameModelo))
                }
                bgames
            } else {
                bgameDao.getAll()
            }
        }
    }
}