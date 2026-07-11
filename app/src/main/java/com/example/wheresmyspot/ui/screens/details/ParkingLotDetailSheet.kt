package com.example.wheresmyspot.ui.screens.details

import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.exponentialDecay
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.wheresmyspot.data.constants.LotDetailsSheetState
import com.example.wheresmyspot.data.dataclasses.ParkingLotDetails
import com.example.wheresmyspot.data.demodata.PARKING_LOT_DATA
import com.example.wheresmyspot.ui.components.ExpandedView
import com.example.wheresmyspot.ui.components.PeekView
import kotlin.math.roundToInt

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ParkingLotDetailSheet(
    parkingLot: ParkingLotDetails,
    sheetState: AnchoredDraggableState<LotDetailsSheetState>,
    isExpanded: Boolean,
    onHide: () -> Unit,
    onBookClick: () -> Unit,
    bottomPadding: Dp = 0.dp,
    modifier: Modifier = Modifier
) {
    BackHandler(true) {
        onHide()
    }

    BoxWithConstraints {
        val screenHeight = constraints.maxHeight.toFloat()
        val peekHeightPx = screenHeight * 0.6f

        val anchors = remember(screenHeight) {
            DraggableAnchors {
                LotDetailsSheetState.EXPANDED at 0f
                LotDetailsSheetState.PEEK at (screenHeight - peekHeightPx)
                LotDetailsSheetState.HIDDEN at screenHeight
            }
        }

        sheetState.updateAnchors(anchors)

        Column(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .offset {
                    IntOffset(
                        0,
                        sheetState.requireOffset().roundToInt()
                    )
                }
                .anchoredDraggable(
                    state = sheetState,
                    orientation = Orientation.Vertical
                )
                .clip(RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp))
                .background(MaterialTheme.colorScheme.background)
        ) {
            if (isExpanded) {
                ExpandedView(
                    parkingLot = parkingLot,
                    onBookClick = onBookClick,
                    bottomPadding
                )
            } else {
                PeekView(
                    parkingLot = parkingLot,
                    onBookClick = onBookClick,
                    bottomPadding
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun ParkingLotDetailsSheetPreview() {
    val spot = PARKING_LOT_DATA[0]
    val density = LocalDensity.current
    val sheetState = remember {
        AnchoredDraggableState(
            initialValue = LotDetailsSheetState.PEEK,
            positionalThreshold = { distance -> distance * 0.5f },
            velocityThreshold = {
                with(density) { 125.dp.toPx() }
            },
            snapAnimationSpec = spring(),
            decayAnimationSpec = exponentialDecay(),
            confirmValueChange = { true }
        )
    }

    ParkingLotDetailSheet(
        spot,
        sheetState,
        false,
        {},
        {}
    )
}