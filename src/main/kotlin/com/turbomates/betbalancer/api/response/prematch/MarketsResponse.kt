package com.turbomates.betbalancer.api.response.prematch

import com.turbomates.betbalancer.model.Market
import com.turbomates.betbalancer.model.Timestamp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("BetbalancerBetData")
data class MarketsResponse(
    @SerialName("Timestamp")
    val timestamp: Timestamp,
    val sports: Sports
) {
    @Serializable
    data class Sports(val list: List<Sport>) {
        @Serializable
        data class Sport(
            @SerialName("BetbalancerSportID")
            val id: Int,
            val markets: Markets
        )
    }

    @Serializable
    @SerialName("MatchOdds")
    data class Markets(val list: List<Market>)
}
