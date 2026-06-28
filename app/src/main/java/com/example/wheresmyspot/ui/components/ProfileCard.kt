package com.example.wheresmyspot.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.wheresmyspot.R
import com.example.wheresmyspot.data.Repository.PROFILE_DATA
import com.example.wheresmyspot.data.Repository.VEHICLE_DATA
import com.example.wheresmyspot.data.dataclasses.ProfileInfo
import com.example.wheresmyspot.navigation.Screen
import com.example.wheresmyspot.ui.theme.HyperLink

@Composable
fun ProfileCard(
    navController: NavController,
    profile: ProfileInfo,
) {
    val defaultVehicle = VEHICLE_DATA[0]

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Profile picture
                Box(
                    modifier = Modifier
                        .size(116.dp)
                        .clip(RoundedCornerShape(48.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant),
                    contentAlignment = Alignment.Center
                ) {
                    if (profile.profilePictureUrl.isNullOrBlank()) {
                        Icon(
                            painter = painterResource(R.drawable.ic_profile),
                            contentDescription = "Default Profile Picture",
                            modifier = Modifier.size(88.dp),
                        )
                    } else {
                        AsyncImage(
                            model = profile.profilePictureUrl,
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(88.dp)
                                .clip(CircleShape),
                        )
                    }
                }

                // Info
                Column(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = profile.fullName,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = profile.uid,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.55f)
                    )
                    Text(
                        text = defaultVehicle.nickname ?: defaultVehicle.registrationNumber,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.55f)
                    )
                    if (profile.drivingLicenceUrl.isNullOrBlank()) {
                        Text(
                            text = "Add Driving Licence →",
                            style = MaterialTheme.typography.bodySmall,
                            color = HyperLink,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            // Edit button pinned to top-end corner
            IconButton(
                onClick = { navController.navigate(Screen.EditProfile) },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .size(32.dp)
                    .clip(RoundedCornerShape(10.dp))
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit Profile",
                    modifier = Modifier.size(16.dp),
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Preview
@Composable
fun ProfileCardPreview() {
    val navController = rememberNavController()
    val profile = PROFILE_DATA

    ProfileCard(navController, profile)
}