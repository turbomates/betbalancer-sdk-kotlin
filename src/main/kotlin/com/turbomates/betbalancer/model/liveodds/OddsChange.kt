package com.turbomates.betbalancer.model.liveodds

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("change")
data class OddsChange(val odds: Double) : LiveOdds()
