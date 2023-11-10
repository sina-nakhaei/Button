package com.sinanakhaei.button.ui.theme.loadingbutton

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class LoadingButtonColors constructor(
    val color: Color,
    val contentColor: Color,
    val disabledColor: Color,
    val disabledContentColor: Color,
    val progressColor: Color,
)