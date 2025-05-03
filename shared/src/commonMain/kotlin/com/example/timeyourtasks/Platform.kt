package com.example.timeyourtasks

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform