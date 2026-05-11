package com.example.wheresmyspot.Screens

import android.graphics.Color.alpha
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wheresmyspot.Components.GradientBackground
import com.example.wheresmyspot.Components.PrimaryButton
import com.example.wheresmyspot.Components.SecondaryButton
import com.example.wheresmyspot.Components.SlideBox

@Composable
fun InitialScreen(navController: NavController)
{
    GradientBackground {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 32.dp, vertical = 60.dp)
            ) {
                Text(
                    text = "PREMIUM PARKING",
                    color = Color.White.copy(alpha = 0.7f),
                    letterSpacing = 2.sp,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )

                Text(
                    text = "FMPS",
                    color = Color.White,
                    fontSize = 56.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 52.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .width(60.dp)
                        .height(4.dp)
                        .background(Color(0xFF0066D6))
                )
            }

            SlideBox() {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        color = Color(0xFFDCE8FF),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.size(40.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.VerifiedUser,
                            contentDescription = null,
                            tint = Color(0xFF0066D6),
                            modifier = Modifier.padding(8.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        text = "Professional & Reliable",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0D1B2A)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Experience the gold standard in urban parking. Secure spaces, real-time tracking, and seamless payments in the heart of the city.",
                    color = Color.Gray,
                    lineHeight = 24.sp,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(32.dp))

                PrimaryButton(
                    text = "Find Parking",
                    onClick = { navController.navigate("signup")}
                )

                Spacer(modifier = Modifier.height(12.dp))

                SecondaryButton(
                    text = "Log In",
                    onClick = {navController.navigate("signin")}
                )

                Spacer(modifier = Modifier.height(24.dp))
                HorizontalDivider(color = Color.LightGray.copy(alpha = 0.4f))
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Default.Lock,null, Modifier.size(14.dp), Color(0xFF1A4D4D))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("ENCRYPTED", fontSize = 10.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(Icons.Default.Schedule, null, Modifier.size(14.dp), Color(0xFF1A4D4D))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("24/7", fontSize = 10.sp, fontWeight = FontWeight.Bold)
                }

                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = Color(0xFFDCE8FF),
                    modifier = Modifier.height(24.dp)
                ) {
                    Row(

                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    ) {
                        Text(
                            text = "4.9*",
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0D1B2A)

                        )
                    }

                }
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}