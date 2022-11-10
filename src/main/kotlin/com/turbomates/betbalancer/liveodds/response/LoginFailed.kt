package com.turbomates.betbalancer.liveodds.response

import com.turbomates.betbalancer.infrastructure.serializer.OffsetDateTimeUTCTimestampSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName
import java.time.OffsetDateTime

// @Serializable
// @XmlSerialName("BetbalancerLiveOdds", "http://www.betbalancer.com/BetbalancerLiveOdds", "")
// data class LoginFailed(
//     @Serializable(with = OffsetDateTimeUTCTimestampSerializer::class)
//     override val timestamp: OffsetDateTime,
//     override val replyType: ReplyType? = null
// ) : LiveOdds(Status.LOGIN_FAILED)
