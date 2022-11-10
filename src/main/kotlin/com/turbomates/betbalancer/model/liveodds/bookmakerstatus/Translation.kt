package com.turbomates.betbalancer.model.liveodds.bookmakerstatus

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import nl.adaptivity.xmlutil.serialization.XmlElement
import java.util.Locale

@Serializable
@SerialName("BookmakerStatus")
data class Translation(
    @SerialName("bookmakerid")
    override val bookmakerId: Int,
    @Transient
    val languages: List<Locale> = listOf()
) : BookmakerStatus {
    @XmlElement(false)
    override val type = BookmakerStatus.Type.GET_TRANSLATION

    @SerialName("languages")
    @Suppress("VariableNaming", "unused")
    val _languages = languages.joinToString(",") { it.language }
}
