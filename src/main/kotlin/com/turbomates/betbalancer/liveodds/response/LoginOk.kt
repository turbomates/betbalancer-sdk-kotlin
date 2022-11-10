package com.turbomates.betbalancer.liveodds.response

import com.turbomates.betbalancer.infrastructure.serializer.OffsetDateTimeUTCTimestampSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName
import java.time.OffsetDateTime

@Serializable
@SerialName("BetbalancerLiveOdds")
// @XmlSerialName("BetbalancerLiveOdds", "http://www.betbalancer.com/BetbalancerLiveOdds", "")
data class LoginOk(
    @Serializable(with = OffsetDateTimeUTCTimestampSerializer::class)
    @XmlElement(false)
    override val timestamp: OffsetDateTime,
    override val replyType: ReplyType? = null,
    @XmlElement(true)
    @XmlSerialName("status", "", "")
    override val status: Status
) : LiveOdds() {
    // @XmlElement(false)
    // override val status = Status.LOGIN_OK
}
