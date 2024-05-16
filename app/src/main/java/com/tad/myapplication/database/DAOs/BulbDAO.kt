package com.tad.myapplication.database.DAOs

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.tad.myapplication.database.Entities.Bulb
import kotlinx.coroutines.flow.Flow

@Dao
interface BulbDAO {
    @Insert
    suspend fun createNewBulb(bulb: Bulb)

    @Delete
    suspend fun deleteBulb(bulb : Bulb)

    @Query("select * from bulb")
    fun getAllBulb(): Flow<List<Bulb>>
}