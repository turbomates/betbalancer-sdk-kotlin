package com.turbomates.betbalancer.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Bet")
data class Market(
    @SerialName("OddsType")
    val id: Int,
    val translatedNames: Names
)
