package com.turbomates.betbalancer.api.request.prematch

data class OutcomesRequest(val outcomeIds: List<Int>, val languages: List<String>? = null)
