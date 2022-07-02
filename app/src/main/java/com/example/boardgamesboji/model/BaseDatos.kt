package com.example.boardgamesboji.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.boardgamesboji.db.BgameDao
import com.example.boardgamesboji.db.BoardGameEntity

@Database(entities = [BoardGameEntity::class], version = 1)
abstract class BaseDatos: RoomDatabase() {

    abstract fun bgameDao():BgameDao
}