package com.turbomates.betbalancer.api.prematch.request

data class MatchRequest(
    val matchId: Int? = null,
    val matchIdList: List<Int>? = null,
    val sportId: Int? = null,
    val categoryId: Int? = null,
    val tournamentId: Int? = null
)
