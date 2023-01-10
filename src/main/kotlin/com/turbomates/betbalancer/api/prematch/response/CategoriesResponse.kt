package com.turbomates.betbalancer.api.prematch.response

import com.turbomates.betbalancer.model.Category
import com.turbomates.betbalancer.model.Timestamp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("BetbalancerBetData")
data class CategoriesResponse(
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
}
