package com.turbomates.betbalancer.api.prematch.response

import com.turbomates.betbalancer.model.Sport
import com.turbomates.betbalancer.model.Timestamp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("BetbalancerBetData")
data class SportsResponse(
    @SerialName("Timestamp")
    val timestamp: Timestamp,
    val sports: Sports
) {
    @Serializable
    data class Sports(val list: List<Sport>)
}
