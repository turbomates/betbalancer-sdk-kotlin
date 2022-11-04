@file:UseSerializers(OffsetDateTimeSerializer::class)

package com.turbomates.betbalancer.model

import com.turbomates.time.OffsetDateTimeSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers
import java.time.OffsetDateTime

@Serializable
data class Timestamp(
    @SerialName("CreatedTime")
    val createdAt: OffsetDateTime,
    @SerialName("TimeZone")
    val timezone: String = "UTC"
)
