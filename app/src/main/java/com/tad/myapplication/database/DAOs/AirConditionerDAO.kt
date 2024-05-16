package com.tad.myapplication.database.DAOs

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.tad.myapplication.database.Entities.AirConditioner
import kotlinx.coroutines.flow.Flow

@Dao
interface AirConditionerDAO {
    @Insert
    suspend fun createAirConditioner(airConditioner: AirConditioner)

    @Delete
    suspend fun deleteAirConditioner(airConditioner: AirConditioner)

    @Query("select * from conditioner")
    fun getAllAirConditioner(): Flow<List<AirConditioner>>
}