package com.jasondsp.metronome

enum class Notes(val note: String) {
    A("A"),
    A_SHARP("A#"),
    B("B"),
    C("C"),
    C_SHARP("C#"),
    D("D"),
    D_SHARP("D#"),
    E("E"),
    F("F"),
    F_SHARP("F#"),
    G("G"),
    G_SHARP("G#")
}

// TODO implement keys algorithmically

fun getRandomNote(): Notes {
    return Notes.entries.random();
}

