package com.tad.myapplication

import com.tad.myapplication.database.AppDatabase
import com.tad.myapplication.database.Entities.AirConditioner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tad.myapplication.database.Entities.Bulb
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch

class GlobalDataContainer(private var db : AppDatabase) : ViewModel() {
    lateinit var listAirConditioner : List<AirConditioner>
    lateinit var listBulb : List<Bulb>

    fun createAirConditioner(airConditioner: AirConditioner) {
        viewModelScope.launch {
            db.getAirConditionerDAO().createAirConditioner(airConditioner)
        }
    }

    fun deleteAirConditioner(airConditioner: AirConditioner) {
        viewModelScope.launch {
            db.getAirConditionerDAO().deleteAirConditioner(airConditioner)
        }
    }

    suspend fun _init() {
        listAirConditioner = db.getAirConditionerDAO().getAllAirConditioner().last()
        listBulb = db.getBulbDAO().getAllBulb().last()

    }

    init{
        viewModelScope.launch {
            _init()
        }
    }

    fun createNewBulb(bulb: Bulb) {
        viewModelScope.launch {
           db.getBulbDAO().createNewBulb(bulb)
        }
    }

    fun deleteBulb(bulb : Bulb) {
        viewModelScope.launch {
            db.getBulbDAO().deleteBulb(bulb)
        }
    }
}