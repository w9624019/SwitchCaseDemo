package com.example.switchcasedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.switchcasedemo.ui.theme.SwitchCaseDemoTheme
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SwitchCaseDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

fun switchCase(str: String) : String {
    return str.map {
        when(it) {
        in 'a' .. 'z' -> it - 32
        in 'A' .. 'Z' -> it + 32
        else -> it
        }
    }.joinToString("")
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var userName by remember { mutableStateOf(switchCase(name))  }
    val userPrompt = LocalContext.current.getString(R.string.user_prompt)

    Column {
        Text(
            text = userPrompt,
            modifier = modifier
        )
        Text(
            text = "Hello ${userName}!",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SwitchCaseDemoTheme {
        Greeting("Middlesbrough University")
    }
}