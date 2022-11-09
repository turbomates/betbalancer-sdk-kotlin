package com.turbomates.betbalancer.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Outright(
    @SerialName("outrightId")
    val id: Int,
    val translatedNames: Names
)
