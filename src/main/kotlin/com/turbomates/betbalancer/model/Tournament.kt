package com.turbomates.betbalancer.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Tournament")
data class Tournament(
    @SerialName("BetbalancerTournamentID")
    val id: Int,
    val translatedNames: Names
)
