package com.sinanakhaei.button.ui.theme.loadingbutton

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object LoadingButtonDefaults {
    @Composable
    fun colors(
        color: Color = Color(0xFF1ED760),
        contentColor: Color = Color(0xFF000000),
        disabledColor: Color = Color(0xFF808080),
        disabledContent: Color = Color(0xFFFFFFFF),
        progressColor: Color = Color(0xFF000000),
    ) = LoadingButtonColors(color, contentColor, disabledColor, disabledContent, progressColor)

    @Composable
    fun sizes(
        width: Dp = 180.dp,
        height: Dp = 80.dp,
        progressWidth: Dp = 4.dp
    ) = LoadingButtonSizes(width, height, progressWidth)

    @Composable
    fun elevation(
        defaultElevation: Dp = 10.dp,
        pressedElevation: Dp = 0.dp,
        disabledElevation: Dp = 0.dp
    ) = LoadingButtonElevation(
        defaultElevation = defaultElevation,
        pressedElevation = pressedElevation,
        disabledElevation = disabledElevation
    )
}