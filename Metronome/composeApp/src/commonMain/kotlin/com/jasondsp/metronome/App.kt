package com.jasondsp.metronome

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.toPath
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.sp
import androidx.graphics.shapes.RoundedPolygon
import org.jetbrains.compose.ui.tooling.preview.Preview


// TODO define constants

enum class Screens() {
    RANDOM_NOTE,
    METRONOME,
    FRETBOARD
}

// TODO implement navigation component

/**
 * Main compose application UI.
 */
@Composable
fun App() {
    MaterialTheme {
        // Set default screen to random note generator
        var screen by remember { mutableStateOf(Screens.METRONOME) }

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.08f)) {
                // TODO change/add colors for buttons
                // TODO add button selected state
                Button(
                    onClick = { screen = Screens.METRONOME },
                    modifier = Modifier.fillMaxWidth(0.33f).fillMaxHeight(),
                    shape = RectangleShape
                ) {
                    Text("Metronome")
                }

                Button(
                    onClick = { screen = Screens.RANDOM_NOTE },
                    modifier = Modifier.fillMaxWidth(0.5f).fillMaxHeight(),
                    shape = RectangleShape
                ) {
                    Text("Random Note", fontSize = 12.sp)
                }

                Button(
                    onClick = { screen = Screens.FRETBOARD },
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                    shape = RectangleShape
                ) {
                    Text("Fretboard")
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
        var note by remember { mutableStateOf("C") };
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { note = getRandomNote().note }) {
                Text("Click to get random note!")
            }
            Text(note, fontSize = 72.sp)
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
        Text("$tempo", fontSize = 72.sp)
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

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(
                onClick = {},
            ) {
                Text("1/4")
            }

            Button(
                onClick = {},
            ) {
                Text("1/8")
            }

            Button(
                onClick = {},
            ) {
                Text("1/16")
            }
        }

        // TODO draw my shapes representing the beats
        Canvas(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .drawWithCache {
                        val roundedPolygon = RoundedPolygon(
                            numVertices = 6,
                            radius = size.minDimension / 2,
                            centerX = size.width / 2,
                            centerY = size.height / 2
                        )
                        val roundedPolygonPath = roundedPolygon.toPath().asComposePath()
                        onDrawBehind {
                            drawPath(roundedPolygonPath, color = Color.Blue)
                        }
                    }
                    .fillMaxSize()
            ) {

            }
        }
    }
}

// TODO BREAK DOWN INTO SMALLER COMPONENTS TO REUSE ON MULTIPLE SCREENS
//  TODO BPM counter view

// TODO! customize theme
// TODO add Tempo/BPM functionality
// TODO add random note generator key/scale selection
// TODO add metronome functionality
// TODO add metronome beat visualizer
// TODO add fretboard visualizer (for diff tunings)