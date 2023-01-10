package com.turbomates.betbalancer.api.prematch.request

data class TournamentsRequest(
    val languages: List<String>? = null,
    val sportId: Int? = null,
    val categoryId: Int? = null,
)
