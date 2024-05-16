package com.tad.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tad.myapplication.Screen.Controller
import com.tad.myapplication.Screen.Dashboard
import com.tad.myapplication.Screen.Devices
import com.tad.myapplication.components.BottomBar
import com.tad.myapplication.database.AppDatabase
import com.tad.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()) {
                    var context = LocalContext.current
                    var navController = rememberNavController()
                    var db = AppDatabase.getInstance(context)
                    var modelView = GlobalDataContainer(db)
                    NavHost(
                        navController = navController,
                        startDestination = "Dashboard") {
                        composable(route = "Dashboard") {
                            Dashboard(modelView, navController)
                        }
                        composable(route = "Device") {
                            Devices(modelView, navController)
                        }
                        composable(route = "Detail") {
                            Controller(modelView, navController)
                        }
                    }

                    Box (modifier = Modifier.offset(x = 0.dp, y = 632.dp)) {
                        BottomBar(modelView = modelView, navController = navController)
                    }

                }
            }
        }

    }
}