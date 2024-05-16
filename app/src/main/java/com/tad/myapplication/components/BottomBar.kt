package com.tad.myapplication.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tad.myapplication.GlobalDataContainer
import com.tad.myapplication.R

@Composable
fun  BottomBar(
    modelView: GlobalDataContainer,
    navController: NavController) {
    Row(modifier = Modifier.fillMaxWidth().offset(y = 52.dp, x = 0.dp)) {

        Button (onClick = { navController.navigate("Dashboard")} ,
            shape = RectangleShape) {
            Column() {
                Image(painter = painterResource(id = R.drawable.home),
                    contentDescription = "air conditioner",
                    modifier = Modifier.padding(horizontal = 30.dp).size(width = 90.dp, height = 40.dp))
                Text(text = "Dashboard", modifier = Modifier.padding(start = 40.dp))
            }
        }
        Button (onClick = { navController.navigate("Device")},
            shape = RectangleShape) {
            Column() {
                Image(painter = painterResource(id = R.drawable.arrows),
                    contentDescription = "air conditioner",
                    modifier = Modifier.padding(horizontal = 30.dp).size(width = 90.dp, height = 40.dp))
                Text(text = "Devices", modifier = Modifier.padding(start = 40.dp))
            }
        }

    }
}