package com.jasondsp.metronome

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview


enum class Screens {
    RANDOM_NOTE,
    METRONOME
}


@Composable
fun App() {
    MaterialTheme {
        // Set default screen to random note generator
        var screen by remember { mutableStateOf(Screens.RANDOM_NOTE) }

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = { screen = Screens.METRONOME },
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {

                    Text("Metronome")
                }
                Button(
                    onClick = { screen = Screens.RANDOM_NOTE},
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Random Note Generator", fontSize = 12.sp)
                }
            }

            if (screen == Screens.RANDOM_NOTE) {
                RandomNote()
            }
        }
    }
}

@Composable
@Preview
fun RandomNote() {
    MaterialTheme {
        var note by remember { mutableStateOf("") };
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { note = getRandomNote().note }) {
                Text("Click to get random note!")
            }
            Text("Note: ${note}")
        }
    }
}

// TODO add Tempo/BPM functionality
// TODO add random note generator activity
// TODO add metronome UI
// TODO add metronome functionality