package com.turbomates.betbalancer.api.request.prematch

data class CompetitorsRequest(val competitorIds: List<Int>, val languages: List<String>? = null)
