package com.tad.myapplication.database.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "bulb")
data class Bulb(
    @PrimaryKey(autoGenerate = true) var id: Long,
    @ColumnInfo(name = "name") var name : String,
    @ColumnInfo(name = "state") var state: Boolean,
    @ColumnInfo(name = "location") var location: String,
)
