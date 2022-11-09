package com.turbomates.betbalancer.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Competitor(
    @SerialName("CompetitorId")
    val id: Int,
    val translatedNames: Names
)
