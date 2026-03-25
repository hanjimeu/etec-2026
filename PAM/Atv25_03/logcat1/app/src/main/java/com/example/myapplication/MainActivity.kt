package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.material3.ButtonDefaults
import android.util.Log
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.material3.ButtonColors
import com.example.myapplication.ui.theme.DebugButtonColors
import com.example.myapplication.ui.theme.ErrorButtonColors
import com.example.myapplication.ui.theme.InfoButtonColors
import com.example.myapplication.ui.theme.WarningButtonColors

const val TAG = "AppLog"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                App()
                }
            }
        }
    }

@Composable
fun App() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){

        ActionButton(
            text = "Debug",
            buttonColors = DebugButtonColors(),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Log.d(TAG, "App: Clicou em DEBUG!")
        }

        ActionButton(
            text = "Info",
            buttonColors = InfoButtonColors(),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Log.i(TAG, "App: Clicou em INFO!")
        }

        ActionButton(
            text = "Warning",
            buttonColors = WarningButtonColors(),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            Log.w(TAG, "App: Clicou em WARNING!")
        }

        ActionButton(
            text = "Error",
            buttonColors = ErrorButtonColors(),
            modifier = Modifier.fillMaxWidth(0.5f)
        ) {
            try {
                throw RuntimeException("Clicou em Error!")
            } catch (ex: Exception) {
                Log.e(TAG, ex.message ?: "Erro")
            }
        }
    }
}

@Composable
fun ActionButton(
    text: String,
    modifier: Modifier = Modifier,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    onClick: () -> Unit
){
    ElevatedButton(
        onClick = onClick,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier
    ) {
        Text(text = text)
    }
}


@Preview(showBackground = true, widthDp = 150, heightDp = 200)
@Composable
fun AppPreview() {
    MyApplicationTheme {
        App()
    }
}

@Preview(showBackground = true, widthDp = 120)
@Composable
fun ActionButtonPreview() {
    ActionButton(text = "Cadastrar") {

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    MyApplicationTheme {
        App()
    }
}