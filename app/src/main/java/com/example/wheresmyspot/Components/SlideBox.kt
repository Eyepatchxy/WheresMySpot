package com.example.wheresmyspot.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun SlideBox(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
){
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape( topStart = 40.dp, topEnd = 40.dp),
        color = Color(0xFFF8F9FA),
        shadowElevation = 12.dp,
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .padding(top = 16.dp, bottom = 40.dp)
        ) {
            Surface(
                modifier = Modifier
                    .width(40.dp)
                    .height(4.dp)
                    .align(Alignment.CenterHorizontally),
                color = Color.LightGray.copy(alpha = 0.4f),
                shape = RoundedCornerShape(2.dp)
            ) {}

            Spacer(modifier = Modifier.height(24.dp))

            content()
        }
    }
}