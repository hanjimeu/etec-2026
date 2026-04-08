package com.example.logcatbutton

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.logcatbutton.ui.theme.LogcatbuttonTheme

const val TAG = "TesteAndroid"

/* CORES */
val BegeFundo = Color(0xFFF5E6D3)
val VermelhoEscuro = Color(0xFFC62828)
val VermelhoClaro = Color(0xFFE53935)
val Branco = Color(0xFFFFFFFF)
val PretoSuave = Color(0xFF212121)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LogcatbuttonTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    val context = LocalContext.current
    val prefs = context.getSharedPreferences("dados", Context.MODE_PRIVATE)

    var nome by remember {
        mutableStateOf(prefs.getString("nome", "") ?: "")
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BegeFundo
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(R.drawable.pochacco),
                contentDescription = "Pochacco",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(180.dp)
                    .height(160.dp)
            )

            Text(
                text = "Sistema de Notas",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = PretoSuave
            )

            Text(
                text = "por Mariana dos Santos",
                style = MaterialTheme.typography.bodyMedium,
                color = VermelhoEscuro
            )

            TextField(
                value = nome,
                onValueChange = { novoNome ->
                    nome = novoNome
                    prefs.edit().putString("nome", nome).apply()
                },
                label = { Text("Digite seu nome") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Branco,
                    unfocusedContainerColor = Branco,
                    focusedIndicatorColor = VermelhoEscuro,
                    cursorColor = VermelhoEscuro
                ),
                modifier = Modifier.fillMaxWidth(0.85f)
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                ActionButton("Insuficiente") {
                    Log.e(TAG, "$nome tirou I")
                }

                ActionButton("Regular") {
                    Log.w(TAG, "$nome tirou R")
                }

                ActionButton("Bom") {
                    Log.d(TAG, "$nome tirou B")
                }

                ActionButton("Muito Bom") {
                    Log.i(TAG, "$nome tirou MB")
                }
            }
        }
    }
}

@Composable
fun ActionButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val gradient = Brush.horizontalGradient(
        colors = listOf(VermelhoEscuro, VermelhoClaro)
    )

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, PretoSuave),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        contentPadding = PaddingValues(),
        modifier = modifier
            .fillMaxWidth(0.75f)
            .height(55.dp)
    ) {
        Box(
            modifier = Modifier
                .background(gradient, RoundedCornerShape(20.dp))
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = Branco,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    LogcatbuttonTheme {
        App()
    }
}