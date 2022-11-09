package com.turbomates.betbalancer.api.prematch.response

import com.turbomates.betbalancer.model.Player
import com.turbomates.betbalancer.model.Timestamp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("BetbalancerBetData")
data class PlayersResponse(
    @SerialName("Timestamp")
    val timestamp: Timestamp,
    val players: Players
) {

    @Serializable
    data class Players(val list: List<Player>)
}
