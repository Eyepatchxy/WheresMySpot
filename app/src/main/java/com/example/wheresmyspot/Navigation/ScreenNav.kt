package com.example.wheresmyspot.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wheresmyspot.Screens.InitialScreen


@Composable
fun ScreenNav(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Initial",
    )
    {
        composable("Initial")
        {
            InitialScreen(navController)
        }

        composable("Signin")
        {
            //SigninScreen(navController)
        }

        composable("Signup")
        {
           // SignupScreen(navController)
        }
    }
}