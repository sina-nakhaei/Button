package com.sinanakhaei.button

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.sinanakhaei.button.ui.theme.ButtonTheme
import com.sinanakhaei.button.ui.theme.loadingbutton.LoadingButton
import com.sinanakhaei.button.ui.theme.loadingbutton.LoadingButtonStatus
import com.sinanakhaei.button.ui.theme.loadingbutton.rememberLoadingButtonState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ButtonTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF030061)),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val state =
                        rememberLoadingButtonState(initialState = LoadingButtonStatus.Default)
                    val scope = rememberCoroutineScope()
                    LoadingButton(
                        state = state,
                        enabled = true,
                        onClick = {
                            if (state.isLoading) state.stopLoading()
                            else state.startLoading()

                            scope.launch {
                                delay(3000)
                                state.stopLoading()
                            }

                        }
                    ) {
                        Text(text = "Login", fontSize = 28.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ButtonTheme {
        Greeting("Android")
    }
}