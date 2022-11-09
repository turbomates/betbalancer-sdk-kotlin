package com.turbomates.betbalancer.api.request.prematch

/**
 * Get data for the specified players (max. 6 in the same request)
 */
data class PlayersRequest(val playerIds: List<Int>, val languages: List<String>? = null)
