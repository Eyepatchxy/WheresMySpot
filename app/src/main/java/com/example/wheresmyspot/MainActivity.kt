package com.example.wheresmyspot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.wheresmyspot.navigation.NavGraph
import com.example.wheresmyspot.ui.theme.WheresMySpotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WheresMySpotTheme {

                val navController = rememberNavController()

                NavGraph(navController = navController)
            }
        }
    }
}
