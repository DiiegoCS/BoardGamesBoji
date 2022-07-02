package com.example.boardgamesboji.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BgameDao {

    @Query("SELECT * FROM bgames")
    fun getAll(): List<BoardGameEntity>

    @Query("SELECT * FROM bgames WHERE id = :gameId")
    fun findById(gameId:Int):BoardGameEntity

    @Query("DELETE FROM bgames")
    fun deleteAll()

    @Insert
    fun insertAll(vararg libros:BoardGameEntity)

    @Delete
    fun delete(libro:BoardGameEntity)
}