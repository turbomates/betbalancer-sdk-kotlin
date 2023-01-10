package com.turbomates.betbalancer.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Player(
    @SerialName("PlayerId")
    val id: Int,
    val translatedNames: Names
)
