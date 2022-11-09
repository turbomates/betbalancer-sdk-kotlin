package com.turbomates.betbalancer.api.request.prematch

data class SpecsRequest(
    val languages: List<String>? = null,
    val sportId: Int? = null,
    val marketId: Int? = null,
    val specId: Int? = null,
)
