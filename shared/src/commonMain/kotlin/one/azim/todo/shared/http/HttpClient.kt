package one.azim.todo.shared.http

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.json

val client = HttpClient(CIO) {
    install(Logging)
    install(ContentNegotiation){
        json()
    }
}

