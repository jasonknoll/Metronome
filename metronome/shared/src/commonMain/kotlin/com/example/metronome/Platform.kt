package com.example.metronome

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform