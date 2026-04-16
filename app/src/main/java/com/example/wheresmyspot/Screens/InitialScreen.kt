package com.example.wheresmyspot.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.wheresmyspot.Components.GradientBackground
import com.example.wheresmyspot.Components.PrimaryButton
import com.example.wheresmyspot.Components.TopBar

@Composable
fun InitialScreen(navController: NavController)
{
       GradientBackground {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Find the best parking spots near you instantly",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Green

                )
                PrimaryButton(
                    "Get Started",
                    onClick = { navController.navigate("signup") },
                    modifier = Modifier,
                )
            }
       }

}