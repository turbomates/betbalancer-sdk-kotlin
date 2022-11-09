package com.turbomates.betbalancer.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("Category")
data class Category(
    @SerialName("BetbalancerCategoryID")
    val id: Int,
    val translatedNames: Names
)
