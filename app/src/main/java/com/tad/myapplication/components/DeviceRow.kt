package com.tad.myapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.Composable
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tad.dashboard.enums.DeviceType
import com.tad.myapplication.R

@Composable
fun DeviceRow (name: String,
               type: DeviceType,
               detail : () -> Unit) {
    Card( modifier = Modifier
        .fillMaxWidth()
        .height(70.dp)
        .padding(top = 10.dp)
        .padding(start = 10.dp)
        .padding(end = 10.dp)
    ) {
        Row {
            Box(modifier = Modifier
                .size(width = 80.dp, height = 60.dp)
                .padding(start = 15.dp)) {
                if(type == DeviceType.AIR_CONDITIONER) {
                    Image(
                        painter = painterResource(id = R.drawable.air_conditioning),
                        contentDescription = "air conditioner logo",
                        modifier = Modifier
                            .size(width = 50.dp, height = 50.dp)
                            .padding(top = 10.dp)
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.bulb),
                        contentDescription = "air conditioner logo",
                        modifier = Modifier
                            .size(width = 50.dp, height = 50.dp)
                            .padding(top = 10.dp)
                    )
                }
            }
            Text(text = "Device: $name", modifier = Modifier
                .size(width = 200.dp, height = 50.dp)
                .padding(top = 15.dp),
                fontSize = 20.sp,)
            TextButton(onClick = { detail() }) {
                Text("Detail")
            }

        }
    }
}
