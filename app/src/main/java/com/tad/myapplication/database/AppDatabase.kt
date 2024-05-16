package com.tad.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tad.myapplication.database.DAOs.AirConditionerDAO
import com.tad.myapplication.database.DAOs.BulbDAO
import com.tad.myapplication.database.Entities.AirConditioner
import com.tad.myapplication.database.Entities.Bulb

@Database(entities = [AirConditioner::class, Bulb::class], version = 3)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getAirConditionerDAO(): AirConditionerDAO
    abstract fun getBulbDAO(): BulbDAO
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase ?= null
        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "AppDatabase"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}