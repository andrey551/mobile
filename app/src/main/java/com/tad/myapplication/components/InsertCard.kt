package com.tad.myapplication.components

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.material3.Card;
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tad.dashboard.enums.DeviceType
import com.tad.myapplication.GlobalDataContainer
import com.tad.myapplication.database.Entities.AirConditioner
import com.tad.myapplication.database.Entities.Bulb
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.toList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InsertCard(viewModel : GlobalDataContainer,
                dismiss : () -> Unit) {
    val context = LocalContext.current
    var typeList = arrayOf(DeviceType.AIR_CONDITIONER.value, DeviceType.BULB.value)
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(typeList[0]) }
    var name by remember { mutableStateOf("") }
    var location_sel by remember { mutableStateOf("") }
    Card (
        modifier = Modifier
            .size(width = 420.dp, height = 400.dp)
            .border(width = 2.dp, color = Color.Black, shape = CutCornerShape(10.dp))
    ){
        Column () {
            Text(
                "Add Device",
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .padding(start = 10.dp))
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .padding(start = 20.dp)) {
                OutlinedTextField(
                    value = name ,
                    onValueChange = { name = it},
                    label = {Text("Device name")})
            }
            Row (modifier = Modifier
                .padding(top = 20.dp)
                .padding(start = 20.dp)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding()
                ) {
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = {
                            expanded = !expanded
                        }
                    ) {
                        TextField(
                            value = selectedText,
                            onValueChange = {},
                            readOnly = true,
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                            modifier = Modifier.menuAnchor()
                        )

                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            typeList.forEach { item ->
                                DropdownMenuItem(
                                    text = { Text(text = item) },
                                    onClick = {
                                        selectedText = item
                                        expanded = false
                                        Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                                    }
                                )
                            }
                        }
                    }
                }
            }
            Row(modifier = Modifier
                .padding(top = 20.dp)
                .padding(start = 20.dp)) {
                OutlinedTextField(
                    value = location_sel ,
                    onValueChange = { location_sel = it},
                    label = {Text("Location")})
            }
            Row (modifier = Modifier
                .padding(top = 40.dp)
                .padding(start = 10.dp)) {
                Button(onClick = { dismiss() },
                    modifier = Modifier
                    .padding(start = 20.dp)
                    .padding(end = 90.dp)) {
                    Text("Dismiss")
                }
                Button(onClick = {
                    if (selectedText == DeviceType.AIR_CONDITIONER.value) {
                        viewModel.createAirConditioner(AirConditioner(
                            id = viewModel.listAirConditioner.last().id + 1,
                            name = name,
                            state = false,
                            temperature = 20L ,
                            location = location_sel))
                    } else {
                        viewModel.createNewBulb(
                            Bulb(
                                id = viewModel.listBulb.last().id + 1,
                                name = name,
                                state = false,
                                location = location_sel
                            )
                        )
                    }
                }) {
                    Text("Save")
                }
            }

        }

    }
}