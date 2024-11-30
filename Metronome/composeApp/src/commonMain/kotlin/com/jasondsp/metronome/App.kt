package com.jasondsp.metronome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import metronome.composeapp.generated.resources.Res
import metronome.composeapp.generated.resources.compose_multiplatform

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
            Button(onClick = { screen = Screens.METRONOME}) {
                Text("Metronome")
            }
            Button(onClick = { screen = Screens.RANDOM_NOTE}) {
                Text("Random Note Generator")
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