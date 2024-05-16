package com.tad.myapplication.Screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.tad.myapplication.components.InsertCard
import com.tad.myapplication.database.Entities.AirConditioner
import com.tad.myapplication.database.Entities.Bulb
import com.tad.dashboard.enums.DeviceType
import com.tad.myapplication.GlobalDataContainer
import com.tad.myapplication.components.BottomBar
import com.tad.myapplication.components.ButtonAdd
import com.tad.myapplication.components.DeviceRow

val listConditioner = listOf<AirConditioner>(
    AirConditioner(
        id = 1,
        name = "XTH_1",
        state = false,
        temperature = 20L,
        location = "First room"),
    AirConditioner(
        id = 1,
        name = "XTH_2",
        state = true,
        temperature = 25L,
        location = "Second room")
)

val listBulb = listOf<Bulb>(
    Bulb(
        id = 1,
        name = "GXT_1",
        state = false,
        location = "First floor"
    ),
    Bulb(
        id = 2,
        name = "GXT_2",
        state = false,
        location = "Second floor"
    ),
    Bulb(
        id = 3,
        name = "GXT_3",
        state = false,
        location = "Third floor"
    )
)
@Composable
fun Devices(
    viewModel : GlobalDataContainer,
    navController: NavController
) {
    var openDialog by remember { mutableStateOf(false) }
    Column (modifier = Modifier.padding(top = 70.dp)) {
        Text(
            "Devices",
            fontSize = 23.sp,
            fontWeight = FontWeight.W700,
            modifier = Modifier.padding(start = 10.dp),
            textAlign = TextAlign.Center
        )

        Column {
            for (conditioner in listConditioner) {
                DeviceRow(
                    name = conditioner.name,
                    type = DeviceType.AIR_CONDITIONER,
                    detail = {navController.navigate("Detail")})
            }
        }
        
        Column {
            for (bulb in listBulb) {
                DeviceRow(
                    name = bulb.name,
                    type = DeviceType.BULB,
                    detail = {navController.navigate("Detail")})
            }
        }
        ButtonAdd(onClick = {openDialog = true})
    }
    if(openDialog) {
        Box ( modifier = Modifier.offset(x = 20.dp , y = 10.dp)) {
            Dialog(onDismissRequest = { openDialog = false }
            ) {
                InsertCard(
                    viewModel = viewModel,
                    dismiss = {openDialog = false})
            }
        }
    }


}