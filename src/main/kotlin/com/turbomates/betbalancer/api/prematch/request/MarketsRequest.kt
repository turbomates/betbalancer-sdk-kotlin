package com.turbomates.betbalancer.api.prematch.request

data class MarketsRequest(
    val languages: List<String>? = null,
    val sportId: Int? = null,
    val marketId: Int? = null,
)

