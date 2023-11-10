package com.sinanakhaei.button.ui.theme.loadingbutton

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LoadingButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    state: LoadingButtonState = rememberLoadingButtonState(initial = LoadingButtonStatus.Default),
    colors: LoadingButtonColors = LoadingButtonDefaults.colors(),
    sizes: LoadingButtonSizes = LoadingButtonDefaults.sizes(),
    elevation: LoadingButtonElevation = LoadingButtonDefaults.elevation(),
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit
) {
    var widthTargetValue by remember { mutableStateOf(sizes.width) }
    val width by animateDpAsState(targetValue = widthTargetValue, label = "")
    var isLoading by remember { mutableStateOf(state.isLoading) }

    LaunchedEffect(isLoading) {
        widthTargetValue = if (state.isLoading) sizes.height
        else sizes.width
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Button(
            modifier = Modifier
                .width(width)
                .height(sizes.height),
            onClick = {
                onClick()
                isLoading = state.isLoading
            },
            colors = colors.toButtonColors(state.isLoading),
            elevation = elevation.toButtonElevation(),
            enabled = enabled && !state.isLoading,
            shape = RoundedCornerShape(sizes.height * .5f),
            contentPadding = PaddingValues(0.dp)
        ) {
            if (state.isLoading) {
                CircularProgress(
                    sizes.height,
                    sizes.progressWidth,
                    colors.progressColor
                )
            } else {
                content()
            }
        }
    }
}

@Composable
private fun CircularProgress(
    size: Dp,
    width: Dp,
    color: Color
) {
    CircularProgressIndicator(
        modifier = Modifier
            .padding(8.dp)
            .size(size),
        color = color,
        strokeWidth = width
    )
}

@Composable
private fun LoadingButtonColors.toButtonColors(isLoading: Boolean) =
    ButtonDefaults.buttonColors(
        containerColor = color,
        contentColor = contentColor,
        disabledContainerColor = if (isLoading) color else disabledColor,
        disabledContentColor = disabledContentColor,
    )


@Composable
private fun LoadingButtonElevation.toButtonElevation() =
    ButtonDefaults.buttonElevation(
        defaultElevation = defaultElevation,
        pressedElevation = pressedElevation,
        disabledElevation = disabledElevation
    )