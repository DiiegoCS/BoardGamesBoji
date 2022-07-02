package com.example.boardgamesboji.service

import com.example.boardgamesboji.db.BgameDao
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class BoardGameRepositoryTest{

    private lateinit var boardGameService:boardGameService
    private lateinit var bgameDao:BgameDao
    private lateinit var respository:BoardGameRepository

    @Before
    fun setup(){
        boardGameService = mockk<boardGameService>()
        bgameDao = mockk<BgameDao>()
        respository = mockk<BoardGameRepository>()
    }

    @Test
    fun datosGuardadosBd(){

    }

}