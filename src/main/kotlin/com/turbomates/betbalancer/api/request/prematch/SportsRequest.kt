package com.turbomates.betbalancer.api.request.prematch

/**
 * Languages: https://en.wikipedia.org/wiki/ISO_639-1
 */
data class SportsRequest(val languages: List<String>? = null, val sportId: Int? = null)
