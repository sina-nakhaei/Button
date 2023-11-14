package com.sinanakhaei.button.ui.theme.loadingbutton

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class LoadingButtonState(
    initial: LoadingButtonStatus
) {
    private var _status by mutableStateOf(initial)
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
fun rememberLoadingButtonState(initialState: LoadingButtonStatus): LoadingButtonState {
    return remember {
        LoadingButtonState(initialState)
    }
}