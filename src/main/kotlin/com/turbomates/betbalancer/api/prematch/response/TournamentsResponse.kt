package com.turbomates.betbalancer.api.prematch.response

import com.turbomates.betbalancer.model.Timestamp
import com.turbomates.betbalancer.model.Tournament
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("BetbalancerBetData")
data class TournamentsResponse(
    @SerialName("Timestamp")
    val timestamp: Timestamp,
    val sports: Sports
) {
    @Serializable
    data class Sports(val list: List<Sport>) {
        @Serializable
        data class Sport(
            @SerialName("BetbalancerSportID")
            val id: Int,
            val category: Category
        )
    }

    @Serializable
    @SerialName("Category")
    data class Category(
        @SerialName("BetbalancerCategoryID")
        val id: Int,
        val tournaments: List<Tournament>
    )
}
