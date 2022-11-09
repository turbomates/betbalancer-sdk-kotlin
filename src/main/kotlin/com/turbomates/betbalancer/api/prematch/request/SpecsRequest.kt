package com.turbomates.betbalancer.api.prematch.request

data class SpecsRequest(
    val languages: List<String>? = null,
    val sportId: Int? = null,
    val marketId: Int? = null,
    val specId: Int? = null,
)
