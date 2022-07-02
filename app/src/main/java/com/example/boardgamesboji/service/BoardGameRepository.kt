package com.example.boardgamesboji.service

import com.example.boardgamesboji.model.BoardGameModelo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BoardGameRepository {

    val boardGameService: boardGameService

    init {
        //Retrofit
        val baseUrl = "https://board-games-fake-api.herokuapp.com/"
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        boardGameService =
            retrofit.create(com.example.boardgamesboji.service.boardGameService::class.java)
    }

    suspend fun findAll(): List<BoardGameModelo> {
        return withContext(Dispatchers.IO) {
            val response = boardGameService.gameList()
            response.body() ?: emptyList()
        }
    }
}