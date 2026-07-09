package com.example.wheresmyspot.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wheresmyspot.ui.theme.RatingGold

@Composable
fun RatingDisplay(
    rating: Float,
    reviewCount: Int,
    modifier: Modifier = Modifier
) {
    require(rating in 0f .. 5f) {
        "Rating must be between 0 to 5"
    }

    val colored = rating.toInt()
    val partialFill = rating - colored
    val hasPartialStar = partialFill > 0f
    val remaining = 5 - colored - if (hasPartialStar) 1 else 0


    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.End
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            for (i in 0 until colored) {
                Icon(
                    imageVector = Icons.Default.StarRate,
                    contentDescription = "Colored Star $i",
                    tint = RatingGold
                )
            }

            if (hasPartialStar) {
                Box {
                    Icon(
                        imageVector = Icons.Default.StarOutline,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
                    )
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(
                                GenericShape { size, _ ->
                                    addRect(
                                        Rect(
                                            left = 0f,
                                            top = 0f,
                                            right = size.width * partialFill,
                                            bottom = size.height
                                        )
                                    )
                                }
                            )
                    ) {
                        Icon(
                            imageVector = Icons.Default.StarRate,
                            tint = RatingGold,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }

            for (i in 0 until remaining) {
                Icon(
                    imageVector = Icons.Default.StarOutline,
                    contentDescription = "Uncolored Star $i"
                )
            }
        }

        Text(
            text = reviewCount.toString(),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun RatingDisplayPreview() {

    RatingDisplay(4.4f, 13)
}