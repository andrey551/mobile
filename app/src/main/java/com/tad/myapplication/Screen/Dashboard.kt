package com.tad.myapplication.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.tad.myapplication.components.Card
import com.tad.myapplication.components.Graph
import com.tad.myapplication.components.BottomBar
import com.tad.myapplication.GlobalDataContainer

@Composable
fun Dashboard(viewModel : GlobalDataContainer,
              navController: NavController) {
    Column ( modifier = Modifier
        .padding(top = 40.dp)
    ){
        Text(
            "CURRENT ROOM STATUS",
            fontSize = 23.sp,
            fontWeight = FontWeight.W700,
            modifier = Modifier.padding(start = 10.dp),
            textAlign = TextAlign.Center
        )
        Row (modifier = Modifier
            .padding(horizontal = 5.dp)
        ) {

            Card(
                value = 24,
                unit = "°C",
                name = "Temperature",
                color = Color.Black)
            Card(
                value = 89,
                unit = "%",
                name = "Humid percent",
                color = Color.Black)
        }
        Text(
            "About this week",
            fontSize = 23.sp,
            fontWeight = FontWeight.W700,
            modifier = Modifier.padding(start = 10.dp)
        )

        Graph()
    }

}