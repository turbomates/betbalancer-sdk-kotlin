package com.turbomates.betbalancer.api

import com.turbomates.betbalancer.PreMatchConfig
import com.turbomates.betbalancer.api.request.prematch.SportsRequest
import com.turbomates.betbalancer.api.response.prematch.SportsResponse
import io.ktor.client.call.body
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class PreMatchAPI(val config: PreMatchConfig) {
    suspend inline fun <reified T> get(path: String, parameters: HttpRequestBuilder.() -> Unit = {}): T {
        return client.get(config.host + path) {
            parameter("bookmakerName", config.bookmakerName)
            parameter("key", config.key)
            parameters()
        }.body()
    }

    suspend fun sports(request: SportsRequest.() -> Unit = {}): SportsResponse {
        val parameters = SportsRequest().apply(request)
        return get("/export/getSports") {
            parameter("lang", parameters.languages?.joinToString())
            parameter("sportId", parameters.sportId?.toString())
        }
    }
}
