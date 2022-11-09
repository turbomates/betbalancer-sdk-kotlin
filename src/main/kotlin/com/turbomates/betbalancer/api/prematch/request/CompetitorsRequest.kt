package com.turbomates.betbalancer.api.prematch.request

data class CompetitorsRequest(val competitorIds: List<Int>, val languages: List<String>? = null)
