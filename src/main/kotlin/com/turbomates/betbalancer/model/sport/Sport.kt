package com.turbomates.betbalancer.model.sport

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Sport")
data class Sport(
    @SerialName("BetbalancerSportID")
    val id: Int,
    val translatedNames: Names
) {
    @Serializable
    @SerialName("Texts")
    data class Names(val list: List<Name>)
}


