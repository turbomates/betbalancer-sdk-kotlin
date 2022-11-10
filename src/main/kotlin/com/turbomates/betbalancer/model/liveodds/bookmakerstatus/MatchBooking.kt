package com.turbomates.betbalancer.model.liveodds.bookmakerstatus

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement

@Serializable
@SerialName("BookmakerStatus")
data class MatchBooking(
    @SerialName("bookmakerid")
    override val bookmakerId: Int,
    val matches: List<Match>
) : BookmakerStatus {
    @XmlElement(false)
    override val type = BookmakerStatus.Type.BOOK_MATCH

    @Serializable
    data class Match(@SerialName("matchid") val id: Long)
}
