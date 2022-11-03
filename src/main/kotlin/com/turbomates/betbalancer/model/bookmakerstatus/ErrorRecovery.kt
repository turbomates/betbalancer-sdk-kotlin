@file:UseSerializers(OffsetDateTimeSerializer::class, BooleanSerializer::class)

package com.turbomates.betbalancer.model.bookmakerstatus

import com.turbomates.betbalancer.infrastructure.serilizer.BooleanSerializer
import com.turbomates.betbalancer.infrastructure.serilizer.OffsetDateTimeSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
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
    @SerialName("timestamp")
    val timestamp: OffsetDateTime? = null,
) : BookmakerStatus {
    @XmlElement(false)
    override val type = BookmakerStatus.Type.ERROR

    @Serializable
    data class Match(
        @SerialName("matchid")
        val id: Long,
        @SerialName("active")
        val isActive: Boolean
    )
}
