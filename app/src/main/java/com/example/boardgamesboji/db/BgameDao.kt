package com.example.boardgamesboji.db

import androidx.room.*

@Dao
interface BgameDao {

    @Query("SELECT * FROM bgames")
    fun getAll(): List<BoardGameEntity>

    @Query("SELECT * FROM bgames WHERE id = :gameId")
    fun findById(gameId:Int):BoardGameEntity

    @Query("DELETE FROM bgames")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg libros:BoardGameEntity)

    @Delete
    fun delete(libro:BoardGameEntity)
}