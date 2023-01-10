package com.turbomates.betbalancer.api.prematch.response

import com.turbomates.betbalancer.model.Competitor
import com.turbomates.betbalancer.model.Timestamp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("BetbalancerBetData")
data class CompetitorsResponse(
    @SerialName("Timestamp")
    val timestamp: Timestamp,
    val competitors: Competitors
) {

    @Serializable
    data class Competitors(val list: List<Competitor>)
}

