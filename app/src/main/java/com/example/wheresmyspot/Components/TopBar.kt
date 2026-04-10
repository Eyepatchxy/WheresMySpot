package com.example.wheresmyspot.Components

import android.R.attr.content
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.compose.material3.Icons
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.test.espresso.base.Default


@Composable
fun TopBar(navController: NavController){

    var expanded by remember { mutableStateOf(false) }


    IconButton(onClick = {expanded = true})
    {
        Icon(

            imageVector = Icons.Default.Menu,
            contentDescription = "Menu",
            tint = MaterialTheme.colorScheme.onBackground

        )
    }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = {expanded = false},
        containerColor = Color.Transparent,
        shadowElevation = 0.dp

    )
    {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color().copy(alpha = 0.55f)
            ),

            shape = RoundedCornerShape(16.dp)

        )
            {
                    DropdownMenuItem(
                        text = {Text("Info", color = Color.White)},
                        onClick = {
                            expanded = false
                            navController.navigate("")
                        }
                    )

                    DropdownMenuItem(
                        text = {Text("About Us", color = Color.White)},
                        onClick = {
                            expanded = false
                            navController.navigate("")
                        }
                    )

                    DropdownMenuItem(
                        text = {Text("Help", color = Color.White)},
                        onClick = {
                            expanded = false
                            navController.navigate("")
                        }
                    )

                    DropdownMenuItem(
                        text = {Text("pata nahi ye kya karta hai", color = Color.White)},
                        onClick = {
                            expanded = false
                            navController.navigate("")
                        }
                    )
            }
    }
}