package com.tad.myapplication.database.Entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "conditioner")
data class AirConditioner(
    @PrimaryKey(autoGenerate = true) var id: Long,
    @ColumnInfo(name = "name") var name : String,
    @ColumnInfo(name = "state") var state: Boolean,
    @ColumnInfo(name = "temperature") var temperature: Long,
    @ColumnInfo(name = "location") var location: String,
)
