package com.tad.myapplication.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tad.myapplication.database.Entities.AirConditioner
import com.tad.myapplication.components.BottomBar
import com.tad.myapplication.R
import com.tad.myapplication.GlobalDataContainer

val airConditioner = AirConditioner(
    id = 1,
    name = "MY_CONDITIONER",
    state = false,
    temperature = 25,
    location = "First room")

@Composable
fun Controller(viewModel : GlobalDataContainer,
               navController: NavController
) {
    var state by remember { mutableStateOf(airConditioner.state) }
    var temperature by remember  { mutableIntStateOf(airConditioner.temperature.toInt()) }
    Column ( modifier = Modifier
        .padding(top = 20.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.air_conditioner),
            contentDescription = "air conditioner",
            modifier = Modifier.padding(horizontal = 30.dp))
    }
    Column(
        modifier = Modifier
            .padding(top = 260.dp)
            .padding(horizontal = 40.dp)
    ) {
        Text(text = "Device : ${airConditioner.name}",
            fontSize = 20.sp,
            fontWeight = FontWeight.W700,
            modifier = Modifier.padding(start = 10.dp),
            textAlign = TextAlign.Center)
        if(state) {
            Text(text = "State: Running",
                fontSize = 20.sp,
                fontWeight = FontWeight.W700,
                modifier = Modifier.padding(start = 10.dp)
            )
        } else {
            Text(text = "State: Not working",
                fontSize = 20.sp,
                fontWeight = FontWeight.W700,
                modifier = Modifier.padding(start = 10.dp)
            )
        }

        Text(text = "Temperature: $temperature °C" ,
            fontSize = 20.sp,
            fontWeight = FontWeight.W700,
            modifier = Modifier.padding(start = 10.dp)
        )

        Text(text = "Location: ${airConditioner.location}" ,
            fontSize = 20.sp,
            fontWeight = FontWeight.W700,
            modifier = Modifier.padding(start = 10.dp)
        )

        Row (modifier = Modifier.padding(top = 20.dp)) {
            Button(
                onClick = { state = !state },
                modifier = Modifier.padding(end = 80.dp)) {
                if(state) Text("Turn Off")
                else Text("Turn On")
            }

            Button(
                onClick = { state = !state },
            ) {
                Text("Delete Device", color = Color.Magenta)
            }
        }

        Row (modifier = Modifier.padding(top = 60.dp)) {
            Button(
                onClick = { temperature += 1 },
                modifier = Modifier.padding(end = 40.dp),
                shape = RectangleShape) {
                Image(painter = painterResource(id = R.drawable.up),
                    contentDescription = "increase temperature",
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .size(
                            width = 30.dp,
                            height = 30.dp))
            }

            Button(
                onClick = { temperature -= 1 },
                shape = RectangleShape) {
                Image(painter = painterResource(id = R.drawable.down),
                    contentDescription = "increase temperature",
                    modifier = Modifier
                        .padding(horizontal = 30.dp)
                        .size(
                            width = 30.dp,
                            height = 30.dp))
            }
        }

        Button(
            onClick = { navController.navigate("Device")},
            modifier = Modifier.padding(top = 60.dp)) {
            Text("Back")
        }
    }

}

