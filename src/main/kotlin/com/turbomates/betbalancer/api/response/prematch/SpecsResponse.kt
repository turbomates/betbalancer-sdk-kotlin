package com.turbomates.betbalancer.api.response.prematch

import com.turbomates.betbalancer.model.Names
import com.turbomates.betbalancer.model.Timestamp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("BetbalancerBetData")
data class SpecsResponse(
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

    @Serializable
    @SerialName("Bet")
    data class Market(
        @SerialName("OddsType")
        val id: Int,
        val odds: List<Odd>
    )

    @Serializable
    @SerialName("Odds")
    data class Odd(
        @SerialName("OutComeId")
        val outcomeId: Int,
        @SerialName("OutCome")
        val outcome: String,
        @SerialName("SpecialBetValue")
        val specialBetValue: String,
        val translatedNames: Names
    )
}
