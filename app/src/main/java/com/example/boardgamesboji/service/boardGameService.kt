package com.example.boardgamesboji.service

import com.example.boardgamesboji.model.BoardGameModelo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface boardGameService {

    @GET("board_games")
    suspend fun gameList(): Response<List<BoardGameModelo>>

    @GET("board_games/{id}")
    suspend fun gameDetail(@Path("id") gameId: Int): Response<BoardGameModelo>
}