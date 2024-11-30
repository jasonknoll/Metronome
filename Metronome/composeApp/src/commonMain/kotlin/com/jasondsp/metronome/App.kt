package com.jasondsp.metronome

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview


enum class Screens(val string: String) {
    RANDOM_NOTE("RN"),
    METRONOME("M")
}


@Composable
fun App() {
    MaterialTheme {
        // Set default screen to random note generator
        var screen by remember { mutableStateOf(Screens.RANDOM_NOTE) }

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.1f)) {
                Button(
                    onClick = { screen = Screens.METRONOME },
                    modifier = Modifier.fillMaxWidth(0.5f)
                ) {
                    Text("Metronome")
                }
                Button(
                    onClick = { screen = Screens.RANDOM_NOTE },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Random Note Generator", fontSize = 12.sp)
                }
            }

            if (screen == Screens.RANDOM_NOTE) {
                RandomNote()
            }
            else if (screen == Screens.METRONOME) {
                Metronome()
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
            Text("Note: $note")
        }
    }
}

@Composable
fun Metronome() {
    var tempo by remember { mutableStateOf(60) }

    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("$tempo")
        Row() {
            Button(onClick = { tempo = incrementTempo(tempo) }) {
                Text("+")
            }
            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
            Button(onClick = { tempo = decrementTempo(tempo) }) {
                Text(" - ")
            }
        }
    }
}

// TODO add Tempo/BPM functionality
// TODO add random note generator activity
// TODO add metronome UI
// TODO add metronome functionality
// TODO add fretboard visualizer (for diff tunings)