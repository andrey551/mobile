package com.tad.myapplication.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

var value_fontsize = 50.sp

@Composable
fun Card (value : Long,
          unit: String,
          name: String,
          color : Color){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .size(width = 200.dp, height = 250.dp)
            .padding(
                horizontal = 5.dp,
                vertical = 60.dp
            )
    ) {
        Column(
        ) {
            Row (
                modifier = Modifier.padding(vertical = 15.dp,
                                            horizontal = 35.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    "$value",
                    fontSize = value_fontsize,
                    color = color,
                    textAlign = TextAlign.Right,
                    fontFamily = FontFamily.SansSerif
                )
                Text(
                    "$unit",
                    fontSize = value_fontsize,
                    color = color,
                    textAlign = TextAlign.Right,
                    fontFamily = FontFamily.SansSerif
                )
            }
            Text(
                "$name",
                fontSize = 15.sp,
                color = color,
                textAlign = TextAlign.Right,
                modifier = Modifier.padding(horizontal = 30.dp)
                )
        }
    }
}