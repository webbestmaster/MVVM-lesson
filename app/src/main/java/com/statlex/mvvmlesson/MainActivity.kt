package com.statlex.mvvmlesson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.statlex.mvvmlesson.ui.theme.MVVMLessonTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVMLessonTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color(0xFFF0F0F0))
                            .padding(innerPadding)
                    ) {
                        MainView()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var count by remember { mutableStateOf(0) }
        val mv: ContactsViewModel = viewModel()

        Text(
            text = "Counter is " + count.toString(),
            fontSize = 36.sp,
        )

        Button(onClick = { count += 1 }) {
            Text(
                text = "Count one by one",
                fontSize = 36.sp,
            )
        }

        Button(
            onClick = {
                mv.changeBgColor()
            },
            modifier = Modifier.background(mv.bgColor)
        ) {

            Text(text = "change bg")
        }

    }
}

