package com.turbomates.betbalancer.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.xml.xml

val client: HttpClient = HttpClient(CIO) {
    install(ContentNegotiation) {
        xml(format = com.turbomates.betbalancer.infrastructure.xml)
    }
}
