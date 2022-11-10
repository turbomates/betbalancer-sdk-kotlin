package com.turbomates.betbalancer.model.liveodds.bookmakerstatus

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement

@Serializable
@SerialName("BookmakerStatus")
data class MatchUnregister(
    @SerialName("bookmakerid")
    override val bookmakerId: Int,
    val matches: List<Match>
) : BookmakerStatus {
    @XmlElement(false)
    override val type = BookmakerStatus.Type.UNREGISTER

    @Serializable
    data class Match(
        @SerialName("matchid")
        val id: Long,
        val odds: List<Odds>? = null
    )

    @Serializable
    data class Odds(
        @SerialName("typeid")
        val typeId: Int,
        @SerialName("subtype")
        val subTypeId: Int? = null
    )
}
