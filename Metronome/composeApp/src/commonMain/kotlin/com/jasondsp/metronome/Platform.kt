package com.jasondsp.metronome

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform