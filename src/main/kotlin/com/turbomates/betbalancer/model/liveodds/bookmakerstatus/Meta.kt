package com.turbomates.betbalancer.model.liveodds.bookmakerstatus

import com.turbomates.betbalancer.infrastructure.serializer.BooleanStringSerializer
import com.turbomates.betbalancer.infrastructure.serializer.OffsetDateTimeUTCTimestampSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement
import java.time.OffsetDateTime

@Serializable
@SerialName("BookmakerStatus")
data class Meta(
    @SerialName("bookmakerid")
    override val bookmakerId: Int,
    @Serializable(with = OffsetDateTimeUTCTimestampSerializer::class)
    @SerialName("metafrom")
    val metaFrom: OffsetDateTime? = null,
    @Serializable(with = OffsetDateTimeUTCTimestampSerializer::class)
    @SerialName("metato")
    val metaTo: OffsetDateTime? = null,
    @Serializable(with = BooleanStringSerializer::class)
    @SerialName("includeavailable")
    val includeAvailable: Boolean? = null,
    val matches: List<Match>
) : BookmakerStatus {
    @XmlElement(false)
    override val type = BookmakerStatus.Type.META

    @Serializable
    data class Match(@SerialName("matchid") val id: Long)
}
