package com.turbomates.betbalancer.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Sport")
data class Sport(
    @SerialName("BetbalancerSportID")
    val id: Int,
    val translatedNames: Names
)

