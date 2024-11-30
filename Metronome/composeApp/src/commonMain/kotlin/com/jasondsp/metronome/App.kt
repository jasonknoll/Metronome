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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview


enum class Screens(val string: String) {
    RANDOM_NOTE("RN"),
    METRONOME("M")
}

/**
 * Main compose application UI.
 */
@Composable
fun App() {
    MaterialTheme {
        // Set default screen to random note generator
        var screen by remember { mutableStateOf(Screens.RANDOM_NOTE) }

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.08f)) {
                // TODO change/add colors for buttons
                // TODO add button selected state
                Button(
                    onClick = { screen = Screens.METRONOME },
                    modifier = Modifier.fillMaxWidth(0.5f).fillMaxHeight(),
                    shape = RectangleShape
                ) {
                    Text("Metronome")
                }
                Button(
                    onClick = { screen = Screens.RANDOM_NOTE },
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                    shape = RectangleShape
                ) {
                    Text("Random Note Generator", fontSize = 12.sp)
                }
            }

            // TODO find a better, more androidy way of setting view state
            if (screen == Screens.RANDOM_NOTE) {
                RandomNote()
            }
            else if (screen == Screens.METRONOME) {
                Metronome()
            }
        }
    }
}

/**
 * UI for random note generator page.
 */
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

/**
 * UI for metronome view.
 */
@Composable
fun Metronome() {
    var tempo by remember { mutableStateOf(60) }

    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("$tempo")
        Row() {
            Column(Modifier.fillMaxWidth(0.5f)) {
                Button(
                    onClick = { tempo = incrementTempo(tempo) },
                    modifier = Modifier.fillMaxWidth(0.5f)) {
                    Text(" + ")
                }
            }

            Spacer(modifier = Modifier.fillMaxWidth(0.1f))

            Column() {
                Button(
                    onClick = { tempo = decrementTempo(tempo) },
                    modifier = Modifier.fillMaxWidth(0.5f)) {
                    Text(" - ")
                }
            }
        }
    }
}


// TODO customize theme
// TODO add Tempo/BPM functionality
// TODO add random note generator activity
// TODO add metronome UI
// TODO add metronome functionality
// TODO add fretboard visualizer (for diff tunings)