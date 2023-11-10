package com.sinanakhaei.button.ui.theme.loadingbutton

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

class LoadingButtonState(
    initial: LoadingButtonStatus
) {
    private var _status = initial
    val status get() = _status

    val isLoading get() = (status == LoadingButtonStatus.Loading)

    fun startLoading() {
        _status = LoadingButtonStatus.Loading
    }

    fun stopLoading() {
        _status = LoadingButtonStatus.Default
    }
}


@Composable
fun rememberLoadingButtonState(initial: LoadingButtonStatus): LoadingButtonState {
    return remember {
        LoadingButtonState(initial)
    }
}