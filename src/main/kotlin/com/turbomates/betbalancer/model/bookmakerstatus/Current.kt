@file:UseSerializers(OffsetDateTimeFromLongSerializer::class)

package com.turbomates.betbalancer.model.bookmakerstatus

import com.turbomates.betbalancer.infrastructure.serializer.OffsetDateTimeFromLongSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import nl.adaptivity.xmlutil.serialization.XmlElement
import java.time.OffsetDateTime

@Serializable
@SerialName("BookmakerStatus")
data class Current(
    @SerialName("bookmakerid")
    override val bookmakerId: Int,
    @Serializable
    val timestamp: OffsetDateTime,
    val match: Match
) : BookmakerStatus {
    @XmlElement(false)
    override val type = BookmakerStatus.Type.CURRENT

    @Serializable
    data class Match(@SerialName("matchid") val id: Long)
}
