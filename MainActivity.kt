package com.example.profilapp_235150201111074_nadhifrifatrasendriya

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.profilapp_235150201111074_nadhifrifatrasendriya.ui.theme.Profilapp_235150201111074_nadhifrifatrasendriyaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Profilapp_235150201111074_nadhifrifatrasendriyaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        CounterApp()
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
        ColorToggleButton()
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
        InteractiveProfile()
    }
}

@Composable
fun CounterApp() {
    var count by remember { mutableStateOf(0) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "1. Aplikasi Counter", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "$count",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = { count++ }) {
                Text(text = "Tambah (+)")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {
                    if (count > 0) {
                        count--
                    }
                }
            ) {
                Text(text = "Kurang (-)")
            }
        }
    }
}

@Composable
fun ColorToggleButton() {
    var boxColor by remember { mutableStateOf(Color.Red) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "2. Tombol Toggle Warna", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(boxColor)
                .clickable {
                    boxColor = if (boxColor == Color.Red) Color.Green else Color.Red
                }
        ) {
            Text(
                text = "Click me & see the magic!",
                modifier = Modifier.align(Alignment.Center),
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun InteractiveProfile() {
    var isFollowed by remember { mutableStateOf(false) }
    val buttonText = if (isFollowed) "Unfollow" else "Follow"
    val statusText = if (isFollowed) "Anda memfollow akun ini" else "Anda tidak memfollow akun ini"

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "3. Aplikasi Profil Interaktif", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))


        Image(
            painter = painterResource(id = R.drawable.fotonadhif),
            contentDescription = "Foto Profil",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Nadhif R. R.", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text(text = "Mahasiswa Teknik Informatika", color = Color.Gray)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { isFollowed = !isFollowed }) {
            Text(text = buttonText)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = statusText,
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun DefaultPreview() {
    Profilapp_235150201111074_nadhifrifatrasendriyaTheme {
        MainScreen()
    }
}
