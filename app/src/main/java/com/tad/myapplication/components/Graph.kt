package com.tad.myapplication.components

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp
import com.tad.dashboard.enums.DayInWeek
import com.tad.dashboard.enums.getNameDay

val days = listOf(  Offset(x = DayInWeek.MONDAY.value, y = 750f),
                    Offset(x = DayInWeek.TUESDAY.value, y = 750f),
                    Offset(x = DayInWeek.WEDNESDAY.value, y = 750f),
                    Offset(x = DayInWeek.THURSDAY.value, y = 750f),
                    Offset(x = DayInWeek.FRIDAY.value, y = 750f),
                    Offset(x = DayInWeek.SATURDAY.value, y = 750f),
                    Offset(x = DayInWeek.SUNDAY.value, y = 750f))
val tempInWeek = listOf ( 20, 21, 15, 16, 18, 19, 23)
val humidInWeek = listOf ( 5, 15, 60, 65, 80, 43, 14)
@Composable
fun Graph () {
    Canvas(modifier = Modifier
        .fillMaxWidth()
        .height(250.dp)

        ) {


        drawLine(
            start = Offset(x = 50f, y = 0f),
            end = Offset(x = 50f, y = 750f),
            color = Color.Black,
            strokeWidth = 7f)
        drawLine (
            start = Offset(x = 50f, y = 750f),
            end = Offset(x = 1050f, y = 750f),
            color = Color.Black,
            strokeWidth = 7f
        )

        for (day in days) {
            drawLine(
                start = Offset(x = day.x, y = day.y - 10),
                end = Offset(x = day.x, y = day.y + 10),
                color = Color.Black,
                strokeWidth = 7f
            )
            drawContext
                .canvas
                .nativeCanvas
                .drawText(
                    getNameDay(day.x),
                    day.x - 30f,
                    day.y + 50,
                    Paint().apply {
                        textSize = 30f
                    }
                )
        }
        for (day in days.indices) {
            drawCircle(
                radius = 7.0f,
                center = Offset (x = days[day].x,  y = 750f - tempInWeek[day] /50f * 750f),
                color = Color.Green
            )

            drawContext
                .canvas
                .nativeCanvas
                .drawText(
                    tempInWeek[day].toString(),
                    days[day].x - 30f,
                    (750f - tempInWeek[day] /50f * 750f) + 50,
                    Paint().apply {
                        textSize = 30f
                    }
                )
            drawCircle(
                radius = 7.0f,
                center = Offset (x = days[day].x,  y = 750f - humidInWeek[day] /100f * 750f),
                color = Color.Red
            )

            drawContext
                .canvas
                .nativeCanvas
                .drawText(
                    humidInWeek[day].toString(),
                    days[day].x - 5,
                    (750f - humidInWeek[day] /100f * 750f) - 30,
                    Paint().apply {
                        textSize = 30f
                    }
                )

        }
        for (day in 0 until days.size - 1) {
            drawLine(
                start = Offset(x = days[day].x, y = 750f - tempInWeek[day] /50f * 750f),
                end = Offset(x = days[day + 1].x, y = 750f - tempInWeek[day + 1] /50f * 750f),
                color = Color.Green,
                strokeWidth = 3f
            )
            drawLine(
                start = Offset(x = days[day].x, y = 750f - humidInWeek[day] /100f * 750f),
                end = Offset(x = days[day + 1].x, y = 750f - humidInWeek[day + 1] /100f * 750f),
                color = Color.Red,
                strokeWidth = 3f
            )
        }

        drawRect(topLeft = Offset(x = 80f, y = 10f),
                size = Size(width = 50f, height = 25f),
                color = Color.Green)
        drawContext
            .canvas
            .nativeCanvas
            .drawText(
                "Temperature",
                150f,
                30f,
                Paint().apply {
                    textSize = 25f
                }
            )

        drawRect(topLeft = Offset(x = 80f, y = 50f),
            size = Size(width = 50f, height = 25f),
            color = Color.Red)
        drawContext
            .canvas
            .nativeCanvas
            .drawText(
                "Humid percent",
                150f,
                70f,
                Paint().apply {
                    textSize = 25f
                }
            )

    }
}
