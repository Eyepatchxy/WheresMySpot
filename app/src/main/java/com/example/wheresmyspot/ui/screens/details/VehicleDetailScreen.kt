package com.example.wheresmyspot.ui.screens.details

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.wheresmyspot.R
import com.example.wheresmyspot.data.demodata.PROFILE_DATA
import com.example.wheresmyspot.data.demodata.VEHICLE_DATA
import com.example.wheresmyspot.data.constants.VehicleType
import com.example.wheresmyspot.navigation.Screen
import com.example.wheresmyspot.ui.components.Background
import com.example.wheresmyspot.ui.components.PageTitle
import com.example.wheresmyspot.ui.theme.FullRed
import com.example.wheresmyspot.ui.components.InfoRow
import com.example.wheresmyspot.ui.components.InfoDivider


@Composable
fun VehicleDetailScreen(
    vehicleId: Long?,
    navController: NavController
) {
    val isDarkTheme = isSystemInDarkTheme()
    val vehicle = VEHICLE_DATA.firstOrNull{ vehicle ->
        vehicle.vehicleId == vehicleId
    }
    val profile = PROFILE_DATA
    val image = when (vehicle?.type) {
        VehicleType.BIKE -> R.drawable.ic_bike
        VehicleType.CAR -> R.drawable.ic_car
        VehicleType.TRUCK -> R.drawable.ic_truck
        else -> {R.drawable.ic_car}
    }

    var isDefault by remember { mutableStateOf( profile.defaultVehicleId == vehicleId ) }

    BackHandler(
        onBack = { navController.navigate(Screen.Vehicles.route) }
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Background()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = WindowInsets.safeDrawing.asPaddingValues().calculateTopPadding(),
                    bottom = WindowInsets.safeDrawing.asPaddingValues()
                        .calculateBottomPadding(),
                    start = WindowInsets.safeDrawing.asPaddingValues()
                        .calculateStartPadding(LayoutDirection.Ltr),
                    end = WindowInsets.safeDrawing.asPaddingValues()
                        .calculateEndPadding(LayoutDirection.Ltr)
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            PageTitle(
                title = "Vehicle Details",
                backnav = true,
                notification = true,
                navController = navController
            )

            if (vehicleId == null || vehicle == null) {
                // Error state
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Vehicle not found",
                        style = MaterialTheme.typography.titleMedium,
                        color = FullRed
                    )
                }
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Hero image card
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            if (vehicle.vehicleImageUrl.isNullOrBlank()) {
                                Image(
                                    painter = painterResource(image),
                                    contentDescription = "Vehicle Image",
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(32.dp),
                                    colorFilter = ColorFilter.tint(
                                        if (isDarkTheme) Color.White else Color.Black
                                    )
                                )
                            } else {
                                AsyncImage(
                                    model = vehicle.vehicleImageUrl,
                                    contentDescription = "Vehicle Image",
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }
                    }

                    // Name row
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                            Text(
                                text = vehicle.nickname ?: vehicle.registrationNumber,
                                style = MaterialTheme.typography.titleLarge.copy(
                                    fontWeight = FontWeight.Bold
                                ),
                                color = if (isDarkTheme) Color.White else Color.Black
                            )
                            if (vehicle.nickname != null) {
                                Text(
                                    text = vehicle.registrationNumber,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                                )
                            }
                        }

                        if (isDefault) {
                            Surface(
                                shape = RoundedCornerShape(50),
                                color = MaterialTheme.colorScheme.primaryContainer
                            ) {
                                Row(
                                    modifier = Modifier.padding(
                                        horizontal = 10.dp,
                                        vertical = 4.dp
                                    ),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.Star,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(14.dp)
                                    )
                                    Text(
                                        text = "Default",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.primary,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                        } else {
                            Button(
                                onClick = {
                                    PROFILE_DATA.defaultVehicleId = vehicleId
                                    isDefault = true
                                },
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(160.dp),
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                                ),
                                elevation = ButtonDefaults.buttonElevation(8.dp, 2.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.StarOutline,
                                    contentDescription = null,
                                    modifier = Modifier.size(18.dp),
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Set Default",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }

                    // Info card
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(0.dp)
                        ) {
                            InfoRow(label = "Brand", value = vehicle.brand)
                            InfoDivider()
                            InfoRow(label = "Model", value = vehicle.model)
                            InfoDivider()
                            InfoRow(label = "Color", value = vehicle.color)
                            InfoDivider()
                            InfoRow(
                                label = "Type",
                                value = vehicle.type.name
                                    .lowercase()
                                    .replaceFirstChar { it.uppercase() }
                            )
                        }
                    }
                }
            }
        }
    }

}


@Preview
@Composable
fun VehicleDetailScreenPreview() {
    MaterialTheme {
        VehicleDetailScreen(
            vehicleId = 1L,
            navController = rememberNavController()
        )
    }
}