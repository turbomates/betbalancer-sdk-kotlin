package com.turbomates.betbalancer.model.bookmakerstatus

import com.turbomates.betbalancer.infrastructure.serializer.BooleanIntSerializer
import com.turbomates.betbalancer.infrastructure.serializer.OffsetDateTimeUNIXTimestampSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement
import java.time.OffsetDateTime

@Serializable
@SerialName("BookmakerStatus")
data class ErrorRecovery(
    @SerialName("bookmakerid")
    override val bookmakerId: Int,
    val match: Match,
    @SerialName("msgnr")
    val messageId: Long? = null,
    @SerialName("msgfrom")
    val messageFromId: Long? = null,
    @SerialName("msgto")
    val messageToId: Long? = null,
    @Serializable(with = OffsetDateTimeUNIXTimestampSerializer::class)
    @SerialName("timestamp")
    val timestamp: OffsetDateTime? = null,
) : BookmakerStatus {
    @XmlElement(false)
    override val type = BookmakerStatus.Type.ERROR

    @Serializable
    data class Match(
        @SerialName("matchid")
        val id: Long,
        @Serializable(with = BooleanIntSerializer::class)
        @SerialName("active")
        val isActive: Boolean
    )
}
