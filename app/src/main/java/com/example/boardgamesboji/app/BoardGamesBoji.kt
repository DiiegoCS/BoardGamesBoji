package com.example.boardgamesboji.app

import android.app.Application
import androidx.room.Room
import com.example.boardgamesboji.db.BgameDao
import com.example.boardgamesboji.model.BaseDatos
import com.example.boardgamesboji.service.boardGameService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class BoardGamesBoji: Application() {

    val baseDatos by lazy {
        Room.databaseBuilder(
            this,
            BaseDatos::class.java,
            "boardGames-bd"
        ).build()
    }

    val bgameDao by lazy { baseDatos.bgameDao() }

    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://board-games-fake-api.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val bgameService by lazy { retrofit.create(boardGameService::class.java) }
}