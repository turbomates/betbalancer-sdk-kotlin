package com.turbomates.betbalancer.model.bookmakerstatus

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Suppress("unused")
interface BookmakerStatus {
    val bookmakerId: Int
    val type: Type

    @Serializable
    enum class Type {
        @SerialName("login")
        LOGIN,

        @SerialName("current")
        CURRENT,

        @SerialName("error")
        ERROR,

        @SerialName("meta")
        META,

        @SerialName("gettranslation")
        GET_TRANSLATION,

        @SerialName("status")
        STATUS,

        @SerialName("change")
        CHANGE,

        @SerialName("bookmatch")
        BOOK_MATCH,

        @SerialName("scoreandcardsummary")
        SCORE_AND_CARD_SUMMARY,

        @SerialName("register")
        REGISTER,

        @SerialName("unregister")
        UNREGISTER
    }
}
