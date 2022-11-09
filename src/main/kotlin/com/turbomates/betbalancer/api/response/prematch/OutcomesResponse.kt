package com.turbomates.betbalancer.api.response.prematch

import com.turbomates.betbalancer.model.Outcome
import com.turbomates.betbalancer.model.Timestamp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("BetbalancerBetData")
data class OutcomesResponse(
    @SerialName("Timestamp")
    val timestamp: Timestamp,
    val competitors: Competitors
) {

    // @Serializable
    // data class Competitors(val list: List<Competitor>)

    @Serializable
    @SerialName("Competitors")
    data class Competitors(
        val outcomes: Outcomes
    )

    @Serializable
    @SerialName("Texts")
    data class Outcomes(
        val list: List<Outcome>
    )
}
