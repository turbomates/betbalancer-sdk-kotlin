package com.turbomates.betbalancer.model.liveodds.bookmakerstatus

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement

@Serializable
@SerialName("BookmakerStatus")
data class ScoreAndCardsSummary(
    @SerialName("bookmakerid")
    override val bookmakerId: Int,
    val matches: List<Match>
) : BookmakerStatus {
    @XmlElement(false)
    override val type = BookmakerStatus.Type.SCORE_AND_CARD_SUMMARY

    @Serializable
    data class Match(@SerialName("matchid") val id: Long)
}
