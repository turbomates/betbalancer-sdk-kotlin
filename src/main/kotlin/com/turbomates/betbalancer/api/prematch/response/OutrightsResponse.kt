package com.turbomates.betbalancer.api.prematch.response

import com.turbomates.betbalancer.model.Outright
import com.turbomates.betbalancer.model.Timestamp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("BetbalancerBetData")
data class OutrightsResponse(
    @SerialName("Timestamp")
    val timestamp: Timestamp,
    val outrights: Outrights
) {

    @Serializable
    data class Outrights(val list: List<Outright>)
}
