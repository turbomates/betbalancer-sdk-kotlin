package com.turbomates.betbalancer.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Text")
data class Outcome(
    @SerialName("ID")
    val id: Int,
    val translatedNames: List<Names.Name>
)
