package com.turbomates.betbalancer.api.prematch.request

data class OutcomesRequest(val outcomeIds: List<Int>, val languages: List<String>? = null)
