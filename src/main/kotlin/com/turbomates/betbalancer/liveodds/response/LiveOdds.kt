package com.turbomates.betbalancer.liveodds.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlSerialName
import java.time.OffsetDateTime

@Serializable
@XmlSerialName("BetbalancerLiveOdds", "http://www.betbalancer.com/BetbalancerLiveOdds", "")
sealed class LiveOdds {
    abstract val status: Status
    abstract val timestamp: OffsetDateTime
    abstract val replyType: ReplyType?

    @Serializable
    @XmlSerialName("BetbalancerLiveOdds", "http://www.betbalancer.com/BetbalancerLiveOdds", "")
    enum class Status {
        @SerialName("loginok")
        LOGIN_OK,

        @SerialName("loginfailed")
        LOGIN_FAILED,

        @SerialName("betstop")
        BET_STOP,

        @SerialName("betstart")
        BET_START,

        @SerialName("alive")
        ALIVE,

        @SerialName("clearbet")
        CLEAR_BET,

        @SerialName("rollback")
        ROLLBACK,

        @SerialName("change")
        CHANGE,

        @SerialName("score")
        SCORE,

        @SerialName("cards")
        CARDS,

        @SerialName("error")
        ERROR,

        @SerialName("cancelbet")
        CANCEL_BET,

        @SerialName("undecancelbet")
        UNDECANCEL_BET,

        @SerialName("meta")
        META
    }

    @Serializable
    enum class ReplyType {
        @SerialName("error")
        ERROR,

        @SerialName("current")
        CURRENT,

        @SerialName("register")
        REGISTER,

        @SerialName("unregister")
        UNREGISTER,

        @SerialName("scoreandcardsummary")
        SCORE_AND_CARDS_SUMMARY
    }
}
